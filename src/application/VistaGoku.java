package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


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
      	canvas.getGraphicsContext2D().drawImage(imagen, goku.obtenerUbicacion().obtenerUbicacionHorizontal() + 20 + this.x, goku.obtenerUbicacion().obtenerUbicacionVertical() + 500 + this.y, 50, 100);
    }

    public void update(int x, int y) {
    	Image image = new Image("file:src/imagenes/pedazoCampo.jpg");
    	canvas.getGraphicsContext2D().drawImage(image, goku.obtenerUbicacion().obtenerUbicacionHorizontal() + 20 + this.x, goku.obtenerUbicacion().obtenerUbicacionVertical() + 500 + this.y, 50, 100);
    	this.x += x;
    	this.y += y;
    	this.dibujar();
    }

}
