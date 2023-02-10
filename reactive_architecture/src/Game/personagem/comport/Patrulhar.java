package Game.personagem.comport;

import reaccao.ComportHierarq;
import reaccao.Comportamento;
import reaccao.Reaccao;
import Game.ambiente.EventoAmb;
import Game.ambiente.AccaoAmb;

public class Patrulhar extends ComportHierarq{

	public Patrulhar() {
		super(new Comportamento[] {
				new Reaccao(EventoAmb.SILENCIO, AccaoAmb.PATRULHAR),
				new Reaccao(EventoAmb.INIMIGO, AccaoAmb.APROXIMAR),
				new Reaccao(EventoAmb.RUIDO, AccaoAmb.APROXIMAR)
		});
	}

}
