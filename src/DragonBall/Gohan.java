package DragonBall;

public class Gohan extends Personaje{
	
	public Gohan(Tablero tablero_de_juego){	
		super(tablero_de_juego);
		this.vida = 300;
		this.costo_ataque_especial = 10;
		this.costo_transformacion_1 = 10;
		this.costo_transformacion_2= 30;
		this.estado = new EstadoGohanNormal();
	}
}
