from aprend_ref.sel_acao import SelAcao
import random

class SelAcaoEGreedy(SelAcao):

	def __init__(self, mem_aprend, acoes, epsilon):
		self.__mem_aprend = mem_aprend
		self.__acoes = acoes#List <Accao>
		self.__epsilon = epsilon#varia entre 0-1 define valores 

	def selecionar_acao(self, s):#rever
		rd = random.random()
		if(rd <= self.__epsilon):#epsilon define prob de valor aleatorio
			return self.explorar(s)
		else:
			return self.max_acao(s)

	#selecionar a ação com prob 1-epsilon, para ser greedy
	def max_acao(self, s):
		random.shuffle(self.__acoes)
		return max(self.__acoes, key=lambda a: self.__mem_aprend.obter(s,a))#o max tem de funcionar como argmax

	#accao aleatoria
	def explorar(self, s):
		rd = random.randint(0, len(self.__acoes)-1)
		return self.__acoes[rd]


	@property
	def accoes(self):
		return self.__acoes
	
