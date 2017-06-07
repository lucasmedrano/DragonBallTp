package DragonBall;

public class EstadoGokuNormal extends Estado{
	
	public EstadoGokuNormal(){	
		 this.poder_pelea = 20;
		 this.distancia_ataque = 2;
		 this.velocidad = 2;	 
		 this.poder_especial = poder_pelea + ((poder_pelea*50)/100);
	}
}
