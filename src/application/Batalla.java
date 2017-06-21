package application;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.Label;

import DragonBall.Cell;
import DragonBall.Freezer;
import DragonBall.Gohan;
import DragonBall.Goku;
import DragonBall.Cell;
import DragonBall.Juego;
import DragonBall.MajinBoo;
import DragonBall.Piccolo;
import eventos.BotonEntrarEventHandler;
import eventos.BotonFinalizarTurnoHandler;
import eventos.BotonMoverAbajoHandler;
import eventos.BotonMoverArribaHandler;
import eventos.BotonMoverDerechaHandler;
import eventos.BotonMoverIzquierdaHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;




public class Batalla extends BorderPane{
	BarraDeMenu menuBar;
	Canvas canvasCentral;
	VBox contenedorCentral;
	VistaGoku vistaGoku;
	VistaGohan vistaGohan;
	VistaPiccolo vistaPiccolo;
	VistaCell vistaCell;
	VistaFreezer vistaFreezer;
	VistaMajinBoo vistaMajinBoo;
	
	CampoBatalla campo;

	public Batalla(Stage stage, Goku goku, Gohan gohan, Piccolo piccolo, Freezer freezer, Cell cell, MajinBoo boo, Juego juego) {

        this.setMenu(stage);
        this.setCentro(goku, gohan, piccolo, freezer, cell, boo);
        this.setBotonera(goku, gohan, piccolo, freezer, cell, boo, juego);
    }


	    private void setMenu(Stage stage) {
	        this.menuBar = new BarraDeMenu(stage);
	        this.setTop(menuBar);
	    }
	    
	    private void setBotonera(Goku goku, Gohan gohan, Piccolo piccolo, Freezer freezer, Cell cell, MajinBoo boo, Juego juego) {

	        Button ataqueBasico = new Button();
	        ataqueBasico.setText("Ataque Basico");
	        
	        Button ataqueEspecial = new Button();
	        ataqueEspecial.setText("Ataque Especial");
	        
	        Button transformacion1 = new Button();
	        transformacion1.setText("Transformacion 1");
	        
	        Button transformacion2 = new Button();
	        transformacion2.setText("Transformacion 2");
	        
	        Button moverArriba = new Button();
	        moverArriba.setText("Norte");
	        
	        Button moverAbajo = new Button();
	        moverAbajo.setText("Sur");
	        
	        Button moverDerecha = new Button();
	        moverDerecha.setText("Este");
	        
	        Button moverIzquierda = new Button();
	        moverIzquierda.setText("Oeste");
	        
	        Button finalizarTurno = new Button();
	        finalizarTurno.setText("Finaliza Turno");
	        	        
	        ObservableList<String> personajes = FXCollections.observableArrayList("MajinBoo", "Cell", "Freezer", "Piccolo", "Gohan", "Goku");
	        
	        final Spinner<String> spinner = new Spinner<String>();
	        SpinnerValueFactory<String> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<String>(personajes);
	        valueFactory.setValue("Goku");
	        spinner.setValueFactory(valueFactory);
	        
	        BotonFinalizarTurnoHandler finalizarTurnoHandler = new BotonFinalizarTurnoHandler(juego);
	        finalizarTurno.setOnAction(finalizarTurnoHandler);
	        
	        if ((spinner.getValue()).equals("Goku")){
	        	BotonMoverArribaHandler moveButtonArribaHandler = new BotonMoverArribaHandler(vistaGoku, goku);
	        	moverArriba.setOnAction(moveButtonArribaHandler);
	        
	        	BotonMoverAbajoHandler moveButtonAbajoHandler = new BotonMoverAbajoHandler(vistaGoku, goku);
	        	moverAbajo.setOnAction(moveButtonAbajoHandler);
	        
	        	BotonMoverDerechaHandler moveButtonDerechaHandler = new BotonMoverDerechaHandler(vistaGoku, goku);
	        	moverDerecha.setOnAction(moveButtonDerechaHandler);
	        
	        	BotonMoverIzquierdaHandler moveButtonIzquierdaHandler = new BotonMoverIzquierdaHandler(vistaGoku, goku);
	        	moverIzquierda.setOnAction(moveButtonIzquierdaHandler);
	        }else if ((spinner.getValue()).equals("Gohan")){
	        		BotonMoverArribaHandler moveButtonArribaHandler = new BotonMoverArribaHandler(vistaGohan, gohan);
	        		moverArriba.setOnAction(moveButtonArribaHandler);
	        
	        		BotonMoverAbajoHandler moveButtonAbajoHandler = new BotonMoverAbajoHandler(vistaGohan, gohan);
	        		moverAbajo.setOnAction(moveButtonAbajoHandler);
	        
	        		BotonMoverDerechaHandler moveButtonDerechaHandler = new BotonMoverDerechaHandler(vistaGohan, gohan);
	        		moverDerecha.setOnAction(moveButtonDerechaHandler);
	        
	        		BotonMoverIzquierdaHandler moveButtonIzquierdaHandler = new BotonMoverIzquierdaHandler(vistaGohan, gohan);
	        		moverIzquierda.setOnAction(moveButtonIzquierdaHandler);
	        	}else if ((spinner.getValue()).equals("Piccolo")){
	        			BotonMoverArribaHandler moveButtonArribaHandler = new BotonMoverArribaHandler(vistaPiccolo, piccolo);
	        			moverArriba.setOnAction(moveButtonArribaHandler);
        
	        			BotonMoverAbajoHandler moveButtonAbajoHandler = new BotonMoverAbajoHandler(vistaPiccolo, piccolo);
	        			moverAbajo.setOnAction(moveButtonAbajoHandler);
        
	        			BotonMoverDerechaHandler moveButtonDerechaHandler = new BotonMoverDerechaHandler(vistaPiccolo, piccolo);
	        			moverDerecha.setOnAction(moveButtonDerechaHandler);
        
	        			BotonMoverIzquierdaHandler moveButtonIzquierdaHandler = new BotonMoverIzquierdaHandler(vistaPiccolo, piccolo);
	        			moverIzquierda.setOnAction(moveButtonIzquierdaHandler);
	        		}else if ((spinner.getValue()).equals("Freezer")){
		        			BotonMoverArribaHandler moveButtonArribaHandler = new BotonMoverArribaHandler(vistaFreezer, freezer);
		        			moverArriba.setOnAction(moveButtonArribaHandler);
		        
		        			BotonMoverAbajoHandler moveButtonAbajoHandler = new BotonMoverAbajoHandler(vistaFreezer, freezer);
		        			moverAbajo.setOnAction(moveButtonAbajoHandler);
		        
		        			BotonMoverDerechaHandler moveButtonDerechaHandler = new BotonMoverDerechaHandler(vistaFreezer, freezer);
		        			moverDerecha.setOnAction(moveButtonDerechaHandler);
		        
		        			BotonMoverIzquierdaHandler moveButtonIzquierdaHandler = new BotonMoverIzquierdaHandler(vistaFreezer, freezer);
		        			moverIzquierda.setOnAction(moveButtonIzquierdaHandler);
	        			}else if ((spinner.getValue()).equals("Cell")){
	    	        			BotonMoverArribaHandler moveButtonArribaHandler = new BotonMoverArribaHandler(vistaCell, cell);
	    	        			moverArriba.setOnAction(moveButtonArribaHandler);
	    	        
	    	        			BotonMoverAbajoHandler moveButtonAbajoHandler = new BotonMoverAbajoHandler(vistaCell, cell);
	    	        			moverAbajo.setOnAction(moveButtonAbajoHandler);
	    	        
	    	        			BotonMoverDerechaHandler moveButtonDerechaHandler = new BotonMoverDerechaHandler(vistaCell, cell);
	    	        			moverDerecha.setOnAction(moveButtonDerechaHandler);
	    	        
	    	        			BotonMoverIzquierdaHandler moveButtonIzquierdaHandler = new BotonMoverIzquierdaHandler(vistaCell, cell);
	    	        			moverIzquierda.setOnAction(moveButtonIzquierdaHandler);
	        				}else if ((spinner.getValue()).equals("MajinBoo")){
	        	        			BotonMoverArribaHandler moveButtonArribaHandler = new BotonMoverArribaHandler(vistaMajinBoo, boo);
	        	        			moverArriba.setOnAction(moveButtonArribaHandler);
	        	        			
	        	        			BotonMoverAbajoHandler moveButtonAbajoHandler = new BotonMoverAbajoHandler(vistaMajinBoo, boo);
	        	        			moverAbajo.setOnAction(moveButtonAbajoHandler);
	        	        
	        	        			BotonMoverDerechaHandler moveButtonDerechaHandler = new BotonMoverDerechaHandler(vistaMajinBoo, boo);
	        	        			moverDerecha.setOnAction(moveButtonDerechaHandler);
	        	        		
	        	        			BotonMoverIzquierdaHandler moveButtonIzquierdaHandler = new BotonMoverIzquierdaHandler(vistaMajinBoo, boo);
	        	        			moverIzquierda.setOnAction(moveButtonIzquierdaHandler);
	        					}
	        
	        
	        GridPane grid = new GridPane();
	        grid.setVgap(27);
	        grid.setHgap(10);
	        
	        grid.add(spinner, 0, 14);
	        grid.add(ataqueBasico, 0, 3);
	        grid.add(ataqueEspecial, 0, 4);
	        grid.add(transformacion1, 0, 5);
	        grid.add(transformacion2, 0, 6);
	        grid.add(moverArriba, 2, 15);
	        grid.add(moverAbajo, 2, 17);
	        grid.add(moverIzquierda, 1, 16);
	        grid.add(moverDerecha, 3, 16);
	        grid.add(finalizarTurno, 0, 10);
	        grid.setPadding(new Insets(20));

	        this.setLeft(grid);

	    }

	    private void setCentro(Goku goku, Gohan gohan, Piccolo piccolo, Freezer freezer, Cell cell, MajinBoo boo) {

	    	
	    	canvasCentral = new Canvas(1500, 1500);
	    	vistaGoku = new VistaGoku(goku, canvasCentral, 20, 500);
	    	vistaGohan = new VistaGohan(gohan, canvasCentral, 20, 400);
	    	vistaPiccolo = new VistaPiccolo(piccolo, canvasCentral, 20, 600);
	    	vistaCell = new VistaCell(cell, canvasCentral, 900, 500);
	    	vistaFreezer = new VistaFreezer(freezer, canvasCentral, 900, 400);
	    	vistaMajinBoo = new VistaMajinBoo(boo,canvasCentral, 900, 600);
	        vistaGoku.dibujar();
	        vistaGohan.dibujar();
	        vistaPiccolo.dibujar();
	        vistaCell.dibujar();
	        vistaMajinBoo.dibujar();
	        vistaFreezer.dibujar();
	        contenedorCentral = new VBox(canvasCentral);
	        Image imagen = new Image("file:src/imagenes/campo.jpg");
	        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	        contenedorCentral.setBackground(new Background(imagenDeFondo));

	        this.setCenter(contenedorCentral);
	    }

	    public BarraDeMenu getBarraDeMenu() {
	        return campo.getBarraDeMenu();
	    }

}
