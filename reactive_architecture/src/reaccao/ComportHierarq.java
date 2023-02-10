package reaccao;

public class ComportHierarq implements Comportamento{
	
	private Comportamento[] comportamentos;
	
	//metodo activar faz o varrimentos dos comportamentos
	//obter a accao do comprotamento que activa o estimulo
	//se nenhuma resposta for activada nao foi nada activado retorna nulo
	
	public ComportHierarq(Comportamento[] comportamentos){
		this.comportamentos = comportamentos;
		
	}

	@Override
	public Accao activar(Estimulo estimulo) {
		for(Comportamento comportamento: comportamentos) {
			Accao accao = comportamento.activar(estimulo);
			if(accao != null)
				return accao; 
		}
		return null;
		
	}
	
	

}
