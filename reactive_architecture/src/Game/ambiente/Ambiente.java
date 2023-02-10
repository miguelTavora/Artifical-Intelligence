package Game.ambiente;

import java.util.Scanner;

public class Ambiente {
	
	private EventoAmb evento;
	private Scanner sc;
	
	public Ambiente() {
		sc = new Scanner(System.in);
	}
	
	public void evoluir() {
		evento = gerarEvento();
		mostrar();
	}
	
	public EventoAmb getEvento() {
		return this.evento;
	}
	
	private EventoAmb gerarEvento() {
		
		System.out.print("Evento? ");
		String comando = sc.next();
		
		switch(comando) {
			case "s":
				return EventoAmb.SILENCIO;
				
			case "r":
				return EventoAmb.RUIDO;
				
			case "i":
				return EventoAmb.INIMIGO;
				
			case "f":
				return EventoAmb.FUGA;
				
			case "v":
				return EventoAmb.VITORIA;
				
			case "d":
				return EventoAmb.DERROTA;
				
			case "t":
				return EventoAmb.TERMINAR;
				
			default:
				System.out.println("Não introduziu um caracter válido.");
				return null;
		}
	}
	private void mostrar() {
		System.out.println("Evento: "+getEvento());
	}
	
	/*public static void main(String[] args) {
		Ambiente am = new Ambiente();
		am.evoluir();
	}*/

}
