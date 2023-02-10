from pdm.modelo_pdm import ModeloPDM

class PDM(ModeloPDM):

	#gama -> double 
	#delta_max -> int
	def __init__(self, gama, delta_max):
		self.__gama = gama
		self.__delta_max = delta_max

	def utilidade(self, modelo):

		S, A = modelo.S, modelo.A #S e A são métodos

		U = {s : 0 for s in S()}#como S é um método tem de se invocar

		#varrer sucessivamente
		while True:
			Uanterior = U.copy() #porque ficam as 2 a referenciar a mesma memória seria as 2 afetadas
			delta = 0
			for s in S():
				U[s] = max(self.util_accao(s, a, Uanterior, modelo) for a in A(s))
				delta = max(delta, U[s]-Uanterior[s])#maior diferença para o varrimento dos valores
			if delta < self.__delta_max:
				break

		return U #-> utilidade

	#na teoria T(s, a, sn) = p, no qual
	#T(s0, a0, s1) = 0.1
	#T(s0, a0, s2) = 0.5
	#T(s0, a0, s3) = 0.3
	# então tem-se s0 e a0 repetido e faz-se
	#T(s0, a0) = [(0.1,s1),(0.5,s2),(0.3,s3)]
	def util_accao(self, s, a, U, modelo):
		'''
        @param s: Estado
        @param a: Operador
        @param U: Utilidade
        @param modelo : ModeloPDM 
        '''

		T, R, gama = modelo.T, modelo.R, self.__gama
		return sum(p * (R(s, a, sn)+ gama * U[sn]) for (p,sn) in T(s,a))
		

	def politica(self, U, modelo):
		'''
        @param U: Utilidade
        @param modelo: Modelo 
        '''

		S, A = modelo.S, modelo.A
		politica = {}
		for s in S():
			politica[s] = max(A(s),key=lambda a: self.util_accao(s, a, U, modelo))
			#a função que se quer maximizar é o segundo argumento
			#maximiza a qualidade da ação
			#max está a funcionar como argmax
		return politica


	def resolver(self, modelo):
		U = self.utilidade(modelo)
		return (U, self.politica(U, modelo))