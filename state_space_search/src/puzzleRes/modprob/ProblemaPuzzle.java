package puzzleRes.modprob;

import pee.modprob.Estado;
import pee.modprob.ProblemaHeur;

public class ProblemaPuzzle extends ProblemaHeur {

	private EstadoPuzzle puzzleFinal;
	private boolean heuristica;

	// converter localidades em estados antes de chamar super pelo EstadoLocalidade
	public ProblemaPuzzle(EstadoPuzzle confInicial, EstadoPuzzle confFinal, OperadorPuzzle[] operadores) {
		super(confInicial, operadores);// super classe para não perder informação
		this.puzzleFinal = confFinal;
	}

	public ProblemaPuzzle(EstadoPuzzle estadoInicial, EstadoPuzzle estadoFinal, OperadorPuzzle[] operadores,boolean heuristica) {
		super(estadoInicial, operadores);
		this.puzzleFinal = estadoFinal;
		this.heuristica = heuristica;
	}

	// se o estado é o objetivo do problema retorna true
	@Override
	public boolean objectivo(Estado estado) {
		return estado.equals(puzzleFinal);
	}

	@Override
	public double heurista(Estado estado) {
		EstadoPuzzle est = (EstadoPuzzle) estado;
		if (heuristica)
			return est.getPuzzle().numPecasForaLugar(puzzleFinal.getPuzzle());
		else
			return est.getPuzzle().distManhattan(puzzleFinal.getPuzzle());
	}

}
