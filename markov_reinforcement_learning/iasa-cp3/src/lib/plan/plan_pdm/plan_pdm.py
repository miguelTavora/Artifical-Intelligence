from plan.planeador import Planeador
from pdm.pdm import PDM
from plan.plan_pdm.modelo_pdm_plan import ModeloPDMPlan

class PlanPDM(Planeador):

	def __init__(self):
		self.__gama = 0.85#valor dado pelo prof
		self.__delta_max = 1#valor dado pelo prof
		self.__utilidade = {}# Map <Estado, double>
		self.__politica = {}# Map <Estado, Operador>
		self.__pdm = PDM(self.__gama, self.__delta_max)

	#produzir estrutura interna para o agente realizar tarefa baseado em utilidade e politica
	def planear(self, modelo_plan, estado, objectivos):
		self.__utilidade, self.__politica = self.__pdm.resolver(ModeloPDMPlan(modelo_plan,objectivos))
		
	#obter qual a ação a executar que está na politica
	def obter_accao(self, s):
		if(self.__politica):
			return self.__politica.get(s)
		

	def plano_pendente(self):
		return bool(self.__politica)


	def terminar_plano(self):
		self.__politica = {}

	def mostrar(self, vis, estado):
		if(self.__politica):
			vis.campo(self.__utilidade)
			vis.politica(self.__politica)
			vis.marcar([estado], linha=1)