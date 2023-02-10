from random import choice
from psa.actuador import ESQ, DIR, FRT
from ecr.comportamento import Comportamento
from ecr.resposta import Resposta
from psa.accao import Mover

class Explorar(Comportamento):

	def activar(self,_):#o _ é um parâmetro anônimo
		escolha = choice([(1,ESQ),(1,FRT),(1,DIR)])
		accao = Mover(escolha[1])
		return Resposta(accao)