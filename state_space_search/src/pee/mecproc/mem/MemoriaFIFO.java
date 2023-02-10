package pee.mecproc.mem;

import java.util.LinkedList;
import pee.mecproc.No;

public class MemoriaFIFO extends MemoriaProcura{
	//preciso fazer com que se comporte como uma LinkedList
	
	//primeiros a entrar primeiros a ser processados
	
	//preciso super da class memoria e utilizar o linkedlist
	public MemoriaFIFO() {
		super(new LinkedList<No>());
	}
}
