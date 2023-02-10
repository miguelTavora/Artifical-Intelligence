package plantraj.modprob;

import pee.modprob.Estado;
import pee.modprob.Operador;

public class OperadorLigacao implements Operador{
	private int custoLigacao;
	private EstadoLocalidade estadoOrigem;
	private EstadoLocalidade estadoDestino;
	
	public OperadorLigacao(String locIni, String locFin, int custo) {//guardar a informa��o forma de estados
		estadoOrigem = new EstadoLocalidade(locIni);
		estadoDestino = new EstadoLocalidade(locFin);
		this.custoLigacao = custo;

	}
	
	public Estado aplicar(Estado estado) {//estado inicial da liga��o corresponder ao estado ao qual esta a ser aplciado o operador
		if(estado.hashCode() == estadoOrigem.hashCode()) {
			return estadoDestino;
		}
		return null;
	}
	
	//custo de liga��o entre localidade associado ao estado e o estado secu tamb�m localidade
	public double custo(Estado estado, Estado estadoSuc) {//custo esta na tabela
		return (double) custoLigacao;
	}
}
