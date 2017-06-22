package application;

import DragonBall.Personaje;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;


public class VistaFreezer extends VistaPersonaje{


    public VistaFreezer(Personaje personaje, GridPane grid) {
        super(personaje, grid);
    	this.rutaNormal= "file:src/Guerreros/Freezer.jpg";
    	this.rutaTransf1 = "file:src/Guerreros/Freezer 2da Forma.jpg";
    	this.rutaTransf2 = "file:src/Guerreros/Freezer Final.jpg";
    }

}