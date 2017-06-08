package DragonBall;

public class Goku extends Personaje {	
	public Goku(Tablero tablero_de_juego){
		super(tablero_de_juego);
		this.vida = 500;
		this.costo_ataque_especial = 20;
		this.costo_transformacion_1 = 20;
		this.costo_transformacion_2= 50;
		this.estado = new EstadoGokuNormal();
	}
	
	
	public void transformar(int costo_de_transformacion, Estado nuevo_estado) throws IncapacidadParaTransformacion{
		
		if (this.ki >= costo_de_transformacion){
			this.estado = nuevo_estado;
			this.ki = this.ki - costo_de_transformacion;
		}
			else throw new IncapacidadParaTransformacion();
	}
	
	public void transformar_1() throws IncapacidadParaTransformacion{
		
		EstadoGokuKaioKen nuevo_estado = new EstadoGokuKaioKen();
		this.transformar(this.costo_transformacion_1, nuevo_estado);
	}
	
	public void transformar_2() throws IncapacidadParaTransformacion{
		
		EstadoGokuSuperSayajin nuevo_estado = new EstadoGokuSuperSayajin();
		this.transformar(this.costo_transformacion_2, nuevo_estado);
	}
}
