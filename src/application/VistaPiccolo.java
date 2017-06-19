package application;

import DragonBall.Piccolo;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;


public class VistaPiccolo {

    private Piccolo piccolo;
    Canvas canvas;
    private int x;
    private int y;

    public VistaPiccolo(Piccolo piccolo, Canvas canvas) {
        this.piccolo = piccolo;
        this.canvas = canvas;
        this.x = 0;
        this.y = 0;
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
    	Image imagen = new Image(piccolo.delvolverRutaNormal());
      	canvas.getGraphicsContext2D().drawImage(imagen, piccolo.obtenerUbicacion().obtenerUbicacionHorizontal() + 20 + this.x, piccolo.obtenerUbicacion().obtenerUbicacionVertical() + 600 + this.y, 50, 100);
    }

    public void update(int x, int y) {
    	this.x += x;
    	this.y += y;
    	this.dibujar();
    }

}