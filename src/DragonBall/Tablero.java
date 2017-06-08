package DragonBall;


public class Tablero {
	private Personaje[][] tablero;
	private int tamanio;
	
	public Tablero(){
		this.tamanio = 30;
		this.tablero = new Personaje[tamanio][tamanio];
	}
	
	public void nuevaUbicacion(Personaje personaje, int x, int y){
			this.tablero[y][x] = personaje;
	}
	
	public boolean noEstaOcupada(int x, int y){
		if (this.tablero[y][x] == null){
			return true;
		}	
		else return false;
	}
	
	public int obtenerTamanio(){
		return this.tamanio;
	}
	
	int abs (int numero) {
	      return numero > 0 ? numero : -numero;
	}

	public boolean estanARangoDeAtaque(Personaje atacante, Personaje enemigo) {
		
		int x_atacante = atacante.ubicacion.obtenerUbicacionHorizontal();
		int y_atacante = atacante.ubicacion.obtenerUbicacionVertical();
		int x_enemigo = enemigo.ubicacion.obtenerUbicacionHorizontal();
		int y_enemigo = enemigo.ubicacion.obtenerUbicacionVertical();
		int distancia_ataque = atacante.distanciaDeAtaque();
		
		if ((abs(x_atacante - x_enemigo)) <= distancia_ataque && abs(y_atacante - y_enemigo) <= distancia_ataque){
			
			return true;
		}else return false;
		
	}
	
	public void ubicarPersonajeJugador(int x_inicial, Jugador jugador){
		
		Personaje personaje_1 = jugador.obtenerPersonaje1();
		Personaje personaje_2 = jugador.obtenerPersonaje2();
		Personaje personaje_3 = jugador.obtenerPersonaje3();
		
		this.nuevaUbicacion(personaje_1, x_inicial, this.tamanio/2 - 1);
		this.nuevaUbicacion(personaje_2, x_inicial, this.tamanio/2);
		this.nuevaUbicacion(personaje_3, x_inicial, this.tamanio/2 + 1);
		
		personaje_1.ubicacion = new Ubicacion(x_inicial, this.tamanio/2 - 1);
		personaje_2.ubicacion = new Ubicacion(x_inicial, this.tamanio/2);
		personaje_3.ubicacion = new Ubicacion(x_inicial, this.tamanio/2 + 1);
	}
	
	
	public void ubicarPersonajesJugador1(Jugador jugador) {
		
		this.ubicarPersonajeJugador(0, jugador);
	}

	
	public void ubicarPersonajesJugador2(Jugador jugador) {
		
		this.ubicarPersonajeJugador(this.tamanio - 1, jugador);
	}
}