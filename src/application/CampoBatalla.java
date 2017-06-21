package application;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CampoBatalla extends BorderPane{
	private Image fondo; 
    private Casillero [][] casilleros;
    BarraDeMenu menuBar;
    int x;
	int y;
	
	
	Image imagen_seleccionada;
	int x_seleccionado;
	int y_seleccionado;
	
    public CampoBatalla(Stage stage) {
        this.fondo = new Image("file:src/imagenes/campo.jpg");
        this.setMenu(stage);
        this.iniciarCampo();
    }
    
    public void iniciarCampo(){
    	
    	casilleros = new Casillero [10][10];
    	for(int i = 0; i < 10; i++){
    		for(int j = 0; j < 10; j++){
    			casilleros[i][j] = new Casillero(j, i);
    			casilleros[i][j].setearImagen(this.fondo, 100, 100, true);
    		}
    	}
    	dibujarCampo();
    	colocarPersonajes();
    }
    
    private void dibujarCampo(){
    	
    	GridPane grid = new GridPane();
        grid.setVgap(0);
        grid.setHgap(0);
        
        for(int i = 0; i < 10; i++){
    		for(int j = 0; j < 10; j++){
    			grid.add(casilleros[i][j], i, j);
    		}
    	}
        grid.setPadding(new Insets(20));
        this.setCenter(grid);
        
    }
    
    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }
    
    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
    
    public void dibujarPersonaje(Image imagen, int x, int y){
    	casilleros[y][x].setearImagen(imagen, 100, 60, false);
    }
    
    public void dibujarFondo(int x, int y){
    	casilleros[y][x].setearImagen(this.fondo, 100, 100, true);
    }
    
    public void colocarPersonajes(){
    	Image gohanImagen = new Image("file:src/Guerreros/gohan.png");
    	Image gokuImagen = new Image("file:src/Guerreros/Goku.png");
    	Image piccoloImagen = new Image("file:src/Guerreros/piccolo.png");
    	Image cellImagen = new Image("file:src/Guerreros/cell.png");
    	Image freezerImagen = new Image("file:src/Guerreros/freezer.png");
    	Image majinbooImagen = new Image("file:src/Guerreros/boo normal.png");
    	dibujarPersonaje(gokuImagen, 5, 0);
    	dibujarPersonaje(gohanImagen, 4, 0);
    	dibujarPersonaje(piccoloImagen, 6, 0);
    	dibujarPersonaje(freezerImagen, 4, 9);
    	dibujarPersonaje(cellImagen, 5, 9);
    	dibujarPersonaje(majinbooImagen, 6, 9);
    }
    
    public void moverPersonaje(Image imagen, int x_viejo, int y_viejo, int x_nuevo, int y_nuevo){
    	dibujarFondo(x_viejo, y_viejo);
    	dibujarPersonaje(imagen, x_nuevo, y_nuevo);
    }
    
}

