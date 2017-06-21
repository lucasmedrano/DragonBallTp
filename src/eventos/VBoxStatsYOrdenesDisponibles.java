package eventos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Juego;
import view.ContenedorPrincipal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import DragonBall.*;
import application.*;


public class VBoxStatsYOrdenesDisponibles {
	private static final String stringVida = "Vida: ";
	private static final String stringAtaque = "Ataque: ";
	private static final String stringKI = "KI: ";
	private static final String stringVelocidad = "Velocidad: ";
	private static final String stringCantMovsRestantes = "Cantidad de movimientos restantes: ";
	private static final String stringEnemigo = "Enemigo: ";
	Jugador jugadorActual;
	ArrayList<Jugador> guerreros;
	Equipo equipoActual;
	Equipo equipoParaAtacar;
	Batalla batalla;
	Juego juegoGeneral;
	Boolean atacando = false;
	Boolean moviendose = false;
	Boolean capturando = false; //para el bonus
	ArrayList<Equipo> equipoGuerreros;
	ArrayList<Equipo> equipoInvasores;
	ArrayList<Equipo> equipoEnemigo;
	/* ArrayList<Bonus> listaDeBonus;// Para los bonus */
	Map<String, HBox> botoneras;// por si queremos dejar las botoneras.
	
	private Text stats[];
	private Text enemigo[];
	private Text nombreObjetivo;
	
	public VBoxStatsYOrdenesDisponibles(Juego juego, Batalla bat){
		super();
		this.jugadorActual = turno.obtenerJugadorActual();
		this.guerreros.add(jugadorActual.obtenerPersonaje1());
		this.guerreros.add(jugadorActual.obtenerPersonaje2());
		this.guerreros.add(jugadorActual.obtenerPersonaje3());
		this.juegoGeneral = juego;
		//this.listaDeBonus = juego.devolverListaDeBonus();
		this.batalla = bat;
		this.botoneras = new HashMap<String, HBox>();
		this.setPadding(new Insets(10));
		this.setSpacing(8); // Gap between nodes
		this.setStyle("-fx-background-color: #336699;"); // color de fondo

		this.nombreObjetivo = new Text("");
		this.nombreObjetivo.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		this.getChildren().add(this.nombreObjetivo);

		this.separadorMovimientos.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		this.separadorParaSeleccionarGroso.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		this.separadorCapturar.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		this.separadorParaAtacar.setFont(Font.font("Arial", FontWeight.BOLD, 14));
		this.separadorPasarTurno.setFont(Font.font("Arial", FontWeight.BOLD, 14));

		this.stats = new Text[] { new Text(stringVida), new Text(stringAtaque), new Text(stringAlcance),
				new Text(stringVelocidad), new Text(stringCantMovsRestantes) };

		for (int i = 0; i < this.stats.length; i++) {
			VBox.setMargin(this.stats[i], new Insets(0, 0, 0, 8));
			this.getChildren().add(this.stats[i]);
		}

		equipoGuerreros = this.jugadorActual.obtenerEquipo();
		equipoInvasores = juego.turnoSiguiente().obtenerEquipo();
		equipoEnemigo = equipoInvasores;
	
		EventHandler<ActionEvent> seleccionarPrimero = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				jugadorActual = guerreros.get(0);
				actualizarNombreObjetivo(jugadorActual.obtenerNombre());
				actualizarStatsObjetivo(jugadorActual.obtenerVida(), jugadorActual.getAtaque(),
						jugadorActual.obtenerPoderDePelea(), jugadorActual.obtenerVelocidad(),
						jugadorActual.obtenerMovimientosRestantes());
			}
		};
		
		EventHandler<ActionEvent> seleccionarSegundo = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				jugadorActual = guerreros.get(1);
				actualizarNombreObjetivo(jugadorActual.obtenerNombre());
				actualizarStatsObjetivo(jugadorActual.obtenerVida(), jugadorActual.getAtaque(),
						jugadorActual.obtenerPoderDePelea(), jugadorActual.obtenerVelocidad(),
						jugadorActual.obtenerMovimientosRestantes());
			}
		};
		EventHandler<ActionEvent> seleccionarTercero = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				jugadorActual = guerreros.get(2);
				actualizarNombreObjetivo(jugadorActual.obtenerNombre());
				actualizarStatsObjetivo(jugadorActual.obtenerVida(), jugadorActual.getAtaque(),
						jugadorActual.obtenerPoderDePelea(), jugadorActual.obtenerVelocidad(),
						jugadorActual.obtenerMovimientosRestantes());
			}
		};
		EventHandler<ActionEvent> seleccionarPrimeroParaAtacar = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (jugadorActual.obtenerNombre() == "Goku" || jugadorActual.obtenerNombre() == "Gohan"
						|| jugadorActual.obtenerNombre() == "Piccolo") {
					equipoParaAtacar = equipoInvasores.get(0);
				} else {
					equipoParaAtacar = equipoGuerreros.get(0);
				}
				actualizarStatsEnemigo(equipoParaAtacar.obtenerNombre(), equipoParaAtacar.obtenerVida());
			}
		};
	
	
	
	
	
	}
	
	
	private void actualizarNombreObjetivo(String nombre) {
		this.nombreObjetivo.setText(nombre);
	}

	private void actualizarStatsVacio() {
		this.stats[0].setText(stringVida);
		this.stats[1].setText(stringAtaque);
		this.stats[2].setText(stringKI);
		this.stats[3].setText(stringVelocidad);
		this.stats[4].setText(stringCantMovsRestantes);
	}
	
	private void actualizarStatsObjetivo(int vida, int atk, int rng, int vel, int movsRes) {
		this.stats[0].setText(stringVida + vida);
		this.stats[1].setText(stringAtaque + atk);
		this.stats[2].setText(stringKI + rng);
		this.stats[3].setText(stringVelocidad + vel);
		this.stats[4].setText(stringCantMovsRestantes + movsRes);
	}

	private void actualizarStatsEnemigo(String nombre, int vida) {
		this.enemigo[0].setText(stringEnemigo + nombre);
		this.enemigo[1].setText(stringVida + vida);
	}
	
	