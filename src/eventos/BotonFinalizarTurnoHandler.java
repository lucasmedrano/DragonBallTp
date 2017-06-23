package eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import DragonBall.Juego;
import application.CampoBatalla;


public class BotonFinalizarTurnoHandler implements EventHandler<ActionEvent> {
	
	private final Juego juego;
	CampoBatalla campo;
    
    public BotonFinalizarTurnoHandler(Juego juego, CampoBatalla campo) {
        this.juego = juego;
        this.campo = campo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.juego.turnoSiguiente();
        this.campo.actualizarTurno();
        this.campo.actualizarDatos();
    }
}
