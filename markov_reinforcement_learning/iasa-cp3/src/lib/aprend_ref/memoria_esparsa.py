from aprend_ref.memoria_aprend import MemoriaAprend

class MemoriaEsparsa(MemoriaAprend):

	def __init__(self, valor_omissao=0):
		self.__valor_omissao = valor_omissao
		self.__connector = {}

	#estrutura de dados interna para fazer conexão entre estado accao para o valor q
	def atualizar(self, s, a, q):
		self.__connector[(s,a)] = q

	#é necessário passar o valor por omissão senao caso não exista devolve none
	def obter(self, s, a):
		return self.__connector.get((s,a),self.__valor_omissao)


	@property#psa precisa desta propriedade
	def memoria(self):
		return self.__connector