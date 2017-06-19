package application;

import DragonBall.MajinBoo;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;


public class VistaMajinBoo {

    private MajinBoo majinBoo;
    Canvas canvas;
    private int x;
    private int y;

    public VistaMajinBoo(MajinBoo majinboo, Canvas canvas) {
        this.majinBoo = majinboo;
        this.canvas = canvas;
        this.x = 0;
        this.y = 0;
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
    	Image imagen = new Image(majinBoo.delvolverRutaNormal());
      	canvas.getGraphicsContext2D().drawImage(imagen, majinBoo.obtenerUbicacion().obtenerUbicacionHorizontal() + 900 + this.x, majinBoo.obtenerUbicacion().obtenerUbicacionVertical() + 600 + this.y, 50, 100);
    }

    public void update(int x, int y) {
    	this.x += x;
    	this.y += y;
    	this.dibujar();
    }

}
