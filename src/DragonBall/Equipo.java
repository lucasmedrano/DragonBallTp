package DragonBall;

public class Equipo {
	private Personaje personaje1;
	private Personaje personaje2;
	private Personaje personaje3;
	
	public Equipo(){
	}
	
	public void asignarPersonajes(Personaje personaje1, Personaje personaje2, Personaje personaje3){
		this.personaje1 = personaje1;
		this.personaje2 = personaje2;
		this.personaje3 = personaje3;
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
	
}
