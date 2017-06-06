package DragonBall;

public class Piccolo extends Personaje{
	
	public Piccolo(){	
		this.vida = 500;
		this.poder_especial = poder_pelea + ((poder_pelea*25)/100);
		this.costo_ataque_especial = 10;
		this.costo_transformacion_1 = 20;
		this.costo_transformacion_2= 0;
	}
}
