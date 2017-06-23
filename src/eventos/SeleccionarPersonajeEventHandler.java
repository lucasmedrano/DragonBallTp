package eventos;

import DragonBall.Personaje;
import application.Casillero;
import application.VistaPersonaje;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SeleccionarPersonajeEventHandler implements EventHandler<MouseEvent> {
	String mostrar;
	int x;
	int y;
	Personaje personaje;
	
	public SeleccionarPersonajeEventHandler(Casillero casillero){
		mostrar = "Se hizo click en un casillero";
		x = casillero.obtenerX();
		y = casillero.obtenerY();
		this.personaje = casillero.obtenerPersonaje();
	}

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		System.out.println(Integer.toString(x));
		System.out.println(Integer.toString(y));
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
