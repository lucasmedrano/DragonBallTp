package view;

import DragonBall.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Jugador;
import view.eventos.BotonEntrarEventHandler;
import view.eventos.OpcionSalirEventHandler;

/**
 *
 * @author Martin
 */
public class ContenedorGanador extends VBox {

	public ContenedorGanador(Stage stage, Jugador ganador) {

		super();
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
		this.setPadding(new Insets(25));
		Image imagen = new Image("file:src/fondo.jpg");
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		this.setBackground(new Background(imagenDeFondo));

		Label etiqueta = new Label();
		etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 24));

		Button botonSalir = new Button();
		botonSalir.setText("Salir");
		botonSalir.setMinHeight(50);
		botonSalir.setMinWidth(100);

		OpcionSalirEventHandler botonSalirHandler = new OpcionSalirEventHandler();
		botonSalir.setOnAction(botonSalirHandler);

		etiqueta.setText("FELICITACIONES, GANARON LOS " + ganador.obtenerEquipo());
		etiqueta.setTextFill(Color.web("#66A7C5"));

		this.getChildren().addAll(etiqueta, botonSalir);
	}

}