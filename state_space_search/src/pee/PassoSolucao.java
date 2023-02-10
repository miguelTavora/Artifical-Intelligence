package pee;

import pee.modprob.Estado;
import pee.modprob.Operador;

public interface PassoSolucao {
	//classe que representa um dos passos ate chegar a solução
	
	public Estado getEstado();
	
	public Operador getOperador();
	
	
	//custo do passo até aquele passo
	public double getCusto();
}
