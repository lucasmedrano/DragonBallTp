package DragonBall;

public class Cell extends Personaje{
	protected int vidas_absorbidas;
	
	public Cell(Tablero tablero_de_juego){	
		super(tablero_de_juego);
		this.vida_max = 500;
		this.vida = 500;
		this.costo_ataque_especial = 5;
		this.costo_transformacion_1 = 4;
		this.costo_transformacion_2= 8;
		this.vidas_absorbidas = 0;
		this.estado = new EstadoCellNormal();
	}
	
	public void transformar(int costo_de_transformacion, Estado nuevo_estado) throws IncapacidadParaTransformacion{
		
		if (this.vidas_absorbidas >= costo_de_transformacion){
			this.estado = nuevo_estado;
		}
		else throw new IncapacidadParaTransformacion();
	}
	
	public void transformar_1() throws IncapacidadParaTransformacion{
		
		EstadoCellSemiPerfecto nuevo_estado = new EstadoCellSemiPerfecto();
		this.transformar(this.costo_transformacion_1, nuevo_estado);
	}
	
	public void transformar_2() throws IncapacidadParaTransformacion{
		
		EstadoCellPerfecto nuevo_estado = new EstadoCellPerfecto();
		this.transformar(this.costo_transformacion_2, nuevo_estado);
	}
	
	 public void ataqueEspecial(Personaje enemigo) throws IncapacidadDeAtacar{
	    	
	    	if(this.tablero.estanARangoDeAtaque(this, enemigo) && this.ki >= this.costo_ataque_especial){
	    		int ataque_especial = this.obtenerPoderDePeleaEspecial();
	    		enemigo.vida= enemigo.vida - ataque_especial;
	    		if (ataque_especial + this.vida > 500){
	    			this.vida = 500;
	    		}else this.vida += ataque_especial;
	    		this.ki -= this.costo_ataque_especial;
	    	}else throw new IncapacidadDeAtacar();
	    }
}
