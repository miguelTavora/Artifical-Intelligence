package Game.personagem.comport;

import Game.ambiente.EventoAmb;
import maqest.Estado;
import maqest.MaquinaEstados;
import reaccao.ComportMaqEst;
import reaccao.Estimulo;

public class ComportPersonagem extends ComportMaqEst{
	
	@Override
	protected MaquinaEstados<Estimulo> iniciar(){
		
		//definição de estados
		Estado<Estimulo> patrulha = new Estado<Estimulo>("Patrulha");
		Estado<Estimulo> inspecao = new Estado<Estimulo>("Inspeção");
		Estado<Estimulo> defesa = new Estado<Estimulo>("Defesa");
		Estado<Estimulo> combate = new Estado<Estimulo>("Combate");
		
		
		//definição de transicoes
		patrulha.transicao(EventoAmb.INIMIGO,defesa).transicao(EventoAmb.RUIDO,inspecao)
		.transicao(EventoAmb.SILENCIO,patrulha);
		
		inspecao.transicao(EventoAmb.INIMIGO,defesa).transicao(EventoAmb.RUIDO,inspecao)
		.transicao(EventoAmb.SILENCIO,patrulha);
		
		defesa.transicao(EventoAmb.INIMIGO,combate).transicao(EventoAmb.FUGA,inspecao);
		
		combate.transicao(EventoAmb.INIMIGO,combate).transicao(EventoAmb.FUGA,patrulha)
		.transicao(EventoAmb.VITORIA,patrulha).transicao(EventoAmb.DERROTA,patrulha);
		
		//definir comportamentos
		comport(patrulha, new Patrulhar());
		comport(inspecao, new Inspeccionar());
		comport(defesa, new Defender());
		comport(combate, new Combater());
		
		//inicio maquina estados
		return new MaquinaEstados<Estimulo>(patrulha);
	}

}
