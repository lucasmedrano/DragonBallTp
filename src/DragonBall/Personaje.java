package DragonBall;

public abstract class Personaje {
    protected int vida;
    protected Estado estado;
    protected int ki;
    protected int poder_especial;
    protected int costo_ataque_especial;
    protected int costo_transformacion_1;
    protected int costo_transformacion_2;
    protected Equipo equipo;
    protected Ubicacion ubicacion;
    protected Tablero tablero;
    protected int vida_max;
    protected int turnos_inmovilizado;
    protected int cantidadDeMovimientos;
    protected int cantidadDeMovimientosPermitidos;
    protected boolean finDeMovimiento;
    public boolean seEstaMoviendo;
    protected String rutaImgNor;
    protected String rutaImg1T;
    protected String rutaImg2T;
    
    
    public Personaje(Tablero tablero_de_juego){
        this.ki = 0;
        this.tablero = tablero_de_juego;
        this.turnos_inmovilizado = 0;
        this.cantidadDeMovimientos=0;
        this.finDeMovimiento=false;
        this.seEstaMoviendo=false;
    }
    
    
    public void asignarEquipo(Equipo equipo){
    	this.equipo = equipo;
    }
    
    public int obtenerVidaMax(){
    	return this.vida_max;
    }
    
    public void aumentarKi(int cantidad){
        this.ki += cantidad;
    }
    
    public Ubicacion obtenerUbicacion(){
        return this.ubicacion;
    }
    
    public int obtenerPoderDePelea(){
    	return this.estado.obtenerPoderDePelea();
    }
    public int obtenerPoderDePeleaEspecial(){
    	return this.estado.obtenerPoderDePeleaEspecial();
    }
    
    public int obtenerVida(){
    	return this.vida;
    }
    
    public int obtenerVelocidad(){
    	return this.estado.obtenerVelocidad();
    }
    
    public void  ubicarEn(int x, int y) throws PosicionInadecuada{
    	
    	if (this.tablero.noEstaOcupada(x,y)){
    		this.tablero.nuevaUbicacion(this,x,y);
    		this.ubicacion = new Ubicacion(x,y);
    	}else throw new PosicionInadecuada();
    }
    
    public boolean estaInmovilizado(){
    	return this.turnos_inmovilizado > 0;
    }
    
    public void moverArriba() throws PosicionInadecuada, InhabilitadoError,IncapacidadParaMoverse{
    	
    	int nueva_ubicacion = this.ubicacion.obtenerUbicacionVertical() + 1;
    	int x = this.ubicacion.obtenerUbicacionHorizontal();
    	this.mover(x,nueva_ubicacion);	
    }
    
    
    public void moverAbajo() throws PosicionInadecuada, InhabilitadoError,IncapacidadParaMoverse{
    	
    	int nueva_ubicacion = this.ubicacion.obtenerUbicacionVertical() -1;
    	int x = this.ubicacion.obtenerUbicacionHorizontal();
    	this.mover(x,nueva_ubicacion);
    	
    }
    
    public void moverDerecha() throws PosicionInadecuada, InhabilitadoError,IncapacidadParaMoverse{
    	
    	int nueva_ubicacion = this.ubicacion.obtenerUbicacionHorizontal() + 1;
    	int y = this.ubicacion.obtenerUbicacionVertical();
    	this.mover(nueva_ubicacion,y);
    }
    
    public void moverIzquierda() throws PosicionInadecuada, InhabilitadoError,IncapacidadParaMoverse{
    	
    	int nueva_ubicacion = this.ubicacion.obtenerUbicacionHorizontal() - 1;
    	int y = this.ubicacion.obtenerUbicacionVertical();
    	this.mover(nueva_ubicacion,y);
    }
    
    public int calculadorAtaque(int ataque, Personaje enemigo){
		
		int poder_de_pelea = this.obtenerPoderDePelea();
    	int poder_de_pelea_enemigo = enemigo.obtenerPoderDePelea();
    	if(poder_de_pelea < poder_de_pelea_enemigo) return ataque - ((ataque*20)/100);
		return ataque;
	}
    
    public void ataqueBasico(Personaje enemigo) throws IncapacidadDeAtacar, InhabilitadoError{
    	if(this.equipo.estaEnElEquipo(enemigo)) throw new IncapacidadDeAtacar();
    	if (this.estaInmovilizado()) throw new InhabilitadoError();
    	if (!equipo.esMiTurno()) throw new IncapacidadDeAtacar();
    	
    	if(this.tablero.estanARangoDeAtaque(this, enemigo)&& !equipo.ataco()){
    		if (equipo.seEstaMoviendo()) this.equipo.moverseYAtacar();
    		equipo.incorporarAtaque();
    		int ataque = this.obtenerPoderDePelea();
   			int ataque_basico = this.calculadorAtaque(ataque, enemigo);
   			enemigo.vida -= ataque_basico;
   			if(enemigo.vida <= 0){
   				enemigo.borrarPersonaje();
   			}
   		}else throw new IncapacidadDeAtacar();
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
    		enemigo.vida -= ataque_especial;
    		this.ki -= this.costo_ataque_especial;
    		if(enemigo.vida <= 0){
   				enemigo.borrarPersonaje();
   			}
    	}else throw new IncapacidadDeAtacar();
    }
    
	public int distanciaDeAtaque() {
		
		return this.estado.obtenerDistanciaDeAtaque();
	}
	
	public void disminuirVida(int disminucion_de_vida) {
		this.vida -= disminucion_de_vida;
	}
	
	public void incrementarMovimientos(){
		this.cantidadDeMovimientos++;
	}
	
	public void transformar(int costo_de_transformacion, Estado nuevo_estado) throws IncapacidadParaTransformacion{
		
		if (this.estaInmovilizado()) throw new IncapacidadParaTransformacion();
    	if (!equipo.esMiTurno()) throw new IncapacidadParaTransformacion();

		
		if (this.ki >= costo_de_transformacion){
			this.estado = nuevo_estado;
			this.ki = this.ki - costo_de_transformacion;
		}
		else throw new IncapacidadParaTransformacion();
	}
	
	public abstract void transformar_1() throws IncapacidadParaTransformacion;
	public abstract void transformar_2() throws IncapacidadParaTransformacion;
	
	
	
	private void mover(int x, int y) throws PosicionInadecuada, InhabilitadoError,IncapacidadParaMoverse{
		
		if (this.estaInmovilizado()) throw new InhabilitadoError();
		
		if (equipo.otrosCompanierosSeEstanMoviendo(this)) throw new IncapacidadParaMoverse();
		
		if (equipo.seMovioYAtaco()) throw new IncapacidadParaMoverse();
		
		if (this.finDeMovimiento) throw new IncapacidadParaMoverse();
		
    	if (!equipo.esMiTurno()) throw new IncapacidadParaMoverse();
    	
		if (this.tablero.esUbicacionValida(x,y) && this.tablero.noEstaOcupada(x, y)){
    		if (this.cantidadDeMovimientos<this.obtenerVelocidad()){
    			this.cantidadDeMovimientos++;
    			equipo.moverse();
    			this.seEstaMoviendo();
    		}
    		if (this.cantidadDeMovimientos==this.obtenerVelocidad()){
    			equipo.incorporarMovimiento();
   				this.finDeMovimiento=true;
   			}
    		
    		this.tablero.cambiarUbicacion(this,x,y);
    		this.ubicacion.cambiarUbicacion(x,y);
    	}else throw new PosicionInadecuada();
	}
	
	public void seEstaMoviendo(){
		seEstaMoviendo=true;
	}
	
	public boolean enMovimiento(){
		return this.seEstaMoviendo;
	}
	
	public void finalizarTurno(){
		this.cantidadDeMovimientos=0;
		this.finDeMovimiento=false;
	    this.seEstaMoviendo=false;
	}


	public void empezoTurno() {
		if(this.turnos_inmovilizado > 0){
			this.turnos_inmovilizado -= 1;
			return;
		}
		this.ki +=5;
	}
	
	public String delvolverRutaNormal(){
		return this.rutaImgNor;
	}
	
	public void borrarPersonaje() {
		int x = this.ubicacion.obtenerUbicacionHorizontal();
		int y = this.ubicacion.obtenerUbicacionVertical();
		this.tablero.borrarPersonaje(x, y);
	}
}