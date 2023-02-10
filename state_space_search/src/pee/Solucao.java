package pee;

import java.util.Iterator;

public interface Solucao extends Iterable<PassoSolucao>{
	//Uma configuração
	//Qual é a solução do problema 
	//qual a melhor configuração de uma mota para ficar mais resistente e leve
	//tenho um problema e quero saber quais as sequencias de passos
	//sequencia que vai desde a solução até a raiz
	//fazendo o caminho desde a solução ate a raiz
	//porque na classe No da para ir para o no antecessor ate á raiz
	
	
	
	//A solução pode ser iterada
	
	//getCusto é a soma de todos os custos do PassoSolucao, porque é a soma de todos
	//Solução é um percurso
	
	//para cada operador em conjunto de operadores
	public Iterator<PassoSolucao> iterator();//nao sei se esta bem TODO
	
	
	public int getDimensao();
	
	public double getCusto();
	
}
