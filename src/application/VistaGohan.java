package application;

import DragonBall.Personaje;
import javafx.scene.layout.GridPane;


public class VistaGohan extends VistaPersonaje{


    public VistaGohan(Personaje personaje, GridPane grid) {
    	super(personaje, grid);
    	this.rutaNormal = "file:src/Guerreros/gohan.jpg";
    	this.rutaTransf1 = "file:src/Guerreros/Gohan SSJ 1.jpg";
    	this.rutaTransf2 = "file:src/Guerreros/Gohan SS2.jpg";
    }

}