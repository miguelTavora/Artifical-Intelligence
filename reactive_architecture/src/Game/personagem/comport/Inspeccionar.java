package Game.personagem.comport;

import Game.ambiente.AccaoAmb;
import Game.ambiente.EventoAmb;
import reaccao.ComportHierarq;
import reaccao.Comportamento;
import reaccao.Reaccao;

public class Inspeccionar extends ComportHierarq{

	public Inspeccionar() {
		super(new Comportamento[] {
				new Reaccao(EventoAmb.SILENCIO, AccaoAmb.PATRULHAR),
				new Reaccao(EventoAmb.INIMIGO, AccaoAmb.APROXIMAR),
				new Reaccao(EventoAmb.RUIDO, AccaoAmb.PROCURAR)
		});
	}

}
