package DragonBall;

public class Goku extends Personaje {	
	public Goku(){
		this.vida = 500;
		this.poder_especial = poder_pelea + ((poder_pelea*50)/100);
		this.costo_ataque_especial = 20;
		this.costo_transformacion_1 = 20;
		this.costo_transformacion_2= 50;
	}
}
