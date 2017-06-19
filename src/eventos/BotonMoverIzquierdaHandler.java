package eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import DragonBall.Goku;
import DragonBall.IncapacidadParaMoverse;
import DragonBall.InhabilitadoError;
import DragonBall.PosicionInadecuada;
import application.VistaGoku;

public class BotonMoverIzquierdaHandler implements EventHandler<ActionEvent> {
	
	private final VistaGoku vista;
    private final Goku goku;
    
    public BotonMoverIzquierdaHandler(VistaGoku vista, Goku goku) {
        this.vista = vista;
        this.goku = goku;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
			this.goku.moverIzquierda();
		} catch (PosicionInadecuada | InhabilitadoError | IncapacidadParaMoverse e) {
			return;
		}
        this.vista.update(-50, 0);
    }
}
