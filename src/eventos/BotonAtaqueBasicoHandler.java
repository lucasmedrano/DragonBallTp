package eventos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import DragonBall.IncapacidadDeAtacar;
import DragonBall.InhabilitadoError;
import DragonBall.Personaje;
import application.VistaPersonaje;
import application.CampoBatalla;

public class BotonAtaqueBasicoHandler implements EventHandler<ActionEvent> {
	
	VistaPersonaje vista;
    Personaje personaje;
    private VistaPersonaje vistaEnemigo;
    private CampoBatalla campo;
    	
	public BotonAtaqueBasicoHandler(CampoBatalla campo, VistaPersonaje vistaEnemigo){
		this.vistaEnemigo=vistaEnemigo;
		this.campo=campo;
	}

	 @Override
	  public void handle(ActionEvent actionEvent) {
		 this.vista = campo.obtenerVistaSeleccionada();
	     this.personaje = campo.obtenerPersonajeSeleccionado();
    	try {	
    		personaje.ataqueBasico(vistaEnemigo.obtenerPersonaje());
    	}catch(IncapacidadDeAtacar|InhabilitadoError b){
    		return;
    	}
	 }

}