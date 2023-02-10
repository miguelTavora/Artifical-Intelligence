from psa.actuador import ESQ, FRT, DIR
from ecr.reaccao import Reaccao
from ecr.resposta import Resposta
from psa.accao import Mover

class Contornar(Reaccao):

	def _detectar_estimulo(self, percepcao):
		return (percepcao[DIR].obstaculo and percepcao[DIR].contacto) or (percepcao[ESQ].obstaculo and percepcao[ESQ].contacto)

	def _gerar_resposta(self, estimulo):
		return Resposta(Mover(FRT))



