package DragonBall;

public class Equipo {
	private Personaje personaje1;
	private Personaje personaje2;
	private Personaje personaje3;
	private boolean ataco;
	private boolean seMovio;
	
	public Equipo(){
		this.ataco=false;
		this.seMovio=false;
	}
	
	public void asignarPersonajes(Personaje personaje1, Personaje personaje2, Personaje personaje3){
		this.personaje1 = personaje1;
		this.personaje2 = personaje2;
		this.personaje3 = personaje3;
		personaje1.asignarEquipo(this);
		personaje2.asignarEquipo(this);
		personaje3.asignarEquipo(this);
	}
	
	public void asignarPersonaje1(Personaje personaje1){
		this.personaje1=personaje1;
		personaje1.asignarEquipo(this);
	}
	
	public void asignarPersonaje2(Personaje personaje2){
		this.personaje2=personaje2;
		personaje2.asignarEquipo(this);
	}
	
	public void asignarPersonaje3(Personaje personaje3){
		this.personaje3=personaje3;
		personaje3.asignarEquipo(this);
	}
	
	public Personaje[] obteneEquipo(){
		Personaje[] equipo = new Personaje[3];
		equipo[0] = personaje1;
		equipo[1] = personaje2;
		equipo[2] = personaje3;
		return equipo;
	}
	
	public Personaje obtenerPersonaje1(){
		return personaje1;
	}
	
	public Personaje obtenerPersonaje2(){
		return personaje2;
	}
	public Personaje obtenerPersonaje3(){
		return personaje3;
	}
	
	public Personaje[] obtenerCompanieros(Personaje personaje) throws PersonajeInvalido{
		if((personaje != this.personaje1) && (personaje != this.personaje2) && (personaje != this.personaje3)) throw new PersonajeInvalido();
		
		Personaje[] companieros = new Personaje[2];
		if (personaje == this.personaje1){
			companieros[0] = this.personaje2;
			companieros[1] = this.personaje3;
		}
		
		if (personaje == this.personaje2){
			companieros[0] = this.personaje1;
			companieros[1] = this.personaje3;
		}
		
		if (personaje == this.personaje3){
			companieros[0] = this.personaje1;
			companieros[1] = this.personaje2;
		}
		
		return companieros;
	}
	
	public boolean ataco(){
		return ataco;
	}
	public void incorporarAtaque(){
		ataco=true;
	}	
	
	public void incorporarMovimiento(){
		seMovio=true;
	}

	public void finalizarTurno(){
		this.ataco=false;
		this.seMovio=false;
		
		personaje1.finalizarTurno();
		personaje2.finalizarTurno();
		personaje3.finalizarTurno();
	}
}