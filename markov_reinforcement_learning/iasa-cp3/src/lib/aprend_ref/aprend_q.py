from aprend_ref.aprend_ref import AprendRef

class AprendQ(AprendRef):

	def __init__(self, mem_aprend, sel_accao, alfa, gama):
		super().__init__(mem_aprend,sel_accao)
		self._alfa = alfa
		self._gama = gama

	#guarda na memoria um tupulo estado, acao com uma dada recompensa
	def aprender(self, s, a, r, sn):#s-> Estado, a -> Ação, r-> double, sn-> s' Estado
		qAnt = self._mem_aprend.obter(s,a)

		acaoSeg = self._sel_accao.max_acao(sn)
		qsaSeg = self._mem_aprend.obter(sn,acaoSeg)

		q = qAnt +self._alfa * (r + self._gama * qsaSeg  - qAnt)

		self._mem_aprend.atualizar(s, a, q)



	
