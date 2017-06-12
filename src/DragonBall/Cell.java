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
	
	 public void ataqueEspecial(Personaje enemigo) throws IncapacidadDeAtacar, InhabilitadoError{
	    	
		 if (this.estaInmovilizado()) throw new InhabilitadoError();
		 if(this.tablero.estanARangoDeAtaque(this, enemigo) && this.ki >= this.costo_ataque_especial){
			 int ataque_especial = this.obtenerPoderDePeleaEspecial();
			 int poder_de_pelea = this.obtenerPoderDePelea();
			 int poder_de_pelea_enemigo = enemigo.obtenerPoderDePelea();
			 if(poder_de_pelea < poder_de_pelea_enemigo){
	    		ataque_especial = ataque_especial - ((ataque_especial*20)/100);
			 }
			 if (ataque_especial + this.vida > this.vida_max){
	    	    this.vida = this.vida_max;
	    	 }else this.vida += ataque_especial;
			 enemigo.vida -= ataque_especial;
			 this.ki -= this.costo_ataque_especial;
			 this.vidas_absorbidas += 1;
	    }else throw new IncapacidadDeAtacar();
	 }
}
