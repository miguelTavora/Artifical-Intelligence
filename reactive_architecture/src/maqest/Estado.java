package maqest;

import java.util.HashMap;
import java.util.Map;

public class Estado<EV> {
	
	//Evento detemernina o estado que vai transitar, associa evento ao proximo
	//estado
	private Map<EV,Estado<EV>> transicoes;
	
	private String nome;
	
	public Estado(String nome) {
		this.nome = nome;
		transicoes = new HashMap<EV,Estado<EV>>();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	//evento produz a transicao para o estado
	public Estado<EV> transicao(EV evento, Estado<EV> estado){
		transicoes.put(evento, estado);
		return this;//retornar a instancia do objeto para o encadeamento fazer o encadeamento de metodos
	}
	
	//se n houver novo estado retorna null proprio do metodo get
	public Estado<EV> processar(EV evento) {
		return transicoes.get(evento);
	}
	
	//nome que representa o estado
	public String toString() {
		return ""+transicoes.toString();//transicoes.get(nome); //transicoes.toString();
	}

}
