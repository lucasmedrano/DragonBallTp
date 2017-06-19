package eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import DragonBall.IncapacidadParaMoverse;
import DragonBall.InhabilitadoError;
import DragonBall.PosicionInadecuada;
import application.VistaPersonaje;
import DragonBall.Personaje;

public class BotonMoverDerechaHandler implements EventHandler<ActionEvent> {
	
	private final VistaPersonaje vista;
    private final Personaje personaje;
    
    public BotonMoverDerechaHandler(VistaPersonaje vista, Personaje personaje) {
        this.vista = vista;
        this.personaje = personaje;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
			this.personaje.moverDerecha();
		} catch (PosicionInadecuada | InhabilitadoError | IncapacidadParaMoverse e) {
			return;
		}
        this.vista.update(50 , 0);
    }
}
