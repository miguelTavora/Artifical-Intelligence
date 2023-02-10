package plantraj.modprob;

import pee.modprob.Estado;

public class EstadoLocalidade extends Estado{
	//precisa de ter uma localidade
	private String localidade;
	
	public EstadoLocalidade(String localidade) {
		this.localidade = localidade;
	}
	
	public int hashCode() {//String ja tem um hashCode, retornar o hashCode da String localidade
		return localidade.hashCode();
	}
	
	public String toString() {//mostrar a localidade
		return this.localidade;
	}

}
