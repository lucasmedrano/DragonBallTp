package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

import eventos.BotonEntrarEventHandler;
import eventos.OpcionSalirEventHandler;

public class ContenedorBienvenidos extends VBox {

	private Stage stage;

	public ContenedorBienvenidos(Stage stage, Scene proximaEscena) {

		super();

		this.stage = stage;

		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
		this.setPadding(new Insets(25));
		Image imagen = new Image("file:src/fondo.jpg");
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		this.setBackground(new Background(imagenDeFondo));

		Button botonEntrar = new Button();
		botonEntrar.setText("Iniciar Partida");
		botonEntrar.setMinHeight(50);
		botonEntrar.setMinWidth(100);

		BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena);///////////////////
		botonEntrar.setOnAction(botonEntrarHandler);

		Label etiqueta = new Label();
		etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));

		Button botonSalir = new Button();
		botonSalir.setText("Salir");
		botonSalir.setMinHeight(50);
		botonSalir.setMinWidth(100);

		OpcionSalirEventHandler botonSalirHandler = new OpcionSalirEventHandler();
		botonSalir.setOnAction(botonSalirHandler);

		etiqueta.setText(
				"Haga click en el boton para iniciar la partida. Jugador 1 es Guerreros Z y Jugador 2 es Invasores de la Tierra");
		etiqueta.setTextFill(Color.web("#66A7C5"));

		this.getChildren().addAll(etiqueta, botonEntrar, botonSalir);
	}

}
