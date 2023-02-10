from ecr.comport_comp import ComportComp

class Prioridade(ComportComp):

	def __init__(self, comportamentos):
		super().__init__(comportamentos)

	def selecionar_resposta(self, respostas):
		if respostas:
			return max(respostas, key=lambda resp:resp.prioridade)
		