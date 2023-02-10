package pee.mecproc.mem;

import java.util.HashMap;
import java.util.Queue;

import pee.mecproc.No;
import pee.modprob.Estado;

public class MemoriaProcura{
	//operador raiz nao tem antecessor nem operador
	protected Queue<No> fronteira;
	
	//lista que guarda os nós já explorados
	protected HashMap<Estado, No> explorados;
	
	//tem de implementar operações tipicas sequencia
	public MemoriaProcura(Queue<No> fronteira) {
		this.fronteira = fronteira;
		explorados = new HashMap<Estado, No>();
	}
	
	//coloca a fronteira vazia
	public void limpar() {
		fronteira.clear();
		explorados.clear();
	}
	
	//pode ser varias formas inserir no
	public void inserir(No no) {
		Estado estado = no.getEstado();
		No noMemoria = explorados.get(estado);
		
		if (noMemoria == null ? true : (no.getCusto() < noMemoria.getCusto())) {
			fronteira.add(no);
			explorados.put(estado, no);
		}
	}
	
	//remover sempre o primeiro, o método poll retorna null se estiver vazio
	public No remover() {
		return fronteira.poll();
	}
	
	//retorna se a fronteira ja esta vazia
	public boolean fronteiraVazia() {
		return fronteira.isEmpty();
	}
	
	public Queue<No> getFronteira(){
		return this.fronteira;
	}

}
