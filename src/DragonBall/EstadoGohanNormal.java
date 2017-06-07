package DragonBall;

public class EstadoGohanNormal extends Estado{
	
	public EstadoGohanNormal(){	
		 this.poder_pelea = 15;
		 this.distancia_ataque = 2;
		 this.velocidad = 2;	
		 this.poder_especial = poder_pelea + ((poder_pelea*25)/100);
	}
}
