package pee.mecproc.mem;

import java.util.Comparator;
import java.util.PriorityQueue;

import pee.mecproc.No;

public class MemoriaPrioridade extends MemoriaProcura{

	//Qual a posi��o que se guarda o no, tendo por base o custo(neste caso)
	public MemoriaPrioridade(Comparator<No> comparador) {
		super(new PriorityQueue<No>(1,comparador));
	}

}
