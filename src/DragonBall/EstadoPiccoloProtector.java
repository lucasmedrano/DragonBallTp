package DragonBall;

public class EstadoPiccoloProtector extends Estado{
	public EstadoPiccoloProtector(){	
		this.poder_pelea = 60;
		this.distancia_ataque = 6;
		this.velocidad = 4;
		this.poder_especial = poder_pelea + ((poder_pelea*25)/100);
	}
}
