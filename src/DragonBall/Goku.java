package DragonBall;

public class Goku extends Personaje {	
	public Goku(Tablero tablero_de_juego){
		super(tablero_de_juego);
		this.vida_max = 500;
		this.vida = 500;
		this.costo_ataque_especial = 20;
		this.costo_transformacion_1 = 20;
		this.costo_transformacion_2= 50;
		this.estado = new EstadoGokuNormal();
	}
	
	public void transformar(int costo_de_transformacion, Estado nuevo_estado) throws IncapacidadParaTransformacion{
		
		if (this.ki >= costo_de_transformacion){
			this.estado = nuevo_estado;
			this.ki = this.ki - costo_de_transformacion;
		}
		else throw new IncapacidadParaTransformacion();
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
	
	 public void ataqueBasico(Personaje enemigo) throws IncapacidadDeAtacar, InhabilitadoError{
	    	
	    if (this.estaInmovilizado()) throw new InhabilitadoError();
	    if(this.tablero.estanARangoDeAtaque(this, enemigo)){
	    	int ataque = this.obtenerPoderDePelea();
	    	int ataque_basico = this.calculadorAtaque(ataque, enemigo);
	    	enemigo.vida -= ataque_basico;
	    }else throw new IncapacidadDeAtacar();
	  }
	    
	 public void ataqueEspecial(Personaje enemigo) throws IncapacidadDeAtacar, InhabilitadoError{
	    	
	    if (this.estaInmovilizado()) throw new InhabilitadoError();
	    if(this.tablero.estanARangoDeAtaque(this, enemigo) && this.ki >= this.costo_ataque_especial){
	    	int ataque = this.obtenerPoderDePeleaEspecial();
	    	int ataque_especial = this.calculadorAtaque(ataque, enemigo);
	    	this.ki -= this.costo_ataque_especial;
	    	enemigo.vida -= ataque_especial;
	    }else throw new IncapacidadDeAtacar();
	 }
}
