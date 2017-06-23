package application;

import DragonBall.Personaje;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Casillero extends ImageView{
	Image imagen;
	Personaje personaje;
	int x;
	int y;
	
	public Casillero(int x, int y){
        this.x = x;
        this.y = y;
        this.personaje = null;
	}
	
	public void setearImagen(Image imagen_nueva, double width, double height, boolean preservratio){
		this.imagen = imagen_nueva;
		this.setImage(imagen_nueva);
        this.setFitWidth(width);
        this.setFitHeight(height);
        this.setPreserveRatio(preservratio);
        this.setSmooth(true);
	}
	
	public int obtenerX(){
		return this.x;
	}
	
	public int obtenerY(){
		return this.y;
	}

	public void setearPersonaje(Personaje personaje){
		this.personaje = personaje;
	}
	
	public Personaje obtenerPersonaje(){
		return this.personaje;
	}
}
