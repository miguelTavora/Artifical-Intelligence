package pee.mecproc;

import pee.PassoSolucao;
import pee.modprob.Estado;
import pee.modprob.Operador;

public class No implements PassoSolucao{
	//Cada nó é remetente a um estado, provem de um antecessor 
	//e um operador excepto o no raiz
	
	private int profundidade = 0;
	private double custo = 0;
	private No antecessor;
	private Operador operador;
	private Estado estado;
	
	//estado iniciar do metodo
	public No(Estado estado) {
		this.estado = estado;
	}
	
	//construir um no para o qual foi possivel obter
	public No(Estado estado, Operador operador, No antecessor) {
		this.estado = estado;
		this.operador = operador;
		this.antecessor = antecessor;
		//profundidade desde o ultimo nó até ao presente
		this.profundidade = this.antecessor.profundidade+1;
		//custo acumulado até ao nó mais o custo do ultimo nó até ao presente
		this.custo = this.antecessor.getCusto() + operador.custo(antecessor.getEstado(), estado);
	}
	
	public Estado getEstado() {
		return this.estado;
	}
	
	public Operador getOperador() {
		return this.operador;
	}
	
	public No getAntecessor() {
		return this.antecessor;
	}
	
	public int getProfundidade() {
		return this.profundidade;
	}
	
	public double getCusto() {
		return this.custo;
	}

}
