package DragonBall;

public class Piccolo extends Personaje{
	
	public Piccolo(Tablero tablero_de_juego){
		super(tablero_de_juego);
		this.vida = 500;
		this.costo_ataque_especial = 10;
		this.costo_transformacion_1 = 20;
		this.costo_transformacion_2= 0;
		this.estado = new EstadoPiccoloNormal();
	}
}
