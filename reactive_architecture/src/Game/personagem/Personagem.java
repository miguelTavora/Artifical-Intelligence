package Game.personagem;

import Game.ambiente.Ambiente;
import Game.personagem.comport.ComportPersonagem;
import reaccao.Accao;
import reaccao.Estimulo;

public class Personagem {
	
	private ComportPersonagem comportamento;
	private Ambiente ambiente;
	
	public Personagem(Ambiente ambiente) {
		this.ambiente = ambiente;
		comportamento = new ComportPersonagem();
	}
	
	public void executar() {
		if(percepcionar() != null) {
			actuar(processar(ambiente.getEvento()));
			mostrar();
		}
	}
	
	private Estimulo percepcionar() {
		return ambiente.getEvento();
	}
	
	private Accao processar(Estimulo estimulo) {
		return comportamento.activar(estimulo);
	}
	

	private void actuar(Accao accao) {
		if(accao != null) {
			accao.executar();
		}
	}
	
	private void mostrar() {
		
		System.out.println("Estado: "+comportamento.getEstado().getNome());
		
	}
	
}
