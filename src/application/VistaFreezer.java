package application;

import DragonBall.Freezer;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;


public class VistaFreezer {

    private Freezer freezer;
    Canvas canvas;
    private int x;
    private int y;

    public VistaFreezer(Freezer freezer, Canvas canvas) {
        this.freezer = freezer;
        this.canvas = canvas;
        this.x = 0;
        this.y = 0;
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
    	Image imagen = new Image(freezer.delvolverRutaNormal());
      	canvas.getGraphicsContext2D().drawImage(imagen, freezer.obtenerUbicacion().obtenerUbicacionHorizontal() + 900 + this.x, freezer.obtenerUbicacion().obtenerUbicacionVertical() + 400 + this.y, 50, 100);
    }

    public void update(int x, int y) {
    	this.x += x;
    	this.y += y;
    	this.dibujar();
    }

}