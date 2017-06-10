package DragonBall;

public class Gohan extends Personaje{
	
	public Gohan(Tablero tablero_de_juego){	
		super(tablero_de_juego);
		this.vida = 300;
		this.costo_ataque_especial = 10;
		this.costo_transformacion_1 = 10;
		this.costo_transformacion_2= 30;
		this.estado = new EstadoGohanNormal();
	}
	
	public void transformar_1() throws IncapacidadParaTransformacion{
		
		EstadoGohanSuperSayajinFase1 nuevo_estado = new EstadoGohanSuperSayajinFase1();
		this.transformar(this.costo_transformacion_1,nuevo_estado);
		
	}
	
public void transformar_2() throws IncapacidadParaTransformacion{
		
		EstadoGohanSuperSayajinFase2 nuevo_estado = new EstadoGohanSuperSayajinFase2();
		this.transformar(this.costo_transformacion_2,nuevo_estado);
		
	}
}
