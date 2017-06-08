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
	
	public void transformar(int costo_de_transformacion, Estado nuevo_estado) throws IncapacidadParaTransformacion{
		
		if (this.ki >= costo_de_transformacion){
			this.estado = nuevo_estado;
			this.ki = this.ki - costo_de_transformacion;
		}
			else throw new IncapacidadParaTransformacion();
	}
	
	public void transformar_1() throws IncapacidadParaTransformacion{
		
		EstadoMajinBooMalo nuevo_estado = new EstadoMajinBooMalo();
		this.transformar(this.costo_transformacion_1, nuevo_estado);
	}
	
	public void transformar_2() throws IncapacidadParaTransformacion{
		
		EstadoMajinBooOriginal nuevo_estado = new EstadoMajinBooOriginal();
		this.transformar(this.costo_transformacion_2, nuevo_estado);
	}
}
