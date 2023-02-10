package reaccao;

import java.util.HashMap;
import java.util.Map;

import maqest.Estado;
import maqest.MaquinaEstados;

public abstract class ComportMaqEst implements Comportamento{
	
	private Map<Estado<Estimulo>,Comportamento> comportamentos;
	private MaquinaEstados<Estimulo> maqEst;
	private Estado<Estimulo> estado;//estado que faz associacao a um estimulo
	
	public ComportMaqEst() {
		comportamentos = new HashMap<Estado<Estimulo>,Comportamento>();
		maqEst = iniciar();
		estado = maqEst.getEstado();
	}
	
	public Estado<Estimulo> getEstado(){
		return this.estado;
	}
	
	//iniciam o atributo maquina de estados
	protected abstract MaquinaEstados<Estimulo>iniciar();
	
	@Override
	public Accao activar(Estimulo estimulo) {
		Comportamento comp = comportamentos.get(maqEst.getEstado());
		maqEst.processar(estimulo);
		estado = maqEst.getEstado();
		return comp.activar(estimulo);

	}
	
	//fazer o set do map para os comports
	public ComportMaqEst comport(Estado<Estimulo> estado, Comportamento comport) {
		comportamentos.put(estado, comport);
		return this;
	}
	
	
	
	

}
