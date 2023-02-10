from plan.modelo_plan import ModeloPlan
from pdm.modelo_pdm import ModeloPDM

class ModeloPDMPlan(ModeloPDM, ModeloPlan):

	def __init__(self, modelo_plan, objetivos):
		self.__modelo_plan = modelo_plan
		self.__objetivos = objetivos
		self.__rmax = 100 #valor dado pelo prof


	def estados(self):
		return self.__modelo_plan.estados()

	def operadores(self):
		return self.__modelo_plan.operadores()

	def S(self):
		return self.estados()
		
	def A(self,s):#ignorar o argumento s
		return self.operadores()

	def T(self, s, a):
		sn = a.aplicar(s)
		if(sn != None):
			return [(1, sn)]
		return []#retornar lista vazia


	def R(self, s, a, sn):#custo negativo porque é perda
		if(sn in self.__objetivos):
			return self.__rmax + a.custo(s, sn)
		return -1. * a.custo(s, sn)