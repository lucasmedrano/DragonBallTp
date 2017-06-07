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
	
	public void transformar(int forma) throws IncapacidadParaTransformacion{
		Estado nuevo_estado;
		
		if (forma == 1 && this.ki >= this.costo_transformacion_1){
			nuevo_estado = new EstadoFreezerSegundaForma();
			this.estado = nuevo_estado;
			this.ki = this.ki - this.costo_transformacion_1;
		}
		else {
			if (forma == 2 && this.ki >= this.costo_transformacion_2){
				nuevo_estado = new EstadoFreezerDefinitivo();
				this.estado = nuevo_estado;
				this.ki = this.ki - this.costo_transformacion_2;
			}
			else throw new IncapacidadParaTransformacion();
		}
		
	}
}
