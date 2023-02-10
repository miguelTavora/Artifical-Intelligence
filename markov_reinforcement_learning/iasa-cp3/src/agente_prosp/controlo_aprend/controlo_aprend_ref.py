from controlo import Controlo
from controlo_aprend.mec_aprend import MecAprend

from psa.accao import Mover
from psa.util import dirmov


class ControloAprendRef(Controlo):#Geração do reforço

	def __init__(self):
		self.__rmax = 100
		self.__s = None
		self.__a = None
		acoes = [Mover(ang, ang_abs=True) for ang in dirmov()]
		self.__mec_aprend = MecAprend(acoes)

	#implementa um passo do processo aprendizagem, aplicar expressao atualizar
	#obter o sn, atualizar o s e a
	def processar(self, percepcao):
		#escolher melhor ação para o estado
		sn = percepcao.posicao
		an = self.__mec_aprend.selecionar_acao(sn)


		if(self.__s != None):#primeiro não tem anterior, primeiro estado é o anteior
			r = self.__gerar_reforco(percepcao)
			self.__mec_aprend.aprender(self.__s, self.__a, r, sn)


		self.__s = sn
		self.__a = an

		return self.__a
	#reforço custo mov é uma perda
	def __gerar_reforco(self, percepcao):#percepcao.posicao posiçao atual agente

		reforco = percepcao.custo_mov*(-1)#retorna o custo do movimento do ultimo mov, mas é o modulo

		if(percepcao.carga):#retorna se atingiu o alvo
			reforco = percepcao.custo_mov+self.__rmax

		elif(percepcao.colisao):#retorna se houve colisao
			reforco = percepcao.custo_mov+(self.__rmax*-1)

		return reforco


