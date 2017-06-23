package application;

import DragonBall.Personaje;
import javafx.scene.layout.GridPane;


public class VistaFreezer extends VistaPersonaje{


    public VistaFreezer(Personaje personaje, GridPane grid) {
        super(personaje, grid);
    	this.rutaNormal= "file:src/Guerreros/Freezer.jpg";
    	this.rutaTransf1 = "file:src/Guerreros/Freezer 2da forma.jpg";
    	this.rutaTransf2 = "file:src/Guerreros/Freezer Final.jpg";
        this.rutacircnormal = "file:src//imagenes/freezer.png";
        this.rutacirc1 = "file:src//imagenes/circulofreezer2.png";
        this.rutacirc2 = "file:src//imagenes/circulofreezer.png";
    }

}