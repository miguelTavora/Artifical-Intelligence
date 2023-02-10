from ecr.comportamento import Comportamento

class ComportComp(Comportamento):

	def __init__(self, comportamentos):
		self.__comportamentos = comportamentos

	#metodo retorna uma resposta num conjunto respostas
	def selecionar_resposta(respostas):
		raise NotImplementedError

	#self para atributos e métodos da própria instância
	def activar(self, percepcao):
		respostas = []
		for comp in self.__comportamentos:
			comport = comp.activar(percepcao)#para não ativar 2x o comportamento, activar uma percepção e obtem resposta
			if(comport is not None):#pode se adicionar coisas a null
				respostas.append(comport)

		
		return self.selecionar_resposta(respostas)#a verificação de null é feita na prioridade