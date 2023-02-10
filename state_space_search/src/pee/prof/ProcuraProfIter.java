package pee.prof;

import pee.Solucao;
import pee.modprob.Problema;

public class ProcuraProfIter extends ProcuraProf {
	
	private int incProf;
	
	public ProcuraProfIter(int incProf) {
		super();//para n�o esconder construtor super class
		this.incProf = incProf;
	}
	
	public int getIncProf() {
		return this.incProf;
	}
	
	public void setIncProf(int incProf) {
		this.incProf = incProf;
	}
	
	//procura at� ao valor passado como profundidade maxima
	//com passos passados como incremento se for 3 vai de profundidade 3 para 6 depois 9...
	//caso chegue ao m�ximo n�o encontre n�o encontrou solu��o caso encontre dentro
	//do limite profMax retorna solucao
	@Override
	public Solucao resolver(Problema problema, int profMax) {
		int prof = incProf;
		
		while(incProf < profMax) {
			Solucao solucao = super.resolver(problema, prof);
			prof= prof+incProf;
			if(solucao != null) return solucao;
		}
		
		return null;
	}

}
