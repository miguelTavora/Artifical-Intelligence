package pee.mecproc;

import java.util.Iterator;
import java.util.LinkedList;

import pee.PassoSolucao;
import pee.Solucao;

public class Percurso implements Solucao{
	
	//objectos que eles proprios ja tem um metodo iterator
	private LinkedList<PassoSolucao> percurso = new LinkedList<PassoSolucao>();

	
	//devolver o metodo iterator do linkedlist porque ele proprio ja tem um metodo iterador
	@Override
	public Iterator<PassoSolucao> iterator() {
		return percurso.iterator();
	}

	
	//numero passos
	@Override
	public int getDimensao() {
		return percurso.size();
	}

	
	//custo comulativo dos diversos nos
	@Override
	public double getCusto() {
		return getDimensao() != 0 ? percurso.getLast().getCusto() : 0;
	}
	
	
	public void juntarInicio(No no) {
		percurso.addFirst(no);
	}
	
}
