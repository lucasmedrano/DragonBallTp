package DragonBall;

public class Piccolo extends Personaje{
	
	protected int porcentaje_vida_necesaria_gohan;
	public Piccolo(Tablero tablero_de_juego){
		super(tablero_de_juego);
		this.vida_max = 500;
		this.vida = 500;
		this.costo_ataque_especial = 10;
		this.costo_transformacion_1 = 20;
		this.costo_transformacion_2= 0;
		this.porcentaje_vida_necesaria_gohan = 20;
		this.estado = new EstadoPiccoloNormal();
	}
	
	public void transformar(int costo_de_transformacion, boolean chequear_vida_gohan, Estado nuevo_estado) throws IncapacidadParaTransformacion{
		try{
			if(chequear_vida_gohan && vidaGohanAlcanza() == false){
				throw new IncapacidadParaTransformacion();
			}
			
			if (this.ki >= costo_de_transformacion){
				this.estado = nuevo_estado;
				this.ki = this.ki - costo_de_transformacion;
			}
			else throw new IncapacidadParaTransformacion();
		} catch(PersonajeInvalido error){
			throw new IncapacidadParaTransformacion();
		}
	}
	
	public void transformar_1() throws IncapacidadParaTransformacion{
		
		EstadoPiccoloFortalecido nuevo_estado = new EstadoPiccoloFortalecido();
		this.transformar(this.costo_transformacion_1, false, nuevo_estado);
	}
	
	public void transformar_2() throws IncapacidadParaTransformacion{
		
		EstadoPiccoloProtector nuevo_estado = new EstadoPiccoloProtector();
		this.transformar(this.costo_transformacion_2, true, nuevo_estado);
	}
	
	private boolean vidaGohanAlcanza() throws PersonajeInvalido{
		try{
			Personaje[] companieros = this.equipo.obtenerCompanieros(this);
			Personaje companiero1 = companieros[0];
			Personaje companiero2 = companieros[1];
			
			if(companiero1 instanceof Gohan){
				return ((companiero1.obtenerVida()) <= ((companiero1.obtenerVidaMax()) * 0.2));
			}
			else if(companiero2 instanceof Gohan){
				return ((companiero2.obtenerVida()) <= ((companiero2.obtenerVidaMax()) * 0.2));
			}
			else throw new PersonajeInvalido();
			
		} catch (PersonajeInvalido e){
			throw e;
		}
	}
}
