package pee.modprob;

public abstract class ProblemaHeur extends Problema{

	public ProblemaHeur(Estado estadoInicial, Operador[] operadores) {
		super(estadoInicial, operadores);
	}
	
	//Método que calcula a heuristica através do estado
	public abstract double heurista(Estado estado);

}
