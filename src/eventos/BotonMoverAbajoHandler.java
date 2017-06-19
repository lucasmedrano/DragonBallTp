package eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import DragonBall.Goku;
import DragonBall.IncapacidadParaMoverse;
import DragonBall.InhabilitadoError;
import DragonBall.PosicionInadecuada;
import application.VistaGoku;

public class BotonMoverAbajoHandler implements EventHandler<ActionEvent> {
	
	private final VistaGoku vista;
    private final Goku goku;
    
    public BotonMoverAbajoHandler(VistaGoku vista, Goku goku) {
        this.vista = vista;
        this.goku = goku;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
			this.goku.moverArriba();
		} catch (PosicionInadecuada | InhabilitadoError | IncapacidadParaMoverse e) {
			return;
		}
        this.vista.update(0, 50);
    }
}

