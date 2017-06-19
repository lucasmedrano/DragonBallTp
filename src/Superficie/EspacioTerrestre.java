package Superficie;

import DragonBall.*;

public abstract class EspacioTerrestre extends Superficie {

	protected static int CantidadMovimientosEstandarTerrestre = 1;
	private String nombre;


	public String devuelveNombreCont() {
		return nombre;
	}

	protected void agregarRutaDeImagen(String nombreDeRuta) {
		this.nombre = nombreDeRuta;
	}

}
