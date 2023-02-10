import psa
from psa.agente import Agente
from psa.accao import Avancar

class AgenteTeste(Agente):
	def executar(self):
		self.actuador.actuar(Avancar())


#iniciar plataforma
psa.iniciar("amb/amb1.das")

#executar o agente
psa.executar(AgenteTeste())
