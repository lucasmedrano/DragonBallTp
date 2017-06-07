package DragonBall;

public class EstadoPiccoloNormal extends Estado{
	
	public EstadoPiccoloNormal(){
		this.poder_pelea = 20;
		this.distancia_ataque = 2;
		this.velocidad = 2;
		this.poder_especial = poder_pelea + ((poder_pelea*25)/100);
	}
}
