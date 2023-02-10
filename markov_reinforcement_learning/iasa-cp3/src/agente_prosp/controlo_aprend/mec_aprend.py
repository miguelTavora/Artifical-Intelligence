from aprend_ref.aprend_q import AprendQ
from aprend_ref.sel_acao_greedy import SelAcaoEGreedy
from aprend_ref.memoria_esparsa import MemoriaEsparsa

import psa

class MecAprend():

	def __init__(self, acoes):
		self.__acoes = acoes
		self.__mem_aprend = MemoriaEsparsa(0.01)
		self.__sel_acao = SelAcaoEGreedy(self.__mem_aprend,self.__acoes,0.01)
		self.__aprend_ref = AprendQ(self.__mem_aprend,self.__sel_acao,0.5,0.9)#aprendQ precisa seletor ações

	#expor o contrato para fora
	def aprender(self,s, a, r, sn):
		self.__aprend_ref.aprender(s,a,r,sn)
		self.mostrar(sn)

	def selecionar_acao(self, s):
		return self.__sel_acao.selecionar_acao(s)

	def mostrar(self, s):
		psa.vis(1).limpar()#visualizador inferior
		psa.vis(1).aprendref(self.__aprend_ref)
		psa.vis(2).accoesestado(s, self.__acoes, self.__mem_aprend.memoria)#vis vetorial
