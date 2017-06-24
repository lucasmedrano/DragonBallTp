package eventos;

import java.util.Optional;

import DragonBall.Gohan;
import DragonBall.Goku;
import DragonBall.IncapacidadDeAtacar;
import DragonBall.InhabilitadoError;
import DragonBall.Personaje;
import DragonBall.Piccolo;
import application.CampoBatalla;
import application.VistaPersonaje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;

public class BotonAtaqueEspecialHandler implements EventHandler<ActionEvent> {
	VistaPersonaje vista;
    Personaje personaje;
    private VistaPersonaje vistaEnemigo;
    private CampoBatalla campo;
    	
	public BotonAtaqueEspecialHandler(CampoBatalla campo){
		this.campo=campo;
	}

	 @Override
	  public void handle(ActionEvent actionEvent) {
		 this.vista = campo.obtenerVistaSeleccionada();
	     this.personaje = campo.obtenerPersonajeSeleccionado();
	     if(this.personaje == null) return;
	     Alert alert = new Alert(AlertType.CONFIRMATION);
	     alert.setTitle("Personaje a Atacar");
	     alert.setHeaderText("Elija el enemigo que desea atacar");
	     alert.setContentText("");
	     
	     String enemigo1 = "";
	     String enemigo2 = "";
	     String enemigo3 = "";
	     
	     if (this.personaje instanceof Goku || this.personaje instanceof Piccolo || this.personaje instanceof Gohan){
	    	 enemigo1 = "Freezer";
	    	 enemigo2 = "Cell";
	    	 enemigo3 = "MajinBoo";
	     }else{
	    	 enemigo1 = "Goku";
	    	 enemigo2 = "Gohan";
	    	 enemigo3 = "Piccolo";
	     }
	     
	     ButtonType buttonTypeEnemigo1 = new ButtonType(enemigo1);
	     ButtonType buttonTypeEnemigo2 = new ButtonType(enemigo2);
	     ButtonType buttonTypeEnemigo3 = new ButtonType(enemigo3);
	     ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

	     alert.getButtonTypes().setAll(buttonTypeEnemigo1, buttonTypeEnemigo2, buttonTypeEnemigo3, buttonTypeCancel);
	     
	     Optional<ButtonType> result = alert.showAndWait();
	     if (result.get() == buttonTypeEnemigo1){
	         if(enemigo1.equals("Freezer")){
	        	 this.vistaEnemigo = this.campo.vistaFreezer;
	         }else this.vistaEnemigo = this.campo.vistaGoku;
	     } else if (result.get() == buttonTypeEnemigo2) {
	    	 if(enemigo2.equals("Cell")){
	        	 this.vistaEnemigo = this.campo.vistaCell;
	         }else this.vistaEnemigo = this.campo.vistaGohan;
	     } else if (result.get() == buttonTypeEnemigo3) {
	    	 if(enemigo3.equals("MajinBoo")){
	        	 this.vistaEnemigo = this.campo.vistaMajinBoo;
	         }else this.vistaEnemigo = this.campo.vistaPiccolo;
	     } else {
	     }
    	try {	
    		personaje.ataqueEspecial(vistaEnemigo.obtenerPersonaje());
    		this.vistaEnemigo.dibujar();
    		campo.actualizarDatos();
    		this.campo.chequearVictoria();
    	}catch(IncapacidadDeAtacar|InhabilitadoError b){
    		return;
    	}
	 }

}
