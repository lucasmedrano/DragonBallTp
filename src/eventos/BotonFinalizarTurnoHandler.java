package eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import DragonBall.Juego;


public class BotonFinalizarTurnoHandler implements EventHandler<ActionEvent> {
	
	private final Juego juego;
    
    public BotonFinalizarTurnoHandler(Juego juego) {
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.juego.turnoSiguiente();
    }
}
