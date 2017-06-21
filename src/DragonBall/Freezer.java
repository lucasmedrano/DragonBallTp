package DragonBall;

public class Freezer extends Personaje{
	
	final static private String rutaImgNormal = "file:src/Guerreros/Freezer.jpg";
	final static private String rutaImgT1 = "file:src/Guerreros/Freezer 2da Forma.jpg";
	final static private String rutaImgT2 = "file:src/Guerreros/Freezer Final.jpg";
	
	public Freezer(Tablero tablero_de_juego){
		super(tablero_de_juego);
		this.vida_max = 400;
		this.vida = 400;
		this.costo_ataque_especial = 20;
		this.costo_transformacion_1 = 20;
		this.costo_transformacion_2= 50;
		this.estado = new EstadoFreezerNormal();
		this.rutaImgNor = rutaImgNormal;
		this.rutaImg1T = rutaImgT1;
		this.rutaImg2T = rutaImgT2;
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
