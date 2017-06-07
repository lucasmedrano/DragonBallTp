package DragonBall;

public class EstadoFreezerDefinitivo extends Estado{
	
	public EstadoFreezerDefinitivo(){	
		this.poder_pelea = 50;
		this.distancia_ataque = 3;
		this.velocidad = 6;
		this.poder_especial = poder_pelea + ((poder_pelea*50)/100);
	}

}
