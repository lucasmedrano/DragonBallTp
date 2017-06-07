package DragonBall;

public class EstadoGohanSuperSayajinFase2 extends Estado{
	public EstadoGohanSuperSayajinFase2(){
		 this.poder_pelea = 100;
		 this.distancia_ataque = 4;
		 this.velocidad = 3;
		 this.poder_especial = poder_pelea + ((poder_pelea*25)/100);
	}
}
