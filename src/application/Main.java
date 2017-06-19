package application;
	
import DragonBall.Cell;
import DragonBall.Equipo;
import DragonBall.Freezer;
import DragonBall.Gohan;
import DragonBall.Goku;
import DragonBall.Juego;
import DragonBall.Jugador;
import DragonBall.MajinBoo;
import DragonBall.Piccolo;
import DragonBall.Tablero;
import eventos.AplicacionOnKeyPressEventHandler;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			
			stage.setTitle("DragonBall");
			Juego juego = new Juego();
			Tablero tablero = juego.obtenerTablero();
			Goku goku = new Goku(tablero);
			Piccolo piccolo = new Piccolo(tablero);
			Gohan gohan = new Gohan(tablero);
			Freezer freezer = new Freezer(tablero);
			Cell cell = new Cell(tablero);
			MajinBoo boo = new MajinBoo(tablero);
			Jugador jugador1 = juego.obtenerJugador1();
			Jugador jugador2 = juego.obtenerJugador2();
			Equipo equipo1 = new Equipo();
			equipo1.asignarPersonajes(goku, gohan, piccolo);
			Equipo equipo2 = new Equipo();
			equipo2.asignarPersonajes(freezer, cell, boo);
			

			jugador1.asignarEquipo(equipo1);
			jugador2.asignarEquipo(equipo2);
			
			tablero.ubicarPersonajesJugador1(jugador1);
			tablero.ubicarPersonajesJugador2(jugador2);
			
			juego.empiezaJuego();
			
			Batalla batalla = new Batalla(stage, goku, gohan, piccolo, freezer, cell, boo, juego);
			Scene scene = new Scene(batalla, 30, 30);
			
			AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, batalla.getBarraDeMenu());
	        scene.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
			
			ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, scene);
			Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 800, 600);
			
			stage.setScene(escenaBienvenidos);
			stage.setFullScreen(true);
			
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
