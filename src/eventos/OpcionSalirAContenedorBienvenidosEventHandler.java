package eventos;

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
import application.Batalla;
import application.CampoBatalla;
import application.ContenedorBienvenidos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpcionSalirAContenedorBienvenidosEventHandler implements EventHandler<ActionEvent>{
	
	Stage stage;
	public OpcionSalirAContenedorBienvenidosEventHandler(Stage stage) {
		this.stage = stage;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
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
		equipo1.asignarPersonajes(gohan,goku, piccolo);
		Equipo equipo2 = new Equipo();
		equipo2.asignarPersonajes(freezer, cell, boo);
		

		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		
		tablero.ubicarPersonajesJugador1(jugador1);
		tablero.ubicarPersonajesJugador2(jugador2);
		
		juego.empiezaJuego();
		CampoBatalla campoBatalla = new CampoBatalla(stage, juego);

		Scene scene = new Scene(campoBatalla, 1500, 800);
		
		AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, campoBatalla.getBarraDeMenu());
        scene.setOnKeyPressed(AplicacionOnKeyPressEventHandler);

		ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, scene);
		Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 800, 600);
		
		stage.setScene(escenaBienvenidos);
		stage.setFullScreen(true);
		
		stage.show();
	}

}
