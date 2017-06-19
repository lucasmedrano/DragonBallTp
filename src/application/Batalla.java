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
import DragonBall.Cell;
import DragonBall.Freezer;
import DragonBall.Gohan;
import DragonBall.Goku;
import DragonBall.Juego;
import DragonBall.MajinBoo;
import DragonBall.Piccolo;
import eventos.BotonFinalizarTurnoHandler;
import eventos.BotonMoverAbajoHandler;
import eventos.BotonMoverArribaHandler;
import eventos.BotonMoverDerechaHandler;
import eventos.BotonMoverIzquierdaHandler;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;




public class Batalla extends BorderPane{
	BarraDeMenu menuBar;
	Canvas canvasCentral;
	VBox contenedorCentral;
	VistaGoku vistaGoku;
	VistaGoku vistaGohan;
	VistaGoku vistaPiccolo;
	
	public Batalla(Stage stage, Goku goku, Gohan gohan, Piccolo piccolo, Freezer freezer, Cell cell, MajinBoo boo, Juego juego) {
        this.setMenu(stage);
        this.setCentro(goku, gohan, piccolo, freezer, cell, boo);
        this.setBotonera(goku, juego);
    }


	    private void setMenu(Stage stage) {
	        this.menuBar = new BarraDeMenu(stage);
	        this.setTop(menuBar);
	    }
	    
	    private void setBotonera(Goku goku, Juego juego) {

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
	        
	        BotonFinalizarTurnoHandler finalizarTurnoHandler = new BotonFinalizarTurnoHandler(juego);
	        finalizarTurno.setOnAction(finalizarTurnoHandler);
	        
	        BotonMoverArribaHandler moveButtonArribaHandler = new BotonMoverArribaHandler(vistaGoku, goku);
	        moverArriba.setOnAction(moveButtonArribaHandler);
	        
	        BotonMoverAbajoHandler moveButtonAbajoHandler = new BotonMoverAbajoHandler(vistaGoku, goku);
	        moverAbajo.setOnAction(moveButtonAbajoHandler);
	        
	        BotonMoverDerechaHandler moveButtonDerechaHandler = new BotonMoverDerechaHandler(vistaGoku, goku);
	        moverDerecha.setOnAction(moveButtonDerechaHandler);
	        
	        BotonMoverIzquierdaHandler moveButtonIzquierdaHandler = new BotonMoverIzquierdaHandler(vistaGoku, goku);
	        moverIzquierda.setOnAction(moveButtonIzquierdaHandler);
	        
	        
	        GridPane grid = new GridPane();
	        grid.setVgap(27);
	        grid.setHgap(10);
	        
	        grid.add(ataqueBasico, 0, 3);
	        grid.add(ataqueEspecial, 0, 4);
	        grid.add(transformacion1, 0, 5);
	        grid.add(transformacion2, 0, 6);
	        grid.add(moverArriba, 2, 15);
	        grid.add(moverAbajo, 2, 17);
	        grid.add(moverIzquierda, 1, 16);
	        grid.add(moverDerecha, 3, 16);
	        grid.add(finalizarTurno, 0, 26);
	        grid.setPadding(new Insets(20));

	        this.setLeft(grid);

	    }

	    private void setCentro(Goku goku, Gohan gohan, Piccolo piccolo, Freezer freezer, Cell cell, MajinBoo boo) {
	    	
	    	canvasCentral = new Canvas(1500, 1500);
	    	vistaGoku = new VistaGoku(goku, canvasCentral);
	        vistaGoku.dibujar();
	        
	        vistaGohan = new VistaGohan(gohan, canvasCentral);
	        vistaGohan.dibujar();
	        
	        vistaPiccolo = new VistaPiccolo(piccolo, canvasCentral);
	        vistaPiccolo.dibujar();
	        
	        contenedorCentral = new VBox(canvasCentral);
	        Image imagen = new Image("file:src/imagenes/campo.jpg");
	        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	        contenedorCentral.setBackground(new Background(imagenDeFondo));

	        this.setCenter(contenedorCentral);
	    }

	    public BarraDeMenu getBarraDeMenu() {
	        return menuBar;
	    }

}
