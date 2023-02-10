package pee.modprob;

public abstract class ProblemaHeur extends Problema{

	public ProblemaHeur(Estado estadoInicial, Operador[] operadores) {
		super(estadoInicial, operadores);
	}
	
	//M�todo que calcula a heuristica atrav�s do estado
	public abstract double heurista(Estado estado);

}
