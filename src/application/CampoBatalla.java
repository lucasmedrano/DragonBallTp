package application;

import DragonBall.Cell;
import DragonBall.Freezer;
import DragonBall.Gohan;
import DragonBall.Goku;
import DragonBall.Juego;
import DragonBall.Jugador;
import DragonBall.MajinBoo;
import DragonBall.Personaje;
import DragonBall.Piccolo;
import eventos.BotonFinalizarTurnoHandler;
import eventos.BotonMoverAbajoHandler;
import eventos.BotonMoverArribaHandler;
import eventos.BotonMoverDerechaHandler;
import eventos.BotonMoverIzquierdaHandler;
import eventos.OpcionSalirAContenedorBienvenidosEventHandler;
import eventos.SeleccionarPersonajeEventHandler;
import eventos.Transformar1EventHandler;
import eventos.Transformar2EventHandler;
import eventos.BotonAtaqueBasicoHandler;
import eventos.BotonAtaqueEspecialHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CampoBatalla extends BorderPane{
	private Image fondo; 
    private GridPane casilleros;
    BarraDeMenu menuBar;
	public VistaGoku vistaGoku;
	public VistaGohan vistaGohan;
	public VistaPiccolo vistaPiccolo;
	public VistaCell vistaCell;
	public VistaFreezer vistaFreezer;
	public VistaMajinBoo vistaMajinBoo;
	Personaje personaje_seleccionado;
	VistaPersonaje vista_seleccionada;
	Juego juego;
	Label vida;
	Label ki;
	Label turno;
	Label movimientosDisponibles;
	GridPane datosYBotones;
	Stage stage;
	Label ataquesDisponibles;
	Label info;
	
    public CampoBatalla(Stage stage, Juego juego, Goku goku, Gohan gohan, Piccolo piccolo, Freezer freezer, Cell cell, MajinBoo boo) {
    	this.juego = juego;
        this.fondo = new Image("file:src/imagenes/campo.jpg");
        this.stage = stage;
        this.setMenu(stage);
        this.iniciarCampo(goku, gohan, piccolo, freezer, cell, boo);
        this.setInformacionAliados(juego);
    }
    
    private void setInformacionAliados(Juego juego) {
    	this.datosYBotones = new GridPane();
        this.datosYBotones.setVgap(2);
        this.datosYBotones.setHgap(1);
        this.vida = new Label("");
        this.ki = new Label("");
        this.movimientosDisponibles=new Label("");
        this.ataquesDisponibles=new Label("");
        this.turno = new Label("Turno de " + this.juego.obtenerJugadorActualString());
        this.info=new Label("");
        
        Button finalizarTurno = new Button();
        finalizarTurno.setText("Finaliza Turno");
        BotonFinalizarTurnoHandler finalizarTurnoHandler = new BotonFinalizarTurnoHandler(juego, this);
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
        moverArriba.setText("Arriba");
        BotonMoverArribaHandler moverArribaHandler = new BotonMoverArribaHandler(this);
        moverArriba.setOnAction(moverArribaHandler);
        
        Button moverAbajo = new Button();
        moverAbajo.setText("Abajo");
        BotonMoverAbajoHandler moverAbajoHandler = new BotonMoverAbajoHandler(this);
        moverAbajo.setOnAction(moverAbajoHandler);
        
        Button moverDerecha = new Button();
        moverDerecha.setText("Derecha");
        BotonMoverDerechaHandler moverDerechaHandler = new BotonMoverDerechaHandler(this);
        moverDerecha.setOnAction(moverDerechaHandler);
        
        Button moverIzquierda = new Button();
        moverIzquierda.setText("Izquierda");
        BotonMoverIzquierdaHandler moverIzquierdaHandler = new BotonMoverIzquierdaHandler(this);
        moverIzquierda.setOnAction(moverIzquierdaHandler);
       
        Button ataqueBasico= new Button();
        ataqueBasico.setText("Ataque Basico");
        BotonAtaqueBasicoHandler ataqueBasicoHandler = new BotonAtaqueBasicoHandler(this);
        ataqueBasico.setOnAction(ataqueBasicoHandler);
        
        Button ataqueEspecial= new Button();
        ataqueEspecial.setText("Ataque Especial");
        BotonAtaqueEspecialHandler ataqueEspecialHandler = new BotonAtaqueEspecialHandler(this);
        ataqueEspecial.setOnAction(ataqueEspecialHandler);
        
        this.datosYBotones.add(finalizarTurno, 1, 8);
        this.datosYBotones.add(transf1, 1, 11);
        this.datosYBotones.add(transf2, 1, 12);
        this.datosYBotones.add(moverArriba, 1, 13);
        this.datosYBotones.add(moverAbajo, 1, 15);
        this.datosYBotones.add(moverIzquierda, 0, 14);
        this.datosYBotones.add(moverDerecha, 1, 14);
        this.datosYBotones.add(ataqueBasico,1 ,6);
        this.datosYBotones.add(ataqueEspecial, 1, 7);
        this.datosYBotones.setPadding(new Insets(30));	
        this.datosYBotones.add(vida, 1, 1);
        this.datosYBotones.add(ki, 1, 2);
        this.datosYBotones.add(turno, 1, 5);
        this.datosYBotones.add(movimientosDisponibles, 1,3);
        this.datosYBotones.add(ataquesDisponibles, 1,4);
        this.datosYBotones.add(info, 1,20);
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
        this.vida.setText("Vida: " + (Integer.toString(this.personaje_seleccionado.obtenerVida())));
        this.ki.setText(("Ki: " + Integer.toString(this.personaje_seleccionado.obtenerKi())));
        this.movimientosDisponibles.setText(("Movimientos Disponibles: " + Integer.toString(this.personaje_seleccionado.obtenerMovimientosDisponibles())));
        this.ataquesDisponibles.setText(("Ataques Disponibles:"+ Integer.toString(this.personaje_seleccionado.obtenerAtaquesDisponibles())));
        this.info.setText("");
        ImageView imagen_personaje_seleccionado = new ImageView();
        
        imagen_personaje_seleccionado.setImage(this.vista_seleccionada.obtenerImagenCircular());
        imagen_personaje_seleccionado.setFitHeight(200);
        imagen_personaje_seleccionado.setPreserveRatio(true);
    	
        this.datosYBotones.add(imagen_personaje_seleccionado, 1, 0);
    }
    
    public void actualizarTurno(){
    	this.turno.setText("Turno de " + this.juego.obtenerJugadorActualString());
    }
    
    public void dibujarPersonajes(){
    	vistaGoku.dibujar();
    	vistaGohan.dibujar();
    	vistaPiccolo.dibujar();
    	vistaFreezer.dibujar();
    	vistaCell.dibujar();
    	vistaMajinBoo.dibujar();
    }
    
    public void chequearVictoria(){
    	Personaje personaje1 = this.juego.obtenerJugador1().obtenerEquipo().obtenerPersonaje1();
    	Personaje personaje2 = this.juego.obtenerJugador1().obtenerEquipo().obtenerPersonaje2();
    	Personaje personaje3 = this.juego.obtenerJugador1().obtenerEquipo().obtenerPersonaje3();
    	if(personaje1.obtenerVida() <= 0 && personaje2.obtenerVida() <= 0 && personaje3.obtenerVida() <= 0){
    		this.terminarJuego("enemigos de la tierra");
    	}
    	
    	personaje1 = this.juego.obtenerJugador2().obtenerEquipo().obtenerPersonaje1();
    	personaje2 = this.juego.obtenerJugador2().obtenerEquipo().obtenerPersonaje2();
    	personaje3 = this.juego.obtenerJugador2().obtenerEquipo().obtenerPersonaje3();
    	if(personaje1.obtenerVida() <= 0 && personaje2.obtenerVida() <= 0 && personaje3.obtenerVida() <= 0){
    		this.terminarJuego("guerreros Z");
    	}
    }
    
    public void terminarJuego(String ganador){
    	Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("DragonAlgoBall");
	    alert.setHeaderText("TERMINÓ EL JUEGO");
	    alert.setContentText("Ganaron los " + ganador);
	    alert.show();
	    OpcionSalirAContenedorBienvenidosEventHandler reiniciar = new OpcionSalirAContenedorBienvenidosEventHandler(this.stage);
	    reiniciar.handle(null);
    }
    
    public void setInfo(String info){
    	this.info.setText(info);
    }
}

