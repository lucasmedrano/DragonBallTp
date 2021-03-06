package DragonBall;

public class Gohan extends Personaje{
	
	protected int porcentaje_vida_necesaria_equipo;
	
	
	public Gohan(Tablero tablero_de_juego){	
		super(tablero_de_juego);
		this.vida_max = 300;
		this.vida = 300;
		this.costo_ataque_especial = 10;
		this.costo_transformacion_1 = 10;
		this.costo_transformacion_2= 30;
		this.porcentaje_vida_necesaria_equipo = 20;
		this.estado = new EstadoGohanNormal();
	}
	
	public void transformar(int costo_de_transformacion, boolean chequear_vida_equipo, Estado nuevo_estado) throws IncapacidadParaTransformacion{
		try{	
			if (this.estaInmovilizado()) throw new IncapacidadParaTransformacion();
	    	if (!equipo.esMiTurno()) throw new IncapacidadParaTransformacion();
			
			if((chequear_vida_equipo) && (chequearPorcentajeVidaEquipo() == false)){
				throw new IncapacidadParaTransformacion();
			}
			
			if (this.ki >= costo_de_transformacion){
				this.estado = nuevo_estado;
				this.ki = this.ki - costo_de_transformacion;
			} else throw new IncapacidadParaTransformacion();
			
		} catch (PersonajeInvalido error){
			throw new IncapacidadParaTransformacion();
		}
	}
	
	public void transformar_1() throws IncapacidadParaTransformacion{
		
		EstadoGohanSuperSayajinFase1 nuevo_estado = new EstadoGohanSuperSayajinFase1();
		this.transformar(this.costo_transformacion_1, false, nuevo_estado);
		
	}
	
	public void transformar_2() throws IncapacidadParaTransformacion{
		
		EstadoGohanSuperSayajinFase2 nuevo_estado = new EstadoGohanSuperSayajinFase2();
		this.transformar(this.costo_transformacion_2,  true, nuevo_estado);
	}

	private boolean chequearPorcentajeVidaEquipo() throws PersonajeInvalido{
		try{
			Personaje[] companieros = this.equipo.obtenerCompanieros(this);
			Personaje companiero1 = companieros[0];
			Personaje companiero2 = companieros[1];
			
			return ((companiero1.obtenerVida() <= ((companiero1.obtenerVidaMax()) * 0.2) ) && (companiero2.obtenerVida() <= ((companiero2.obtenerVidaMax()) * 0.2)));
			
		} catch (PersonajeInvalido e){
			throw e;
		}

	}
}
