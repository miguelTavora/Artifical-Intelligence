package pee;

import pee.modprob.Estado;
import pee.modprob.Operador;

public interface PassoSolucao {
	//classe que representa um dos passos ate chegar a solu��o
	
	public Estado getEstado();
	
	public Operador getOperador();
	
	
	//custo do passo at� aquele passo
	public double getCusto();
}
