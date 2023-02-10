from psa.util import mover, dist #mover(pos,ang) -> nova_pos
from psa.accao import Mover
from psa.elementos import VAZIO, ALVO
from pee.modprob.operador import Operador


class OperadorMover(Operador):

	def __init__(self, modelo_mundo, ang):
		self.__modelo_mundo = modelo_mundo
		self.__ang = ang
		self.__accao = Mover(self.__ang, ang_abs = True)

	@property
	def accao(self):
		return self.__accao
	

	#simular o movimento do agente
	def aplicar(self, estado):
		pos = mover(estado,self.__ang)
		elem = self.__modelo_mundo.obter_elem(pos)
		if(elem in [VAZIO, ALVO]):
			return pos


	#proprocionar a distancia, pode ser obtida pelo dist da psa,
	#custo pelo menos 1
	def custo(self, estado, novo_estado):
		return max(dist(estado,novo_estado),1)