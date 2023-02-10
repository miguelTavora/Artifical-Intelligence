class Resposta:

	def __init__(self, accao, prioridade = 0):
		self.__accao = accao
		self.__prioridade = prioridade

	#property é para defenir variável de read-only
	@property
	def accao(self):
		return self.__accao
		

	@property
	def prioridade(self):
		return self.__prioridade
	
