package DragonBall;

public class Jugador {
    private Personaje personaje_1;
    private Personaje personaje_2;
    private Personaje personaje_3;
    
    public Jugador(){
        
    }
    
    public void asignarPersonaje1(Personaje personaje){
        this.personaje_1 = personaje;
    }
    
    public void asignarPersonaje2(Personaje personaje){
        this.personaje_2 = personaje;
    }
    
    public void asignarPersonaje3(Personaje personaje){
        this.personaje_3 = personaje;
    }
    
    public Personaje obtenerPersonaje1(){
        return this.personaje_1;
    }
    
    public Personaje obtenerPersonaje2(){
        return this.personaje_2;
    }
    
    public Personaje obtenerPersonaje3(){
        return this.personaje_3;
    }
}