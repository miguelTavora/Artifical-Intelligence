package pee.mecproc.mem;

import java.util.Collections;
import java.util.LinkedList;

import pee.mecproc.No;

public class MemoriaLIFO extends MemoriaProcura{
	//primeiros a ser processados sao os mais recentes

	//priviligia os nos mais recentes
	//Não é instanciado Collections
	public MemoriaLIFO() {
		super(Collections.asLifoQueue(new LinkedList<No>()));//aslifoQueue
	}

}
