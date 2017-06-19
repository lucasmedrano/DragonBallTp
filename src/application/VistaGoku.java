package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import DragonBall.Goku;

public class VistaGoku {

    private Goku goku;
    Canvas canvas;
    private int x;
    private int y;
    

    public VistaGoku(Goku goku, Canvas canvas) {
        this.goku = goku;
        this.canvas = canvas;
        this.x = 0;
        this.y = 0;
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
    	Image imagen = new Image(goku.delvolverRutaNormal());
    	canvas.getGraphicsContext2D().drawImage(imagen, 1, 1, 75, 75);
        canvas.getGraphicsContext2D().fillOval(goku.obtenerUbicacion().obtenerUbicacionHorizontal() + 20 + this.x, goku.obtenerUbicacion().obtenerUbicacionVertical() + 500 + this.y, 30, 30);
    }

    public void update(int x, int y) {
    	this.x += x;
    	this.y += y;
    	this.dibujar();
    }

}
