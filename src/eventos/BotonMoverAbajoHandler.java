package eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import DragonBall.IncapacidadParaMoverse;
import DragonBall.InhabilitadoError;
import DragonBall.Personaje;
import DragonBall.PosicionInadecuada;
import application.VistaPersonaje;

public class BotonMoverAbajoHandler implements EventHandler<ActionEvent> {
	
	private final VistaPersonaje vista;
    private final Personaje personaje;
    
    public BotonMoverAbajoHandler(VistaPersonaje vista, Personaje personaje) {
        this.vista = vista;
        this.personaje = personaje;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
			this.personaje.moverArriba();
		} catch (PosicionInadecuada | InhabilitadoError | IncapacidadParaMoverse e) {
			return;
		}
        this.vista.update(0, 50);
    }
}

