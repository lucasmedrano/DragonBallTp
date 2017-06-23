package eventos;

import DragonBall.IncapacidadParaTransformacion;
import DragonBall.Personaje;
import application.CampoBatalla;
import application.VistaPersonaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Transformar1EventHandler implements EventHandler<ActionEvent>{
	Personaje personaje;
	VistaPersonaje vista_personaje;
	CampoBatalla campo;
	public Transformar1EventHandler(CampoBatalla campo){
		this.campo = campo;
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		this.personaje = campo.obtenerPersonajeSeleccionado();
		this.vista_personaje = campo.obtenerVistaSeleccionada();
		if(this.personaje != null){
			try{
				personaje.transformar_1();
				this.vista_personaje.actualizarATransformacion1();
				this.vista_personaje.dibujar();
				campo.actualizarDatos();
			}catch (IncapacidadParaTransformacion error){
				return;
			}
			
		}
	}
}
