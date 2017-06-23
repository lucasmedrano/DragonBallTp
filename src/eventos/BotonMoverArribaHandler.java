package eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import DragonBall.IncapacidadParaMoverse;
import DragonBall.InhabilitadoError;
import DragonBall.Personaje;
import DragonBall.PosicionInadecuada;
import application.CampoBatalla;
import application.VistaPersonaje;

public class BotonMoverArribaHandler implements EventHandler<ActionEvent> {
	
	VistaPersonaje vista;
    Personaje personaje;
    CampoBatalla campo;
    int x_viejo;
    int y_viejo;
    
    public BotonMoverArribaHandler(CampoBatalla campo) {
        this.campo = campo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.vista = campo.obtenerVistaSeleccionada();
        this.personaje = campo.obtenerPersonajeSeleccionado();
    	
    	try {
    		x_viejo = this.personaje.obtenerUbicacion().obtenerUbicacionHorizontal();
    		y_viejo = this.personaje.obtenerUbicacion().obtenerUbicacionVertical();
			this.personaje.moverAbajo();
			this.vista.dibujar();
			this.campo.dibujarFondo(x_viejo, y_viejo);
		} catch (PosicionInadecuada | InhabilitadoError | IncapacidadParaMoverse e) {
			return;
		}
    }
}
