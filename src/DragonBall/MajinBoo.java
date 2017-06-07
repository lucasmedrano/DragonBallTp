package DragonBall;

public class MajinBoo extends Personaje{
	protected int poder_especial_stun_turnos;
	
	public MajinBoo(Tablero tablero_de_juego){	
		super(tablero_de_juego);
		this.vida = 300;
		this.poder_especial_stun_turnos = 3;
		this.costo_ataque_especial = 30;
		this.costo_transformacion_1 = 20;
		this.costo_transformacion_2= 50;
		this.estado = new EstadoMajinBooNormal();
	}
	
	public void transformar(int forma) throws IncapacidadParaTransformacion{
		Estado nuevo_estado;
		
		if (forma == 1 && this.ki >= this.costo_transformacion_1){
			nuevo_estado = new EstadoMajinBooMalo();
			this.estado = nuevo_estado;
			this.ki = this.ki - this.costo_transformacion_1;
		}
		else {
			if (forma == 2 && this.ki >= this.costo_transformacion_2){
				nuevo_estado = new EstadoMajinBooOriginal();
				this.estado = nuevo_estado;
				this.ki = this.ki - this.costo_transformacion_2;
			}
			else throw new IncapacidadParaTransformacion();
		}
	}
}
