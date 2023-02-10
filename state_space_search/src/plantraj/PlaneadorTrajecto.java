package plantraj;

import java.util.Scanner;

import pee.PassoSolucao;
import pee.Solucao;
import pee.larg.ProcuraLarg;
import pee.melhorprim.ProcuraCustoUnif;
import pee.prof.ProcuraProf;
import plantraj.modprob.OperadorLigacao;
import plantraj.modprob.ProblemaPlanTraj;

public class PlaneadorTrajecto {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner (System.in);
		System.out.print("Localidade inicial -> Loc-");
		
		String ini = "Loc-"+(input.nextLine());
		System.out.print("Localidade final -> Loc-");
		String fin = "Loc-"+(input.nextLine());
		
		System.out.println("Pesquisa por Profundidade           -> prof");
		System.out.println("Pesquisa por Largura                -> larg");
		System.out.println("Pesquisa por Profundidade Iterativa -> itr");
		System.out.println("Pesquisa por Custo Uniforme         -> uni");
		System.out.println("Pesquisa por (prof/ larg/ itr/ uni) ->");
		String cout = input.nextLine();
		
		// Cria um problema com o input do utilizador
		ProblemaPlanTraj prob = new ProblemaPlanTraj (ini, fin, definirOperadores());
		
		Solucao sol;
		
		// Conforme o input, resolver o problema com a procura desejada
		switch (cout) {
		case "prof":
			System.out.println("Procura por Profundidade");
			sol = new ProcuraProf().resolver(prob);
			break;
			
		case "larg":
			System.out.println("Procura por largura");
			sol = new ProcuraLarg().resolver(prob,6);
			break;
			
		case "itr":
			System.out.println("Introduza a profundidade Máxima");
			int profMax = Integer.parseInt(input.nextLine());
			System.out.println("Procura por Profundidade Iterativa");
			sol = new ProcuraProf().resolver(prob,profMax);
			break;
			
		case "uni":
			System.out.println("Procura por Custo Uniforme");
			sol = new ProcuraCustoUnif().resolver(prob);
			break;
			
			
		default:
			System.out.println("Procura por Profundidade de 2 unidades");
			sol = new ProcuraProf().resolver(prob, 2);
			break;
		}

		mostrarTrajecto(sol);
		
	}

	// instanciar array operadores com a tabela slides
	// gerar um array com operadores
	private static OperadorLigacao[] definirOperadores() {
		OperadorLigacao[] ops = { new OperadorLigacao("Loc-0", "Loc-1", 5), new OperadorLigacao("Loc-0", "Loc-2", 25),
				new OperadorLigacao("Loc-1", "Loc-3", 12), new OperadorLigacao("Loc-1", "Loc-6", 5),
				new OperadorLigacao("Loc-2", "Loc-4", 30), new OperadorLigacao("Loc-3", "Loc-2", 10),
				new OperadorLigacao("Loc-3", "Loc-5", 5), new OperadorLigacao("Loc-4", "Loc-3", 2),
				new OperadorLigacao("Loc-5", "Loc-6", 8), new OperadorLigacao("Loc-5", "Loc-4", 10),
				new OperadorLigacao("Loc-6", "Loc-3", 15) };
		return ops;

	}

	private static void mostrarTrajecto(Solucao solucao) {// trajecto e composto passosSolucao
		// iterar os varios paços solucção
		if (solucao != null) {
			for (PassoSolucao passo : solucao) {
				System.out.println(passo.getEstado().toString());
			}
			return;
		}
		System.out.println("Não existe solução");
	}
}
