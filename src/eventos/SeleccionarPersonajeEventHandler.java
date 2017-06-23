package eventos;

import DragonBall.Personaje;
import application.CampoBatalla;
import application.Casillero;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SeleccionarPersonajeEventHandler implements EventHandler<MouseEvent> {
	int x;
	int y;
	Personaje personaje;
	Casillero casillero;
	CampoBatalla campo;
	
	public SeleccionarPersonajeEventHandler(Casillero casillero, CampoBatalla campo){
		this.casillero = casillero;
		this.campo = campo;
	}

	@Override
	public void handle(MouseEvent event) {
		x = casillero.obtenerX();
		y = casillero.obtenerY();
		this.personaje = casillero.obtenerPersonaje();
		
		campo.setearPersonajeSeleccionado(this.personaje);
		campo.actualizarVistaSeleccionada();
		
	}
	
	public int obtenerX(){
		return this.x;
	}
	
	public int obtenerY(){
		return this.y;
	}
	
	public Personaje obtenerPersonaje(){
		return this.personaje;
	}
	
}
