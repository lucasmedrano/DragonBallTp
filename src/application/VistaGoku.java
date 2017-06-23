package application;

import DragonBall.Personaje;
import javafx.scene.layout.GridPane;


public class VistaGoku extends VistaPersonaje{

    public VistaGoku(Personaje personaje, GridPane grid) {
    	super(personaje, grid);
    	this.rutaNormal = "file:src/Guerreros/goku.jpg";
    	this.rutaTransf1 = "file:src/Guerreros/Goku KaioKen.jpg";
    	this.rutaTransf2 = "file:src//Guerreros/Goku SSJ.jpg";
        
    }

}


