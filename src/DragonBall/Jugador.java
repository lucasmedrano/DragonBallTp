package DragonBall;

public class Jugador {
    private Equipo equipo;
    
    public Jugador(){
        
    }
    
    public void asignarEquipo(Equipo equipo){
    	this.equipo = equipo;
    }
    
    public Personaje obtenerPersonaje1(){
    	return (equipo.obtenerPersonaje1());
    }
    
    public Personaje obtenerPersonaje2(){
    	return (equipo.obtenerPersonaje2());
    }
    
    public Personaje obtenerPersonaje3(){
        return (equipo.obtenerPersonaje3());
    }
    
    public Equipo obtenerEquipo(){
    	return this.equipo;
    }
}