package Game.personagem.comport;

import Game.ambiente.AccaoAmb;
import Game.ambiente.EventoAmb;
import reaccao.ComportHierarq;
import reaccao.Comportamento;
import reaccao.Reaccao;

public class Combater extends ComportHierarq{

	public Combater() {
		super(new Comportamento[] {
				new Reaccao(EventoAmb.INIMIGO, AccaoAmb.ATACAR),
				new Reaccao(EventoAmb.FUGA, AccaoAmb.PATRULHAR),
				new Reaccao(EventoAmb.VITORIA, AccaoAmb.PATRULHAR),
				new Reaccao(EventoAmb.DERROTA, AccaoAmb.PATRULHAR)
				
		});
	}

}
