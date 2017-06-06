package DragonBall;

public class Gohan extends Personaje{
	
	public Gohan(){	
		this.vida = 300;
		this.poder_especial = poder_pelea + ((poder_pelea*25)/100);
		this.costo_ataque_especial = 10;
		this.costo_transformacion_1 = 10;
		this.costo_transformacion_2= 30;
	}
}
