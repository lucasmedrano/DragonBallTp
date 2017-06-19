package application;

import DragonBall.Gohan;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;


public class VistaGohan {

    private Gohan gohan;
    Canvas canvas;
    private int x;
    private int y;

    public VistaGohan(Gohan gohan, Canvas canvas) {
        this.gohan = gohan;
        this.canvas = canvas;
        this.x = 0;
        this.y = 0;
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
    	Image imagen = new Image(gohan.delvolverRutaNormal());
      	canvas.getGraphicsContext2D().drawImage(imagen, gohan.obtenerUbicacion().obtenerUbicacionHorizontal() + 20 + this.x, gohan.obtenerUbicacion().obtenerUbicacionVertical() + 400 + this.y, 50, 100);
    }

    public void update(int x, int y) {
    	this.x += x;
    	this.y += y;
    	this.dibujar();
    }

}