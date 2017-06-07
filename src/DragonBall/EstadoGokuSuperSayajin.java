package DragonBall;

public class EstadoGokuSuperSayajin extends Estado{
	
	public EstadoGokuSuperSayajin(){	
		this.poder_pelea = 60;
		this.distancia_ataque = 4;
		this.velocidad = 5;
		this.poder_especial = poder_pelea + ((poder_pelea*50)/100);
	}
}
