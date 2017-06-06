package DragonBall;

public class MajinBoo extends Personaje{
	protected int poder_especial_stun_turnos;
	
	public MajinBoo(){	
		this.vida = 300;
		this.poder_especial_stun_turnos = 3;
		this.costo_ataque_especial = 30;
		this.costo_transformacion_1 = 20;
		this.costo_transformacion_2= 50;
	}
}
