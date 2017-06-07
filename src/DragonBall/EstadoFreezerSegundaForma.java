package DragonBall;

public class EstadoFreezerSegundaForma extends Estado{
	
	public EstadoFreezerSegundaForma(){		
		this.poder_pelea = 40;
		this.distancia_ataque = 3;
		this.velocidad = 4;
		this.poder_especial = poder_pelea + ((poder_pelea*50)/100);
}
}
