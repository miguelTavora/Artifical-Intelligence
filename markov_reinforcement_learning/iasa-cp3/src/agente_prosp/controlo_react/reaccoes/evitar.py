from psa.actuador import ESQ, FRT
from psa.accao import Rodar
from ecr.reaccao import Reaccao
from ecr.resposta import Resposta

class Evitar(Reaccao):

	#estimulo booleano como se obstaculo ou não
	def _detectar_estimulo(self, percepcao):
		return percepcao[FRT].obstaculo and percepcao[FRT].contacto

	def _gerar_resposta(self, estimulo):
		return Resposta(Rodar(ESQ))



