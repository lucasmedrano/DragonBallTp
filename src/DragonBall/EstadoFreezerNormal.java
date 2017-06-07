package DragonBall;

public class EstadoFreezerNormal extends Estado{
	
	public EstadoFreezerNormal(){	
		this.poder_pelea = 20;
		this.distancia_ataque = 2;
		this.velocidad = 4;
		this.poder_especial = poder_pelea + ((poder_pelea*50)/100);
	}
}
