package Superficie;

import DragonBall.*;

public class Arena extends EspacioTerrestre {

	public String nombre = "file:fotos/Piso.png";

	public Arena() {
		agregarRutaDeImagen(nombre);
	}

	@Override
	public int getPasos_normal() {
		return EspacioTerrestre.CantidadMovimientosEstandarTerrestre;
	}
	
	@Override
	public int getPasos_T1(){
		return EspacioTerrestre.CantidadMovimientosEstandarTerrestre;
	}
	
	@Override
	public int getPasos_T2(){
		return EspacioTerrestre.CantidadMovimientosEstandarTerrestre;
	}


}