package DragonBall;
 
import java.util.ArrayList;
import java.util.Collections;
 
 	public class Turno {
 		private ArrayList<Jugador> jugadores;
 		private int i;
 	 
	public Turno(Jugador jugador1,Jugador jugador2){
 		this.jugadores=new ArrayList<Jugador>();
 		this.jugadores.add(jugador1);
 		this.jugadores.add(jugador2);
 		Collections.shuffle(this.jugadores);
 		this.i=0;
 	}	
 		
 	public Jugador obtenerJugadorSiguiente(){
	 		if(this.i==2){
 			this.i=0;
 		}
		Jugador jugador = this.jugadores.get(i);
 		this.i += 1;
 		return jugador;
	}	

 	public Jugador obtenerJugadorActual(){
 		Jugador jugador = this.jugadores.get(i);
 		return jugador;
 	}
 
 }