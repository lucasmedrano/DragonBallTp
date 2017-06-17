package DragonBall;
 
import java.util.ArrayList;
import java.util.Collections;
 
 	public class Turno {
 		ArrayList<Jugador> jugadores;
 		static int i;
 	 
	public Turno(Jugador jugador1,Jugador jugador2){
 		jugadores=new ArrayList<Jugador>();
 		jugadores.add(jugador1);
 		jugadores.add(jugador2);
 		Collections.shuffle(jugadores);
 		i=0;
 	}	
 		
 	public Jugador obtenerJugadorSiguiente(){
	 		if(i==2){
 			i=0;
 		}
		Jugador jugador = this.jugadores.get(i);
 		i++;
 		return jugador;
	}
 	
 	public void empezoTurno(){
 		Jugador jugador1 = this.jugadores.get(1);
 		Jugador jugador2 = this.jugadores.get(2);
 		jugador1.empezoTurno();
 		jugador2.empezoTurno();

 	}
} 
