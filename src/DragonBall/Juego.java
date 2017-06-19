package DragonBall;

public class Juego {
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Turno turno;
    private Jugador jugador_jugando;
    
    public Juego(){
    	this.tablero = new Tablero();
    	this.jugador1 = new Jugador();
    	this.jugador2 = new Jugador();
    	this.turno = new Turno(jugador1, jugador2);
    }
    
    public Tablero obtenerTablero(){
    	return this.tablero;
    }
    
    public Jugador obtenerJugador1(){
        return this.jugador1;
    }
    
    public Jugador obtenerJugador2(){
        return this.jugador2;
    } 
    
    public void empiezaJuego(){
    	
    	this.jugador_jugando = this.turno.obtenerJugadorSiguiente();
    	this.jugador_jugando.esTuTurno();
    }
    
    public void turnoSiguiente(){
    	
    	this.jugador_jugando.finalizoTuTurno();
    	jugador1.empezoTurno();
    	jugador2.empezoTurno();
    	this.jugador_jugando = this.turno.obtenerJugadorSiguiente();
    	this.jugador_jugando.esTuTurno();
    }
}

