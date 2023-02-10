from psa.util import dirmov#dirmov é uma função lista de angulos
from plan.modelo_plan import ModeloPlan
from psa.elementos import ALVO, OBST
from controlo_delib.operador_mover import OperadorMover

class ModeloMundo(ModeloPlan):

	def __init__(self):
		self.__alterado = False
		self.__estados = None
		self.__estado = False
		self.__operadores = [OperadorMover(self, ang) for ang in dirmov()]
		self.__elementos = None#dicionario que para cada posição vai ter
							   #a informação se está vazio ou tem um alvo

	@property
	def alterado(self):
		return self.__alterado

	@property
	def estado(self):
		return self.__estado
	

	#actualizar estado agente
	#deve-se alterar o valor do alterado
	def actualizar(self, percepcao):
		self.__estado = percepcao.posicao#posição actual do agente para atualizar
		if(percepcao.imagem != self.__elementos):
			self.__elementos = percepcao.imagem
			self.__estados = percepcao.imagem.keys()
			self.__alterado = True
		else:
			self.__alterado = False
	
	def estados(self):
		return self.__estados

	def operadores(self):
		return self.__operadores

	#na representação do mundo com um estado ou coordenadas vai a elementos
	#e retorna esse elemento 
	def obter_elem(self,estado):	
		return self.__elementos.get(estado)

	def mostrar(self, vis):#dado pelo engenheiro
		alvos_obst = {k : v for (k,v) in self.__elementos.items()
					  if v in [ALVO, OBST]}

		vis.elementos(alvos_obst)
