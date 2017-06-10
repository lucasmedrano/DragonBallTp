package DragonBall;

public class Freezer extends Personaje{
	public Freezer(Tablero tablero_de_juego){
		super(tablero_de_juego);
		this.vida = 400;
		this.costo_ataque_especial = 20;
		this.costo_transformacion_1 = 20;
		this.costo_transformacion_2= 50;
		this.estado = new EstadoFreezerNormal();
	}
	
	public void transformar(int costo_de_transformacion, Estado nuevo_estado) throws IncapacidadParaTransformacion{
		
		if (this.ki >= costo_de_transformacion){
			this.estado = nuevo_estado;
			this.ki = this.ki - costo_de_transformacion;
		}
		else throw new IncapacidadParaTransformacion();
	}
	
	public void transformar_1() throws IncapacidadParaTransformacion{
		
		EstadoFreezerSegundaForma nuevo_estado = new EstadoFreezerSegundaForma();
		this.transformar(this.costo_transformacion_1, nuevo_estado);
	}
	
	public void transformar_2() throws IncapacidadParaTransformacion{
		
		EstadoFreezerDefinitivo nuevo_estado = new EstadoFreezerDefinitivo();
		this.transformar(this.costo_transformacion_2, nuevo_estado);
	}
}
