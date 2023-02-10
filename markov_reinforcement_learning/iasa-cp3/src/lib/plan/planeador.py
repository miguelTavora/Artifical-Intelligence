class Planeador:

	def planear(self, modelo_plan, estado_inicial, objectivos):
		raise NotImplementedError

	def obter_accao(self, estado):
		raise NotImplementedError

	def plano_pendente(self):
		raise NotImplementedError

	def terminar_plano(self):
		raise NotImplementedError
