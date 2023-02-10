from ecr.hierarquia import Hierarquia
from controlo_react.reaccoes.contornar import Contornar
from controlo_react.reaccoes.evitar import Evitar
from controlo_react.reaccoes.explorar import Explorar
from controlo_react.reaccoes.aproximar.aproximar import Aproximar

class Recolher(Hierarquia):

	def __init__(self):
		super().__init__([Evitar(), Contornar(), Aproximar(), Explorar()])
