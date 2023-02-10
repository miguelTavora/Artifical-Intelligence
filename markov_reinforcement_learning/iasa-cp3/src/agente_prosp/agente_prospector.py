import psa
#from psa.accao import Avancar
from psa.agente import Agente

#utilizada a classe Agente da psa
class AgenteProspector(Agente):

	#psa manda executar agente_prospetor
	#o agente deteta e o sensor multiplo devolve a percepcao
	#o agente manda o controlo processar que retorna uma accao
	#manda o atuador atuar sobre a ação 

	def __init__(self, controlo):
		self.__controlo = controlo

	#percepciona algo, processa e atua
	def executar(self):
		percepcao = self.__percepcionar()
		acao = self.__processar(percepcao)
		self.__atuar(acao)
	
	def __percepcionar(self):
		return self.sensor_multiplo.detectar()

	def __processar(self, percepcao):
		return self.__controlo.processar(percepcao)

	def __atuar(self, acao):
		if( acao is not None):#is not None verifica se é o mesmo objeto
			self.actuador.actuar(acao)