package puzzleRes.modprob;

import pee.modprob.Estado;
import puzzle.Puzzle;

public class EstadoPuzzle extends Estado{

	private Puzzle puzzle;
	
	public EstadoPuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;
	}
	
	public Puzzle getPuzzle() {
		return this.puzzle;
	}
	
	@Override
	public int hashCode() {//String ja tem um hashCode, retornar o hashCode da String localidade
		return puzzle.hashCode();
	}
	
	public String toString() {//mostrar a localidade
		return this.puzzle.toString();
	}

}
