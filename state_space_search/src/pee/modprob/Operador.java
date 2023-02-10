package pee.modprob;

public interface Operador {
	
	//Deslocamento entre estados
	
	//permite aplicar a um estado um operador para transitar de estado
	public Estado aplicar(Estado estado);
	
	//permite obter o custo associado a transição de estado
	public double custo(Estado estado, Estado estadoSuc);

}
