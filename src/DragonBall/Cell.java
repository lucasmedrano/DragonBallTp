package DragonBall;

public class Cell extends Personaje{
	protected int vidas_absorbidas;
	
	public Cell(){	
		this.vida = 500;
		this.poder_especial = poder_pelea;
		this.costo_ataque_especial = 5;
		this.costo_transformacion_1 = 4;
		this.costo_transformacion_2= 8;
	}
}
