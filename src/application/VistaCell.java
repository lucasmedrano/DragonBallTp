package application;

import DragonBall.Personaje;
import javafx.scene.layout.GridPane;


public class VistaCell extends VistaPersonaje{


    public VistaCell(Personaje personaje, GridPane grid) {
        super(personaje, grid);
    	this.rutaNormal = "file:src/Guerreros/cell.jpg";
    	this.rutaTransf1 = "file:src/Guerreros/Cell SemiPerfecto.jpg";
    	this.rutaTransf2 = "file:src/Guerreros/Cell Perfecto.jpg";
    }

}