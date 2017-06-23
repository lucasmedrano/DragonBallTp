package application;

import DragonBall.Cell;
import DragonBall.Freezer;
import DragonBall.Gohan;
import DragonBall.Goku;
import DragonBall.Juego;
import DragonBall.MajinBoo;
import DragonBall.Personaje;
import DragonBall.Piccolo;
import eventos.BotonFinalizarTurnoHandler;
import eventos.BotonMoverAbajoHandler;
import eventos.BotonMoverArribaHandler;
import eventos.BotonMoverDerechaHandler;
import eventos.BotonMoverIzquierdaHandler;
import eventos.SeleccionarPersonajeEventHandler;
import eventos.Transformar1EventHandler;
import eventos.Transformar2EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CampoBatalla extends BorderPane{
	private Image fondo; 
    private GridPane casilleros;
    BarraDeMenu menuBar;
	VistaGoku vistaGoku;
	VistaGohan vistaGohan;
	VistaPiccolo vistaPiccolo;
	VistaCell vistaCell;
	VistaFreezer vistaFreezer;
	VistaMajinBoo vistaMajinBoo;
	Personaje personaje_seleccionado;
	VistaPersonaje vista_seleccionada;
	Label vida;
	GridPane datosYBotones;
	
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
    	this.datosYBotones = new GridPane();
        this.datosYBotones.setVgap(2);
        this.datosYBotones.setHgap(1);
        this.vida = new Label("");
        Button finalizarTurno = new Button();
        finalizarTurno.setText("Finaliza Turno");
        BotonFinalizarTurnoHandler finalizarTurnoHandler = new BotonFinalizarTurnoHandler(juego);
        finalizarTurno.setOnAction(finalizarTurnoHandler);
        
        Button transf1 = new Button();
        transf1.setText("Transformacion 1");
        Transformar1EventHandler transformarPersonajeA1 = new Transformar1EventHandler(this);
        transf1.setOnAction(transformarPersonajeA1);
        
        Button transf2 = new Button();
        transf2.setText("Transformacion 2");
        Transformar2EventHandler transformarPersonajeA2 = new Transformar2EventHandler(this);
        transf2.setOnAction(transformarPersonajeA2);
        
        Button moverArriba = new Button();
        moverArriba.setText("↑");
        BotonMoverArribaHandler moverArribaHandler = new BotonMoverArribaHandler(this);
        moverArriba.setOnAction(moverArribaHandler);
        
        Button moverAbajo = new Button();
        moverAbajo.setText("↓");
        BotonMoverAbajoHandler moverAbajoHandler = new BotonMoverAbajoHandler(this);
        moverAbajo.setOnAction(moverAbajoHandler);
        Button moverDerecha = new Button();
        moverDerecha.setText("→");
        BotonMoverDerechaHandler moverDerechaHandler = new BotonMoverDerechaHandler(this);
        moverDerecha.setOnAction(moverDerechaHandler);
        Button moverIzquierda = new Button();
        moverIzquierda.setText("←");
        BotonMoverIzquierdaHandler moverIzquierdaHandler = new BotonMoverIzquierdaHandler(this);
        moverIzquierda.setOnAction(moverIzquierdaHandler);

        this.datosYBotones.add(finalizarTurno, 1, 10);
        this.datosYBotones.add(transf1, 1, 11);
        this.datosYBotones.add(transf2, 1, 12);
        this.datosYBotones.add(moverArriba, 1, 13);
        this.datosYBotones.add(moverAbajo, 1, 15);
        this.datosYBotones.add(moverIzquierda, 0, 14);
        this.datosYBotones.add(moverDerecha, 2, 14);
        this.datosYBotones.setPadding(new Insets(100));	
        this.datosYBotones.add(vida, 1, 2);
        this.setLeft(datosYBotones);
    }
    
    public void iniciarCampo(Goku goku, Gohan gohan, Piccolo piccolo, Freezer freezer, Cell cell, MajinBoo boo){	
    	casilleros = new GridPane();
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
    	this.setearEventos();
    }
     
    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }
    
    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }
    
    public void dibujarFondo(int x, int y){
    	((Casillero) this.casilleros.getChildren().get(10*x + y)).setearImagen(this.fondo, 70, 70, true);
    	((Casillero) this.casilleros.getChildren().get(10*x + y)).setearPersonaje(null);
    	
    }
    
    public void colocarPersonajes(){
    	vistaGoku.dibujarInicial();
    	vistaGohan.dibujarInicial();
    	vistaPiccolo.dibujarInicial();
    	vistaFreezer.dibujarInicial();
    	vistaCell.dibujarInicial();
    	vistaMajinBoo.dibujarInicial();
    }
    
    public void setearEventos(){
    	int x;
    	int y;
    	for(int i = 0; i < 10; i++){
    		for(int j = 0; j < 10; j++){
    			x = j;
    			y = i;
    	    	Casillero casillero = (Casillero) this.casilleros.getChildren().get(10*x + y);
    	    	SeleccionarPersonajeEventHandler eventoSeleccionar = new SeleccionarPersonajeEventHandler(casillero, this);
    	    	
    	        casillero.setOnMouseClicked(eventoSeleccionar);
    		}
    	}
    }   

    public void actualizarVistaSeleccionada(){
    	if(personaje_seleccionado instanceof Goku) vista_seleccionada = vistaGoku;
    	else if(personaje_seleccionado instanceof Gohan) vista_seleccionada =vistaGohan;
    	else if(personaje_seleccionado instanceof Piccolo) vista_seleccionada = vistaPiccolo;
    	else if(personaje_seleccionado instanceof Cell) vista_seleccionada = vistaCell;
    	else if(personaje_seleccionado instanceof Freezer) vista_seleccionada = vistaFreezer;
    	else if(personaje_seleccionado instanceof MajinBoo) vista_seleccionada = vistaMajinBoo;
    }
    
    public void setearPersonajeSeleccionado(Personaje personaje){
    	this.personaje_seleccionado = personaje;
    }
    
    public Personaje obtenerPersonajeSeleccionado(){
    	return this.personaje_seleccionado;
    }

    public VistaPersonaje obtenerVistaSeleccionada(){
    	return this.vista_seleccionada;
    }
    
    public void actualizarDatos(){
        this.vida.setText((Integer.toString(this.personaje_seleccionado.obtenerVida())));
        ImageView imagen_personaje_seleccionado = new ImageView();
        
        imagen_personaje_seleccionado.setImage(this.vista_seleccionada.obtenerImagenCircular());
        imagen_personaje_seleccionado.setFitHeight(200);
        imagen_personaje_seleccionado.setPreserveRatio(true);
    	
        this.datosYBotones.add(imagen_personaje_seleccionado, 1, 0);
    }
}

