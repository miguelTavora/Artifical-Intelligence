package pee;

import java.util.Iterator;

public interface Solucao extends Iterable<PassoSolucao>{
	//Uma configura��o
	//Qual � a solu��o do problema 
	//qual a melhor configura��o de uma mota para ficar mais resistente e leve
	//tenho um problema e quero saber quais as sequencias de passos
	//sequencia que vai desde a solu��o at� a raiz
	//fazendo o caminho desde a solu��o ate a raiz
	//porque na classe No da para ir para o no antecessor ate � raiz
	
	
	
	//A solu��o pode ser iterada
	
	//getCusto � a soma de todos os custos do PassoSolucao, porque � a soma de todos
	//Solu��o � um percurso
	
	//para cada operador em conjunto de operadores
	public Iterator<PassoSolucao> iterator();//nao sei se esta bem TODO
	
	
	public int getDimensao();
	
	public double getCusto();
	
}
