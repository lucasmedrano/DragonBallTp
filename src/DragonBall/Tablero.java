package DragonBall;


public class Tablero {
	private Personaje[][] tablero;
	private int tamanio;
	
	public Tablero(){
		this.tamanio = 30;
		this.tablero = new Personaje[tamanio][tamanio];
	}
	
	public void ubicarEn(Personaje personaje, int x, int y){
		//HACER CHEQUEO PRIMERO
		this.tablero[x][y] = personaje;
		personaje.nuevaUbicacion(x,y); 
	}
	
	public int obtenerTamanio(){
		return this.tamanio;
	}
	
	public void moverA(Personaje personaje, int x, int y) throws PosicionInadecuada{
		//HACER CHEQUEOS DE PERSONAJE Y TABLERO
		Ubicacion ubicacion_vieja = personaje.obtenerUbicacion();
		int ubicacion_horizontal_vieja = ubicacion_vieja.obtenerUbicacionHorizontal();
		int ubicacion_vertical_vieja = ubicacion_vieja.obtenerUbicacionVertical();
		int velocidad = personaje.obtenerVelocidad();
		
		if((java.lang.Math.abs(x-ubicacion_horizontal_vieja)) > velocidad){
			throw new PosicionInadecuada();
		}
		
		if((java.lang.Math.abs(y-ubicacion_vertical_vieja)) > velocidad){
			throw new PosicionInadecuada();
		}
		
		if((x < 0) || (y < 0) || (y > this.tamanio) || (x > this.tamanio)){
			throw new PosicionInadecuada();
		}
		
		if(this.tablero[y][x] != null){
			throw new PosicionInadecuada();
		}
		
		tablero[ubicacion_vertical_vieja][ubicacion_horizontal_vieja] = null;
		tablero[x][y] = personaje; 
		personaje.nuevaUbicacion(x, y);
	}
}