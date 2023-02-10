package plantraj.modprob;

import pee.modprob.Estado;
import pee.modprob.Problema;

public class ProblemaPlanTraj extends Problema{

	private  EstadoLocalidade estadoFinal;
	
	//converter localidades em estados antes de chamar super pelo EstadoLocalidade
	public ProblemaPlanTraj(String loclni,String locFin,OperadorLigacao[] operadores ) {
		super(new EstadoLocalidade(loclni),operadores);//super classe para n�o perder informa��o e converter de localidade para Estado
		this.estadoFinal = new EstadoLocalidade(locFin);
	}
	
	//se o estado � o objetivo do problema retorna true
	@Override
	public boolean objectivo(Estado estado) {
		return estado.equals(estadoFinal);
	}
	
}
