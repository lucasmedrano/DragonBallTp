package DragonBall;

public class Goku extends Personaje {	
	
	final static private String rutaImgNormal = "file:src/Guerreros/Goku.jpg";
	final static private String rutaImgT1 = "file:src/Guerreros/GokuKaioKen.jpg";
	final static private String rutaImgT2 = "file:src//Guerreros/Goku SSJ.jpg";
	
	public Goku(Tablero tablero_de_juego){
		super(tablero_de_juego);
		this.vida_max = 500;
		this.vida = 500;
		this.costo_ataque_especial = 20;
		this.costo_transformacion_1 = 20;
		this.costo_transformacion_2= 50;
		this.estado = new EstadoGokuNormal();
		this.rutaImgNor = rutaImgNormal;
		this.rutaImg1T = rutaImgT1;
		this.rutaImg2T = rutaImgT2;
	}
	
	
	public void transformar_1() throws IncapacidadParaTransformacion{
		
		EstadoGokuKaioKen nuevo_estado = new EstadoGokuKaioKen();
		this.transformar(this.costo_transformacion_1, nuevo_estado);
	}
	
	public void transformar_2() throws IncapacidadParaTransformacion{
		
		EstadoGokuSuperSayajin nuevo_estado = new EstadoGokuSuperSayajin();
		this.transformar(this.costo_transformacion_2, nuevo_estado);
	}
	
	
	public int calculadorAtaque(int ataque, Personaje enemigo){
		
		int poder_de_pelea = this.obtenerPoderDePelea();
    	int poder_de_pelea_enemigo = enemigo.obtenerPoderDePelea();
    	int suma_de_poder = 0;
    	int baja_de_poder = 0;
    	if(poder_de_pelea < poder_de_pelea_enemigo) baja_de_poder = ((ataque*20)/100);
    	if (this.vida < ((this.vida_max*30)/100)) suma_de_poder = ((ataque*20)/100);
		return ataque + suma_de_poder - baja_de_poder;
	}

}
