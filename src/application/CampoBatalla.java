package application;

import DragonBall.Cell;
import DragonBall.Freezer;
import DragonBall.Gohan;
import DragonBall.Goku;
import DragonBall.Juego;
import DragonBall.MajinBoo;
import DragonBall.Piccolo;
import eventos.BotonFinalizarTurnoHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
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
	
	VistaGoku vistaGoku;
	VistaGohan vistaGohan;
	VistaPiccolo vistaPiccolo;
	VistaCell vistaCell;
	VistaFreezer vistaFreezer;
	VistaMajinBoo vistaMajinBoo;
	
    public CampoBatalla(Stage stage, Juego juego, Goku goku, Gohan gohan, Piccolo piccolo, Freezer freezer, Cell cell, MajinBoo boo) {
    	
        this.fondo = new Image("file:src/imagenes/campo.jpg");
        this.setMenu(stage);
        this.iniciarCampo(goku, gohan, piccolo, freezer, cell, boo);
        this.setInformacionAliados(juego);
        this.setInformacionEnemigos();
    }
             
    private void setInformacionEnemigos() {
    	GridPane grid = new GridPane();
        grid.setVgap(0);
        grid.setHgap(0);
            	
        grid.setPadding(new Insets(100));	
    }
        
    private void setInformacionAliados(Juego juego) {
    	GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(0);
        
        Button finalizarTurno = new Button();
        finalizarTurno.setText("Finaliza Turno");
        
        BotonFinalizarTurnoHandler finalizarTurnoHandler = new BotonFinalizarTurnoHandler(juego);
        finalizarTurno.setOnAction(finalizarTurnoHandler);
        
        grid.add(finalizarTurno, 0, 10);
        grid.setPadding(new Insets(100));	
        this.setLeft(grid);
    }
    
    public void iniciarCampo(Goku goku, Gohan gohan, Piccolo piccolo, Freezer freezer, Cell cell, MajinBoo boo){
    	
    	GridPane casilleros = new GridPane();
    	casilleros.setVgap(0);
    	casilleros.setHgap(0);
    	for(int i = 0; i < 10; i++){
    		for(int j = 0; j < 10; j++){
    			Casillero casillero = new Casillero(j, i);
    			casillero.setearImagen(this.fondo, 70, 70, true);
    			casilleros.add(casillero, i, j);
    		}
    	}
    	this.vistaGoku = new VistaGoku(goku, casilleros);
    	this.vistaGohan = new VistaGohan(gohan, casilleros);
    	this.vistaPiccolo = new VistaPiccolo(piccolo, casilleros);
    	this.vistaFreezer = new VistaFreezer(freezer, casilleros);
    	this.vistaCell = new VistaCell(cell, casilleros);
    	this.vistaMajinBoo = new VistaMajinBoo(boo, casilleros);
    	colocarPersonajes();
    	this.setCenter(casilleros);
    }
    
    
    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }
    
    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
    
    public void dibujarFondo(int x, int y){
    	casilleros[y][x].setearImagen(this.fondo, 70, 70, true);
    }
    
    public void colocarPersonajes(){
    	vistaGoku.dibujarInicial();
    	vistaGohan.dibujarInicial();
    	vistaPiccolo.dibujarInicial();
    	vistaFreezer.dibujarInicial();
    	vistaCell.dibujarInicial();
    	vistaMajinBoo.dibujarInicial();
    }
   
    
}

