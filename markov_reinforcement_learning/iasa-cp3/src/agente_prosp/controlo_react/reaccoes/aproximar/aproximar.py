from ecr.prioridade import Prioridade
from psa.actuador import FRT, DIR, ESQ
from controlo_react.reaccoes.aproximar.aproximar_direcional import AproximarDir

class Aproximar(Prioridade):

	def __init__(self):
		super().__init__([AproximarDir(ESQ),AproximarDir(FRT),AproximarDir(DIR)])
