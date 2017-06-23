package application;

import DragonBall.Personaje;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public abstract class VistaPersonaje {
	GridPane grid;
    private Personaje personaje;
    String rutaNormal;
    String rutaTransf1;
    String rutaTransf2;
    
    Image imagen;
    
    
    public VistaPersonaje(Personaje personaje, GridPane grid) {
        this.personaje = personaje;
    	this.grid = grid;
    }
    
    public void dibujarInicial(){
    	this.imagen = new Image(this.rutaNormal);
    	int x = this.personaje.obtenerUbicacion().obtenerUbicacionHorizontal();
    	int y = this.personaje.obtenerUbicacion().obtenerUbicacionVertical();
    	Casillero casillero = (Casillero) this.grid.getChildren().get(10*x + y);
    	casillero.setearImagen(this.imagen, 70, 70, true);
    	casillero.setearPersonaje(personaje);
    }
    
    public void dibujar() {
    	int x = this.personaje.obtenerUbicacion().obtenerUbicacionHorizontal();
    	int y = this.personaje.obtenerUbicacion().obtenerUbicacionVertical();
    	Casillero casillero = (Casillero) this.grid.getChildren().get(10*x + y);
    	casillero.setearImagen(this.imagen, 70, 70, true);
    	casillero.setearPersonaje(personaje);
    }

    public void actualizarATransformacion1(){
    	imagen = new Image(rutaTransf1);
    }

    public void actualizarATransformacion2(){
    	imagen = new Image(rutaTransf2);
    }
}
