package application;

import DragonBall.Personaje;
import javafx.scene.layout.GridPane;


public class VistaPiccolo extends VistaPersonaje{


    public VistaPiccolo(Personaje personaje, GridPane grid) {
        super(personaje, grid);
    	this.rutaNormal = "file:src/Guerreros/piccolo.jpg";
    	this.rutaTransf1 = "file:src/Guerreros/piccolo Fortalecido.jpg";
    	this.rutaTransf2 = "file:src/Guerreros/piccolo Protector.jpg";
        this.rutacircnormal = "file:src//imagenes/circulopiccolo.png";
        this.rutacirc1 = "file:src//imagenes/circulopiccolo.png";
        this.rutacirc2 = "file:src//imagenes/circulopiccolo.png";
    	
    }

}