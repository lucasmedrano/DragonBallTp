package DragonBall;

public class Piccolo extends Personaje{
	
	public Piccolo(Tablero tablero_de_juego){
		super(tablero_de_juego);
		this.vida = 500;
		this.costo_ataque_especial = 10;
		this.costo_transformacion_1 = 20;
		this.costo_transformacion_2= 0;
		this.estado = new EstadoPiccoloNormal();
	}
	
	public void transformar_1() throws IncapacidadParaTransformacion{
		
		EstadoPiccoloFortalecido nuevo_estado = new EstadoPiccoloFortalecido();
		this.transformar(this.costo_transformacion_1, nuevo_estado);
	}
	
	public void transformar_2() throws IncapacidadParaTransformacion{
		
		EstadoPiccoloProtector nuevo_estado = new EstadoPiccoloProtector();
		//Deberiamos Poner aca la condicion de Gohan?
		this.transformar(this.costo_transformacion_2, nuevo_estado);
		
		
	}
}
