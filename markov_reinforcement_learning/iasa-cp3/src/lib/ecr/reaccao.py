from ecr.comportamento import Comportamento

class Reaccao(Comportamento):

	def _detectar_estimulo(percepcao):
		raise NotImplementedError

	def _gerar_resposta(estimulo):
		raise NotImplementedError

	#self para atributos e métodos da própria instância
	def activar(self, percepcao):
		estimulo = self._detectar_estimulo(percepcao)
		if(estimulo != None and estimulo != False):#pode ser estimulo de objecto ou booleano de existir ou não
			return self._gerar_resposta(estimulo)

