package application;

import DragonBall.Personaje;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

public abstract class VistaPersonaje {
	GridPane grid;
    private Personaje personaje;
    String rutaNormal;
    String rutaTransf1;
    String rutaTransf2;
    String rutacircnormal;
    String rutacirc1;
    String rutacirc2;
    Image imagen;
    Image imagenChocolate;
    Image imagencircular;
    
    
    public VistaPersonaje(Personaje personaje, GridPane grid) {
        this.personaje = personaje;
    	this.grid = grid;
    	this.imagenChocolate = new Image("file:src/imagenes/chocolate.jpg");
    	
    }
    
    public void dibujarInicial(){
    	this.imagencircular = new Image(this.rutacircnormal);
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
    	if (this.personaje.obtenerVida() <= 0){
    		this.imagen = new Image("file:src/imagenes/campo.jpg");
    		casillero.setearImagen(this.imagen, 70, 70, true);
        	casillero.setearPersonaje(null);
        	return;
    	}
    	if (this.personaje.estaInmovilizado()){
    		casillero.setearImagen(this.imagenChocolate, 70, 70, true);
        	casillero.setearPersonaje(personaje);
        	return;
    	}
    	casillero.setearImagen(this.imagen, 70, 70, true);
    	casillero.setearPersonaje(personaje);
    }

    public void actualizarATransformacion1(){
    	this.imagen = new Image(rutaTransf1);
    	this.imagencircular = new Image(rutacirc1);
    }

    public void actualizarATransformacion2(){
    	this.imagen = new Image(rutaTransf2);
    	this.imagencircular = new Image(rutacirc2);
    }
    
    public Image obtenerImagen(){
    	return this.imagen;
    }
    
    public Image obtenerImagenCircular(){
    	return this.imagencircular;
    	
    }
    
    public Personaje obtenerPersonaje(){
    	return personaje;
    }
    
    
}
