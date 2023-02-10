package Game.personagem.comport;

import Game.ambiente.AccaoAmb;
import Game.ambiente.EventoAmb;
import reaccao.ComportHierarq;
import reaccao.Comportamento;
import reaccao.Reaccao;

public class Defender extends ComportHierarq{

	public Defender() {
		super(new Comportamento[] {
				new Reaccao(EventoAmb.FUGA, AccaoAmb.PROCURAR),
				new Reaccao(EventoAmb.INIMIGO, AccaoAmb.ATACAR)
		});
		
	}

}
