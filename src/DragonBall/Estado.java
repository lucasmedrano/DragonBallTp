package DragonBall;

public abstract class Estado {
	protected int poder_pelea;
	protected int distancia_ataque;
	protected int velocidad;
	protected int poder_especial;
	
	
	 public int obtenerPoderDePelea(){
	    	return this.poder_pelea;
	    }
	 public int obtenerPoderDePeleaEspecial(){
		 return this.poder_especial;
	 }
	 public int obtenerVelocidad(){
		 return this.velocidad;
	 }

	public int obtenerDistanciaDeAtaque() {
		return this.distancia_ataque;
	}
}
