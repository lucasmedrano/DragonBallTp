package application;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import DragonBall.Cell;

public class VistaCell {

    private Cell cell;
    Canvas canvas;
    private int x;
    private int y;
    

    public VistaCell(Cell cell, Canvas canvas) {
        this.cell = cell;
        this.canvas = canvas;
        this.x = 0;
        this.y = 0;
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
    	Image imagen = new Image(cell.delvolverRutaNormal());
    	canvas.getGraphicsContext2D().drawImage(imagen, cell.obtenerUbicacion().obtenerUbicacionHorizontal() + 900 + this.x, cell.obtenerUbicacion().obtenerUbicacionVertical() + 500 + this.y, 50, 100);
    }

    public void update(int x, int y) {
    	Image image = new Image("file:src/imagenes/pedazoCampo.jpg");
    	canvas.getGraphicsContext2D().drawImage(image, cell.obtenerUbicacion().obtenerUbicacionHorizontal() + 20 + this.x, cell.obtenerUbicacion().obtenerUbicacionVertical() + 500 + this.y, 50, 100);
    	this.x += x;
    	this.y += y;
    	this.dibujar();
    }

}