package pee.modprob;

public abstract class Estado {
	
	//Posi��o do puzzle
	
	//permite saber se os duas instancias da classe sao iguais ou nao, ou seja, estados
	public boolean equals(Object obj) {//obten��o do identificador do objecto unico
		if(obj.hashCode() == hashCode()) {
			return true;
		}
		return false;
	}
	
	//retorna uma identifica��o unica em forma de inteiro para cada instancia
	public abstract int hashCode();//permite obter 

}
