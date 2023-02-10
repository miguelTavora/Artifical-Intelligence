from controlo import Controlo

class ControloReact(Controlo):

	#não é feito o sistema de tipos como no UML
	def __init__(self, comportamento):
		self.__comportamento = comportamento

	#necessario verificar se existe resposta
	#devolve a accao correspondente á resposta
	def processar(self, percepcao):
		resposta = self.__comportamento.activar(percepcao)
		if(resposta != None):
			return resposta.accao