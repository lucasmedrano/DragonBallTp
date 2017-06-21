package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Casillero extends ImageView{
	Image imagen;
	int x;
	int y;
	
	public Casillero(int x, int y){
        this.setX(x);
        this.setY(y);
	}
	
	public void setearImagen(Image imagen_nueva, double width, double height, boolean preservratio){
		this.imagen = imagen_nueva;
		this.setImage(imagen_nueva);
        this.setFitWidth(width);
        this.setFitHeight(height);
        this.setPreserveRatio(preservratio);
        this.setSmooth(true);
	}

}
