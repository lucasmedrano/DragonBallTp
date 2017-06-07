package DragonBall;

public class EstadoGohanSuperSayajinFase1 extends Estado{
	public EstadoGohanSuperSayajinFase1(){
		 this.poder_pelea = 30;
		 this.distancia_ataque = 2;
		 this.velocidad = 2;	 
		 this.poder_especial = poder_pelea + ((poder_pelea*25)/100);
	}
	
}
