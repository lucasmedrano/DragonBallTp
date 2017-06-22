package application;

import DragonBall.Personaje;
import javafx.scene.layout.GridPane;


public class VistaPiccolo extends VistaPersonaje{


    public VistaPiccolo(Personaje personaje, GridPane grid) {
        super(personaje, grid);
    	this.rutaNormal = "file:src/Guerreros/piccolo.jpg";
    	this.rutaTransf1 = "file:src/Guerreros/Piccolo Foralecido.jpg";
    	this.rutaTransf2 = "file:src/Guerreros/Piccolo protector.jpg";
    	
    }

}