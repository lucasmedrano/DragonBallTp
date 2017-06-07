package DragonBall;

public class EstadoGokuKaioKen extends Estado{
	
	public EstadoGokuKaioKen(){
		 this.poder_pelea = 40;
		 this.distancia_ataque = 4;
		 this.velocidad = 3;
		 this.poder_especial = poder_pelea + ((poder_pelea*50)/100);
	}
}
