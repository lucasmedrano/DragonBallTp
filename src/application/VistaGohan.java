package application;

import DragonBall.Personaje;
import javafx.scene.layout.GridPane;


public class VistaGohan extends VistaPersonaje{


    public VistaGohan(Personaje personaje, GridPane grid) {
    	super(personaje, grid);
    	this.rutaNormal = "file:src/Guerreros/gohan.jpg";
    	this.rutaTransf1 = "file:src/Guerreros/Gohan SSJ 1.jpg";
    	this.rutaTransf2 = "file:src/Guerreros/Gohan SSJ2.jpg";
        this.rutacircnormal = "file:src//imagenes/circulogohannormal.png";
        this.rutacirc1 = "file:src//imagenes/circulogohanssj.png";
        this.rutacirc2 = "file:src//imagenes/circulogohanssj2.png";
    }

}