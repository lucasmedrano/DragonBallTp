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
    
    
    public Personaje(Tablero tablero_de_juego){
        this.ki = 0;
        this.tablero = tablero_de_juego;
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
    
    public void moverArriba() throws PosicionInadecuada{
    	
    	int nueva_ubicacion = this.ubicacion.obtenerUbicacionVertical() + 1;
    	int x = this.ubicacion.obtenerUbicacionHorizontal();
    	
    	if (nueva_ubicacion <= (this.tablero.obtenerTamanio() - 1) && this.tablero.noEstaOcupada(x, nueva_ubicacion)){
    		this.tablero.nuevaUbicacion(this,x,nueva_ubicacion);
    		this.ubicacion.cambiarUbicacion(x, nueva_ubicacion);
    	}
    	else throw new PosicionInadecuada();
    	
    }
    
    public void moverAbajo() throws PosicionInadecuada{
    	
    	int nueva_ubicacion = this.ubicacion.obtenerUbicacionVertical() - 1;
    	int x = this.ubicacion.obtenerUbicacionHorizontal();
    	
    	if (nueva_ubicacion >= 0 && this.tablero.noEstaOcupada(x, nueva_ubicacion)){
    		this.tablero.nuevaUbicacion(this,x,nueva_ubicacion);
    		this.ubicacion.cambiarUbicacion(x, nueva_ubicacion);
    	}
    	else throw new PosicionInadecuada();
    	
    }

    public void moverDerecha() throws PosicionInadecuada{
    	
    	int nueva_ubicacion = this.ubicacion.obtenerUbicacionHorizontal() + 1;
    	int y = this.ubicacion.obtenerUbicacionVertical();
    	
    	if (nueva_ubicacion <= (this.tablero.obtenerTamanio() - 1) && this.tablero.noEstaOcupada(nueva_ubicacion, y)){
    		this.tablero.nuevaUbicacion(this,nueva_ubicacion,y);
    		this.ubicacion.cambiarUbicacion(nueva_ubicacion, y);
    	}
    	else throw new PosicionInadecuada();
    }
    
    public void moverIzquierda() throws PosicionInadecuada{
    	
    	int nueva_ubicacion = this.ubicacion.obtenerUbicacionHorizontal() - 1;
    	int y = this.ubicacion.obtenerUbicacionVertical();
    	
    	if (nueva_ubicacion >= 0 && this.tablero.noEstaOcupada(nueva_ubicacion, y)){
    		this.tablero.nuevaUbicacion(this,nueva_ubicacion, y);
    		this.ubicacion.cambiarUbicacion(nueva_ubicacion, y);
    	}
    	else throw new PosicionInadecuada();
    	
    }
    
    public void ataqueBasico(Personaje enemigo) throws IncapacidadDeAtacar{
    	
    	if (this.tablero.estanARangoDeAtaque(this, enemigo)){
    		int poder_de_pelea = this.obtenerPoderDePelea();
    		int poder_de_pelea_enemigo = enemigo.obtenerPoderDePelea();
    		if(poder_de_pelea < poder_de_pelea_enemigo){
    			enemigo.vida = enemigo.vida - (poder_de_pelea - ((poder_de_pelea*20)/100));
    		}else enemigo.vida -= poder_de_pelea;
    	}else throw new IncapacidadDeAtacar();
    }
    
    public void ataqueEspecial(Personaje enemigo) throws IncapacidadDeAtacar{
    	
    	if(this.tablero.estanARangoDeAtaque(this, enemigo) && this.ki >= this.costo_ataque_especial){
    		int ataque_especial = this.obtenerPoderDePeleaEspecial();
    		int poder_de_pelea = this.obtenerPoderDePelea();
    		int poder_de_pelea_enemigo = enemigo.obtenerPoderDePelea();
    		if(poder_de_pelea < poder_de_pelea_enemigo){
    			enemigo.vida = enemigo.vida - (ataque_especial - ((ataque_especial*20)/100));
    		}else enemigo.vida -= ataque_especial;
    		this.ki -= this.costo_ataque_especial;
    	}else throw new IncapacidadDeAtacar();
    }
    
	public int distanciaDeAtaque() {
		
		return this.estado.obtenerDistanciaDeAtaque();
	}
	
	public void disminuirVida(int disminucion_de_vida) {
		this.vida -= disminucion_de_vida;
	}
	
}