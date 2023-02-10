from psa.elementos import ALVO
from controlo_delib.modelo_mundo import ModeloMundo

import psa

class ControloDelib:

	#necessario instância modelo mundo
	def __init__(self,planeador):
		self.__planeador = planeador
		self.__modelo_mundo = ModeloMundo()
		self.__objectivos = None


	def processar(self, percepcao):
		self.__assimilar(percepcao)
		if(self.__reconsiderar()):
			self.__deliberar()
			self.__planear()

		self.mostrar()
		return self.__executar()
			

	def mostrar(self):#método dado pelo engenheiro
		 vis = psa.vis(1)
		 vis.limpar()
		 self.__planeador.mostrar(vis, self.__modelo_mundo.estado)
		 self.__modelo_mundo.mostrar(vis)

	#incorporar a informação do mundo no modelo do mundo
	#assimilar a informação do mundo
	def __assimilar(self, per):
		self.__modelo_mundo.actualizar(per)

	#função geral que diz se deve ser reconciderar ou não
	#sempre que o modelo do mundo for alterado/neste caso
	#quando não há objetivos
	def __reconsiderar(self):
		if(self.__modelo_mundo.alterado or not self.__planeador.plano_pendente() or self.__objectivos is None):
			return True
		
		return False

	#preenchar metodo objectivo com todos os estados
	#em que todo o ambiente existe um alvo
	def __deliberar(self):
		#gerar objetivos
		self.__objectivos = [estado for estado in self.__modelo_mundo.estados()
							if self.__modelo_mundo.obter_elem(estado) == ALVO]

	#se existirem objetivos realizar o planear, senao não
	def __planear(self):
		if(self.__objectivos):
			self.__planeador.planear(self.__modelo_mundo, self.__modelo_mundo.estado, self.__objectivos)
		else:
			self.__planeador.terminar_plano()

	#activar a acção associada ao operador_accao do Planeador
	def __executar(self):
		operador = self.__planeador.obter_accao(self.__modelo_mundo.estado)
		if operador:
			return operador.accao

