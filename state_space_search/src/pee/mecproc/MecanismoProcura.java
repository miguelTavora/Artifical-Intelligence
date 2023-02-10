package pee.mecproc;

import pee.Solucao;
import pee.mecproc.mem.MemoriaProcura;
import pee.modprob.Estado;
import pee.modprob.Operador;
import pee.modprob.Problema;

public abstract class MecanismoProcura <P extends Problema>{
	
	private MemoriaProcura memoriaProcura;
	protected P problema;
	
	private int custoTemporal = 0;
	private int custoEspacial = 0;
	
	//metodo procura nesta classe 
	//problema- tem informação estado inicial e permite saber se objetivo ou não
	//temos de limpar a memoria para um estado nao interferir no seguinte
	//vai retirar um no, se esse estado é objetivo então é solução e retorna
	//expandir é expandir a procura 
	
	public MecanismoProcura() {
		this.memoriaProcura = iniciarMemoria();
	}
	
	protected abstract MemoriaProcura iniciarMemoria();
	
	//esta procura faz até ao valor máximo que um inteiro pode ter para acabar
	//com a redundância de código
	public Solucao resolver(P problema) {
		return resolver (problema, Integer.MAX_VALUE);
	}
	
	//iniciar o atributo problema
	//solução do metodo que vai ser usado o metodo anterior mas o profMax será
	//o maior valor do inteiro possivel
	public Solucao resolver(P problema, int profMax) {
		this.problema = problema;
		memoriaProcura.remover();
		No no_inicial = new No(problema.getEstadoInicial());
		memoriaProcura.inserir(no_inicial);
		while(!memoriaProcura.fronteiraVazia()) {
			No no = memoriaProcura.remover();
			if(problema.objectivo(no.getEstado())) 
				return gerarSolucao(no);
			else
				if(no.getProfundidade() < profMax)
					expandir(no);
		}
		return null;
	}
	
	//para o nó recebido expande o nó para os diferentes nós
	private void expandir(No no) {
		Estado estado = no.getEstado();
		Operador[] operadores = problema.getOperadores();
		
		for(Operador operador: operadores) {
			Estado estadoSec = operador.aplicar(estado);
			if(estadoSec != null) {
				No noSuc = new No(estadoSec, operador, no);
				memoriaProcura.inserir(noSuc);
			}
			custoTemporal++;
		}
		if (memoriaProcura.getFronteira().size() > custoEspacial)
			custoEspacial = memoriaProcura.getFronteira().size();
	}
	
	//dado o no final gera uma solução
	//percurso espaço de dados(sequencia de passos)
	private Solucao gerarSolucao(No noFinal) {
		Percurso percurso = new Percurso();
		No no = noFinal;
		//antes do ciclo iniciar ja sabemos que é válido, seria do while se a resposta dependesse da primeira execução
		while(no  != null) {//quando nao existe antecessor acaba o ciclo
			percurso.juntarInicio(no);
			No antecessor = no.getAntecessor();
			no = antecessor;
		}
		return percurso;
	}
	
	public int getCustoTemporal() {
		return this.custoTemporal;
	}
	
	public int getCustoEspacial() {
		return this.custoEspacial;
	}

}
