package application;

import DragonBall.Personaje;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

public abstract class VistaPersonaje {
	Canvas canvas;
    private int x;
    private int y;
    private Personaje personaje;
    
    public VistaPersonaje(Personaje personaje, Canvas canvas, int x, int y) {
        this.personaje = personaje;
    	this.canvas = canvas;
        this.x = x;
        this.y = y;
    }
    
    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
    	Image imagen = new Image(personaje.delvolverRutaNormal());
      	canvas.getGraphicsContext2D().drawImage(imagen, personaje.obtenerUbicacion().obtenerUbicacionHorizontal() + this.x, personaje.obtenerUbicacion().obtenerUbicacionVertical() + this.y, 50, 100);
    }


	 public void update(int x, int y) {
	    	Image image = new Image("file:src/imagenes/pedazoCampo.jpg");
	    	canvas.getGraphicsContext2D().drawImage(image, personaje.obtenerUbicacion().obtenerUbicacionHorizontal() + this.x, personaje.obtenerUbicacion().obtenerUbicacionVertical() + this.y, 50, 100);
	    	this.x += x;
	    	this.y += y;
	    	this.dibujar();
	    }
}
