package DragonBall;

public class Cell extends Personaje{
	
	protected int vidas_absorbidas;
	final static private String rutaImgNormal = "file:fotos/cell.png";
	final static private String rutaImgT1 = "file:fotos/cell semi.png";
	final static private String rutaImgT2 = "file:fotos/cell perfecto.png";
	
	public Cell(Tablero tablero_de_juego){	
		super(tablero_de_juego);
		this.vida_max = 500;
		this.vida = 500;
		this.costo_ataque_especial = 5;
		this.costo_transformacion_1 = 4;
		this.costo_transformacion_2= 8;
		this.vidas_absorbidas = 0;
		this.estado = new EstadoCellNormal();
		this.rutaImgNor = rutaImgNormal;
		this.rutaImg1T = rutaImgT1;
		this.rutaImg2T = rutaImgT2;
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
		if(this.equipo.estaEnElEquipo(enemigo)) throw new IncapacidadDeAtacar();
	    if (this.estaInmovilizado()) throw new InhabilitadoError();
	    if (!equipo.esMiTurno()) throw new IncapacidadDeAtacar();

	    if(this.tablero.estanARangoDeAtaque(this, enemigo) && this.ki >= this.costo_ataque_especial && !equipo.ataco()){
	    	if (equipo.seEstaMoviendo()) this.equipo.moverseYAtacar();
		    equipo.incorporarAtaque();
		    int ataque = this.obtenerPoderDePeleaEspecial();
			int ataque_especial = this.calculadorAtaque(ataque, enemigo);
			if (ataque_especial + this.vida > this.vida_max){
		        this.vida = this.vida_max;
		    }else this.vida += ataque_especial;
			enemigo.vida -= ataque_especial;
			this.ki -= this.costo_ataque_especial;
			this.vidas_absorbidas += 1;
	    }else throw new IncapacidadDeAtacar();
	 }
}
