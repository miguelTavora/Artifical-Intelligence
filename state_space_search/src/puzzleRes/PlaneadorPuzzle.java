package puzzleRes;

import pee.PassoSolucao;
import pee.Procura;
import pee.Solucao;
import pee.larg.ProcuraLarg;
import pee.melhorprim.ProcuraAA;
import pee.melhorprim.ProcuraCustoUnif;
import pee.melhorprim.ProcuraHeur;
import pee.melhorprim.ProcuraSofrega;
import pee.prof.ProcuraProf;
import pee.prof.ProcuraProfIter;
import puzzle.Puzzle;
import puzzleRes.modprob.EstadoPuzzle;
import puzzleRes.modprob.OperadorPuzzle;
import puzzleRes.modprob.ProblemaPuzzle;

public class PlaneadorPuzzle {
	
	@SuppressWarnings("unused")
	public static void main (String args[]) {
		
		int puzzle1[][]       = {{1, 2, 3},
				                 {8, 4, 5},
				                 {6, 7, 0}};
		
		int puzzle2[][]       = {{8, 4, 5},
							     {6, 1, 2},
							     {3, 7, 0}};
		
		int puzzleFinal[][]   = {{1, 2, 3},
								 {4, 5, 6},
								 {7, 8, 0}};
		
		EstadoPuzzle estado1 = new EstadoPuzzle(new Puzzle(puzzle1));
		EstadoPuzzle estado2 = new EstadoPuzzle(new Puzzle(puzzle2));
		EstadoPuzzle estadoFinal = new EstadoPuzzle(new Puzzle(puzzleFinal));
		
		
		ProblemaPuzzle prob1 = new ProblemaPuzzle(estado1, estadoFinal,criaOperadores());
		ProblemaPuzzle prob2 = new ProblemaPuzzle(estado2, estadoFinal,criaOperadores());
		ProblemaPuzzle probHeur1 = new ProblemaPuzzle(estado1, estadoFinal, criaOperadores(),false);
		ProblemaPuzzle probHeur2 = new ProblemaPuzzle(estado2, estadoFinal, criaOperadores(),false);
		
		Procura prof = new ProcuraProf();
		Procura larg = new ProcuraLarg();
		Procura profIter = new ProcuraProfIter(2);
		
		Procura custoUnif = new ProcuraCustoUnif();
		ProcuraHeur sofrega = new ProcuraSofrega();
		ProcuraHeur procAA = new ProcuraAA();
		
		//Solucao sol = prof.resolver(prob1);
		//Solucao sol = prof.resolver(prob2);
		//Solucao sol = larg.resolver(prob1);
		//Solucao sol = larg.resolver(prob2);
		//Solucao sol = profIter.resolver(prob1,50);
		//Solucao sol = profIter.resolver(prob2,50);
		//Solucao sol = custoUnif.resolver(prob1);
		//Solucao sol = custoUnif.resolver(prob2);
		//Solucao sol = sofrega.resolver(probHeur1);
		//Solucao sol = sofrega.resolver(probHeur2);
		//Solucao sol = procAA.resolver(probHeur1);
		Solucao sol = procAA.resolver(probHeur2);
		
		if (sol != null) {
			mostrarPassos(sol);
			System.out.println();
			System.out.println("Custo da solucao: " + sol.getCusto());
			System.out.println("Complexidade espacial: " + procAA.getCustoEspacial());
			System.out.println("Complexidade temporal: " + procAA.getCustoTemporal());
			
			
		}
		else {
			System.out.println("Sem solução");
			System.exit(0);
		}
	}
	
	private static OperadorPuzzle[] criaOperadores() {
		OperadorPuzzle[] operador = {new OperadorPuzzle(Puzzle.Movimento.CIMA,1),
								new OperadorPuzzle(Puzzle.Movimento.BAIXO,1),
								new OperadorPuzzle(Puzzle.Movimento.DIR,1),
								new OperadorPuzzle(Puzzle.Movimento.ESQ,1)};
		return operador;
	}
	
	private static void mostrarPassos(Solucao solucao) {
		for (PassoSolucao passo: solucao) {
			System.out.println(passo.getEstado().toString());
		}
	}
	

}
