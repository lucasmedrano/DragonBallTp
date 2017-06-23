package application;

import DragonBall.Personaje;
import javafx.scene.layout.GridPane;


public class VistaMajinBoo extends VistaPersonaje{


    public VistaMajinBoo(Personaje personaje, GridPane grid) {
        super(personaje, grid);
    	this.rutaNormal = "file:src/Guerreros/MajinBoo.jpg";
    	this.rutaTransf1 = "file:src/Guerreros/MajinBoo Malo.jpg";
    	this.rutaTransf2 = "file:src/Guerreros/MajinBoo Original.jpg";
        this.rutacircnormal = "file:src//imagenes/circulomajinboo.png";
        this.rutacirc1 = "file:src//imagenes/boomalo.png";
        this.rutacirc2 = "file:src//imagenes/circulokidboo.png";
    }

}
