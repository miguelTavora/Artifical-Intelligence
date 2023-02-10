package puzzleRes.modprob;

import pee.modprob.Estado;
import pee.modprob.Operador;
import puzzle.Puzzle;

public class OperadorPuzzle implements Operador {
	
	private int custoMovimento;
	private Puzzle.Movimento movimento;
	
	//guardar os movimentos em forma de estados
	public OperadorPuzzle(Puzzle.Movimento movimento , int custo) {
		this.movimento = movimento;
		this.custoMovimento = custo;

	}
	
	//criar um puzzle novo para o movimento dado (se der)
	@Override
	public Estado aplicar(Estado estado) {
		EstadoPuzzle estadoAtual = (EstadoPuzzle)estado;
		Puzzle puzzleNovo = estadoAtual.getPuzzle().movimentar(movimento);
		
		if(puzzleNovo != null) 
			return new EstadoPuzzle(puzzleNovo);
		
		return null;
	}
	
	//custo de ligação entre localidade associado ao estado e o estado secu também localidade
	@Override
	public double custo(Estado estado, Estado estadoSuc) {
		return (double) custoMovimento;
	}

}
