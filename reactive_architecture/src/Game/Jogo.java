package Game;

import Game.ambiente.Ambiente;
import Game.personagem.Personagem;

public class Jogo {
	
	//contrutores explicitos para quem nao tem conhecimento muito bom
	//ajuda a estruturar as ideias e etc
	//niveis mais altos deve-se usar construtores implicitos
	private static Ambiente ambiente = new Ambiente();
	private static Personagem personagem = new Personagem(ambiente);
	
	
	
	
	
	
	public static void executar() {
		
		boolean s = true;
		
		do {
			personagem.executar();
			ambiente.evoluir();
		}
		while(s);
		
		

	}
	
	public static void main(String[] args) {
		executar();
	}

}
