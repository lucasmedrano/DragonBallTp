package DragonBall;

public class Juego {
    Tablero tablero;
    Jugador jugador1;
    Jugador jugador2;
    Turno turno;
    
    public Juego(){
    	this.tablero = new Tablero();
    	this.jugador1 = new Jugador();
    	this.jugador2 = new Jugador();
    	turno = new Turno(jugador1,jugador2);
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
    
    public Jugador jugadorSiguiente(){
    	return turno.obtenerJugadorSiguiente();
    }
}

