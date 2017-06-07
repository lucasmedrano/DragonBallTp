package DragonBall;

public class Cell extends Personaje{
	protected int vidas_absorbidas;
	
	public Cell(Tablero tablero_de_juego){	
		super(tablero_de_juego);
		this.vida = 500;
		this.costo_ataque_especial = 5;
		this.costo_transformacion_1 = 4;
		this.costo_transformacion_2= 8;
		this.vidas_absorbidas = 0;
		this.estado = new EstadoCellNormal();
	}
	
	public void transformar(int forma) throws IncapacidadParaTransformacion{
		Estado nuevo_estado;
		
		if (forma == 1 && this.vidas_absorbidas >= this.costo_transformacion_1){
			nuevo_estado = new EstadoGokuKaioKen();
			this.estado = nuevo_estado;
		}
		else {
			if (forma == 2 && this.vidas_absorbidas >= this.costo_transformacion_2){
				nuevo_estado = new EstadoGokuSuperSayajin();
				this.estado = nuevo_estado;
			}
			else throw new IncapacidadParaTransformacion();
		}
		
	}
}
