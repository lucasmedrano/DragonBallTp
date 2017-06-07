package DragonBall;

public class EstadoPiccoloFortalecido extends Estado{
	
	public EstadoPiccoloFortalecido(){
		this.poder_pelea = 40;
		this.distancia_ataque = 4;
		this.velocidad = 3;
		this.poder_especial = poder_pelea + ((poder_pelea*25)/100);
	}
}
