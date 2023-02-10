from plan.planeador import Planeador
from plan.plan_pee.problema_plan import ProblemaPlan

class PlanPEE(Planeador):

	def __init__(self,mec_pee):
		self.__mec_pee = mec_pee
		self.__plano = []

	#estado final é o primeiro objetivo dos objectivos
	def planear(self, modelo_plan, estado_inicial,objectivos):
		operadores = modelo_plan.operadores()
		prob_plan  = ProblemaPlan(estado_inicial,objectivos[0],operadores)
		solucao = self.__mec_pee.resolver(prob_plan)

		if(solucao is not None):
			self.__plano = [no.operador for no in solucao[1:]]

	#retornar as oções
	def obter_accao(self, estado):
		if(self.__plano):
			return self.__plano.pop(0)

	#se existe algum plano pendente
	def plano_pendente(self):
		return bool(self.__plano)
        
	def terminar_plano(self):
		self.__plano = None
    
	def mostrar(self, vis, estado):
		vis.plano(estado, self.__plano)