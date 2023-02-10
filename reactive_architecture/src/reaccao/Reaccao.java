package reaccao;

public class Reaccao implements Comportamento{
	
	Estimulo estimulo;
	Accao accao;
	
	public Reaccao(Estimulo estimulo, Accao resposta) {
		this.accao = resposta;
		this.estimulo = estimulo;
		
	}
	
	public Accao activar (Estimulo estimulo) {
		return (this.estimulo == estimulo) ? this.accao:null;
			

	}

}
