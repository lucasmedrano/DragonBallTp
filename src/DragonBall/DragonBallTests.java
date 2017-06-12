package DragonBall;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class DragonBallTests {

	@Test
	public void testUbicarPersonaje() {
		
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		try{
			goku.ubicarEn(7,5);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}
		Ubicacion ubicacion = goku.obtenerUbicacion();
		Assert.assertEquals("La ubicacion horizontal fallo",7, ubicacion.obtenerUbicacionHorizontal());
		Assert.assertEquals("La ubicacion vertical fallo",5, ubicacion.obtenerUbicacionVertical());
	}
	
	@Test
	public void testUbicarPersonajeUnoArribaDeOtro(){
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		MajinBoo boo = new MajinBoo(tablero);
		try{
			goku.ubicarEn(7,5);
		}
		catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}
		try{
			boo.ubicarEn(7,5);
		}catch (PosicionInadecuada e){
			Assert.assertTrue("No se pudo ubicar a MajinBoo porque estaba ocupado el casillero", true);
		}
	}
	
	@Test
	public void testMoverArribaPersonaje() {
		
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		try{
			goku.ubicarEn(7,5);
		}
		catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}
		try{
			goku.moverArriba();
		}catch (PosicionInadecuada e){
			Assert.fail("No se puede mover el personaje");
		}
		
		Ubicacion ubicacion = goku.obtenerUbicacion();
		Assert.assertEquals("La ubicacion horizontal fallo",7, ubicacion.obtenerUbicacionHorizontal());
		Assert.assertEquals("La ubicacion verticalsi fallo",6, ubicacion.obtenerUbicacionVertical());
	}
	
	@Test
	public void testMoverArribaPersonajeMal(){
		
		boolean prueba = false;
		
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		try{
			goku.ubicarEn(5,29);
		}
		catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}
		try{
			goku.moverArriba();
		}
		
		catch (PosicionInadecuada e) {
			prueba = true;
		}
		Ubicacion ubicacion = goku.obtenerUbicacion();
		Assert.assertEquals(5, ubicacion.obtenerUbicacionHorizontal());
		Assert.assertEquals(29, ubicacion.obtenerUbicacionVertical());
		Assert.assertTrue(prueba);
	}
	
	@Test
	public void testMoverUnPersonajeAUnCasilleroOcupado(){
		boolean prueba = false;
		
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		try{
			goku.ubicarEn(7,5);
		}
		catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}
		MajinBoo boo = new MajinBoo(tablero);
		try{
			boo.ubicarEn(8,5);
		}
		catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}
		try{
			boo.moverIzquierda();
		}
		catch (PosicionInadecuada e){
			prueba = true;
		}
		Ubicacion ubicacion = goku.obtenerUbicacion();
		Assert.assertEquals("La ubicacion horizontal fallo",7, ubicacion.obtenerUbicacionHorizontal());
		Assert.assertEquals("La ubicacion vertical fallo",5, ubicacion.obtenerUbicacionVertical());
		Ubicacion ubicacion2 = boo.obtenerUbicacion();
		Assert.assertEquals("La ubicacion horizontal fallo",8, ubicacion2.obtenerUbicacionHorizontal());
		Assert.assertEquals("La ubicacion vertical fallo",5, ubicacion2.obtenerUbicacionVertical());
		Assert.assertTrue(prueba);
	}
	
		
	
	@Test
	public void testUbicarYTransformarPersonajeSinCapacidad(){
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		try{
			goku.ubicarEn(7,5);
		}
		catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}
		try{
			goku.transformar_1();//se intenta transformar a Kaio-Ken que es su primer transformacion
		}
		catch (IncapacidadParaTransformacion e){
			Assert.assertTrue("No se pudo transformar", 20 == goku.obtenerPoderDePelea());
		}
	}
	
	@Test
	public void testUbicarYTransformarPersonajeConCapacidad(){
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		try{
			goku.ubicarEn(7,5);
		}
		catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}
		goku.aumentarKi(50);
		try{
			goku.transformar_1();
		}
		catch (IncapacidadParaTransformacion e){
			Assert.fail("No se pudo transformar");
		}
		assertEquals("No se transformo",40,goku.obtenerPoderDePelea());//Si se trasnformo va a tener un poder de pelea de 40 en vez de 20
	}
	
	
	@Test
	public void ubicar_transformar_y_mover_personaje() {
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		try{
			goku.ubicarEn(7,5);
		}
		catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}
		goku.aumentarKi(50);
		try {
				goku.transformar_2();
		} 
		catch (IncapacidadParaTransformacion e){
			Assert.fail("Fallo la transfomracion");
		}
		try{
			goku.moverAbajo();
		}catch (PosicionInadecuada e){
			Assert.fail("No se puede mover el personaje");
		}
		Ubicacion ubicacion = goku.obtenerUbicacion();
		Assert.assertEquals(7, ubicacion.obtenerUbicacionHorizontal());
		Assert.assertEquals(4, ubicacion.obtenerUbicacionVertical());
	}
	
	@Test
	public void ubicar_transformar_y_mover_personajeMal() {
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		try{
			goku.ubicarEn(29,5);
		}
		catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}
		goku.aumentarKi(50);
		try {
				goku.transformar_2();
		} 
		catch (IncapacidadParaTransformacion e){
			Assert.fail("Fallo la transfomracion");
		}
		try{
			goku.moverDerecha();
		}catch (PosicionInadecuada e){
			Assert.assertTrue("No se pudo mover", true);
		}
		Ubicacion ubicacion = goku.obtenerUbicacion();
		Assert.assertEquals(29, ubicacion.obtenerUbicacionHorizontal());
		Assert.assertEquals(5, ubicacion.obtenerUbicacionVertical());
	}
	
	
	@Test
	public void integracion1() {
		Juego juego = new Juego();
		Tablero tablero = juego.obtenerTablero();
		Jugador jugador1 = juego.obtenerJugador1();
		Jugador jugador2 = juego.obtenerJugador2();
		int tamanio = tablero.obtenerTamanio();
		
		Goku goku = new Goku(tablero);
		Gohan gohan = new Gohan(tablero);
		Piccolo piccolo = new Piccolo(tablero);
		Cell cell = new Cell(tablero);
		Freezer freezer = new Freezer(tablero);
		MajinBoo majinboo = new MajinBoo(tablero);
		
		Equipo equipo1 = new Equipo();
		Equipo equipo2 = new Equipo();
		
		equipo1.asignarPersonajes(goku, gohan, piccolo);
		equipo2.asignarPersonajes(cell, freezer, majinboo);
		
		jugador1.asignarEquipo(equipo1);
		jugador2.asignarEquipo(equipo2);
		
		tablero.ubicarPersonajesJugador1(jugador1);
		tablero.ubicarPersonajesJugador2(jugador2);
		
		Assert.assertEquals(jugador1, juego.obtenerJugador1());
		Assert.assertEquals(jugador2, juego.obtenerJugador2());
		Assert.assertEquals(30, tablero.obtenerTamanio());
		
		Ubicacion ubicacion_goku = goku.obtenerUbicacion();
		Ubicacion ubicacion_gohan = gohan.obtenerUbicacion();
		Ubicacion ubicacion_piccolo = piccolo.obtenerUbicacion();
		Ubicacion ubicacion_cell = cell.obtenerUbicacion();
		Ubicacion ubicacion_freezer = freezer.obtenerUbicacion();
		Ubicacion ubicacion_majinboo = majinboo.obtenerUbicacion();
		
		
		
		Assert.assertEquals(0, ubicacion_goku.obtenerUbicacionHorizontal());
		Assert.assertEquals((tamanio/2) - 1, ubicacion_goku.obtenerUbicacionVertical());
		Assert.assertEquals(0, ubicacion_gohan.obtenerUbicacionHorizontal());
		Assert.assertEquals((tamanio/2), ubicacion_gohan.obtenerUbicacionVertical());
		Assert.assertEquals(0, ubicacion_piccolo.obtenerUbicacionHorizontal());
		Assert.assertEquals((tamanio/2) + 1, ubicacion_piccolo.obtenerUbicacionVertical());
		
		Assert.assertEquals(tamanio-1, ubicacion_cell.obtenerUbicacionHorizontal());
		Assert.assertEquals(tamanio/2 - 1, ubicacion_cell.obtenerUbicacionVertical());
		Assert.assertEquals(tamanio-1, ubicacion_freezer.obtenerUbicacionHorizontal());
		Assert.assertEquals((tamanio/2), ubicacion_freezer.obtenerUbicacionVertical());
		Assert.assertEquals(tamanio-1, ubicacion_majinboo.obtenerUbicacionHorizontal());
		Assert.assertEquals((tamanio/2) + 1, ubicacion_majinboo.obtenerUbicacionVertical());
	}
	
	
	@Test
	public void atacar_respetando_distancias(){
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		Cell cell = new Cell(tablero);
		
		try{
			goku.ubicarEn(1,1);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}
		try{
			cell.ubicarEn(2,2);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}
		
		try{
			cell.ataqueBasico(goku);
		}
		catch (IncapacidadDeAtacar e){
			Assert.fail("No ataco");
		}
		Assert.assertEquals(480, goku.obtenerVida());
		try{
			goku.ataqueBasico(cell);
		}
		catch (IncapacidadDeAtacar e){
			Assert.fail("No ataco");
		}
		Assert.assertEquals(480, cell.obtenerVida());
	}
	
	
	@Test
	public void AtacarAUnEnemigoDeMayorPoderDePelea(){
		Tablero tablero = new Tablero();
		Gohan gohan = new Gohan(tablero);
		Cell cell = new Cell(tablero);
		
		try{
			gohan.ubicarEn(1,1);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}
		try{
			cell.ubicarEn(2,2);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}
		
		try{
			gohan.ataqueBasico(cell);
		}
		catch (IncapacidadDeAtacar e){
			Assert.fail("No ataco");
		}
		Assert.assertEquals(488, cell.obtenerVida());
	}
	
	@Test
	public void atacar_sin_respetar_distancias(){
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		Cell cell = new Cell(tablero);
		
		try{
			goku.ubicarEn(1,1);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}
		try{
			cell.ubicarEn(10,10);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}
		
		try{
			cell.ataqueBasico(goku);
		}
		catch (IncapacidadDeAtacar e){
			Assert.assertTrue("No se pudo atacar por la distancia", true);
		}
		try{
			goku.ataqueBasico(cell);
		}
		catch (IncapacidadDeAtacar e){
			Assert.assertTrue("No se pudo atacar por la distancia", true);
		}
		Assert.assertEquals(500, goku.obtenerVida());
		Assert.assertEquals(500, cell.obtenerVida());
	}

//Pruebas segunda parte
	
	@Test
	public void llevar_gohan_primera_transformacion(){
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		Piccolo piccolo = new Piccolo(tablero);
		Gohan gohan = new Gohan(tablero);
		
		boolean prueba = false;
		
		Equipo equipo_gohan = new Equipo();
		equipo_gohan.asignarPersonajes(goku, gohan, piccolo);
		gohan.asignarEquipo(equipo_gohan);
		
		try{
			goku.ubicarEn(1,1);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubicó el personaje");
		}
		try{
			piccolo.ubicarEn(1,2);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubicó el personaje");
		}
		try{
			gohan.ubicarEn(1,3);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubicó el personaje");
		}
		gohan.aumentarKi(15);
		
		try{
			gohan.transformar_1();
		}catch (IncapacidadParaTransformacion e){
			Assert.fail("Fallo la transformacion");
		}
		
		try{
			gohan.transformar_2();
		}catch (IncapacidadParaTransformacion e){
			prueba = true;
		}
		
		Assert.assertTrue(prueba);
	}
	
	@Test
	public void llevar_gohan_segunda_transformacion(){
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		Piccolo piccolo = new Piccolo(tablero);
		Gohan gohan = new Gohan(tablero);
		
		Equipo equipo_gohan = new Equipo();
		equipo_gohan.asignarPersonajes(goku, gohan, piccolo);
		gohan.asignarEquipo(equipo_gohan);
		
		try{
			goku.ubicarEn(1,1);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubicó el personaje");
		}
		try{
			piccolo.ubicarEn(1,2);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubicó el personaje");
		}
		try{
			gohan.ubicarEn(1,3);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubicó el personaje");
		}
		
		gohan.aumentarKi(50);
		goku.disminuirVida(400);
		piccolo.disminuirVida(400);
		try{
			gohan.transformar_2();
		}catch (IncapacidadParaTransformacion e){
			Assert.fail("Fallo la transformacion");
		}
		
		Assert.assertTrue("No se pudo transformar", 100 == gohan.obtenerPoderDePelea());
		
	}
	
	@Test
	public void llevar_piccolo_primera_transformacion(){
		Tablero tablero = new Tablero();
		Piccolo piccolo = new Piccolo(tablero);
		Goku goku = new Goku(tablero);
		Gohan gohan = new Gohan(tablero);
		boolean prueba = false;
		
		Equipo equipo_piccolo = new Equipo();
		equipo_piccolo.asignarPersonajes(gohan, piccolo, goku);
		piccolo.asignarEquipo(equipo_piccolo);
		
		try{
			piccolo.ubicarEn(1,1);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubicó el personaje");
		}
		try{
			gohan.ubicarEn(2,1);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubicó el personaje");
		}
		piccolo.aumentarKi(20);
		try{
			piccolo.transformar_1();
		}catch (IncapacidadParaTransformacion e){
			Assert.fail("Fallo la transfomracion");
		}
		try{
			piccolo.transformar_2();
		}catch (IncapacidadParaTransformacion e){
			prueba = true;
		}
		Assert.assertTrue(prueba);
	}
	
	@Test
	public void llevar_piccolo_segunda_transformacion(){
		Tablero tablero = new Tablero();
		Piccolo piccolo = new Piccolo(tablero);
		Gohan gohan = new Gohan(tablero);
		Goku goku = new Goku(tablero);
		
		Equipo equipo_piccolo = new Equipo();
		equipo_piccolo.asignarPersonajes(gohan, piccolo, goku);
		piccolo.asignarEquipo(equipo_piccolo);
		
		try{
			piccolo.ubicarEn(1,1);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubicó el personaje");
		}
		try{
			gohan.ubicarEn(2,1);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubicó el personaje");
		}
		gohan.disminuirVida(250);
		try{
			piccolo.transformar_2();
		}catch (IncapacidadParaTransformacion e){
			Assert.fail("Fallo la Transformacion");
		}
		
		Assert.assertTrue("No se pudo transformar", 60 == piccolo.obtenerPoderDePelea());
		
	}
	
	@Test
	public void cell_no_puede_transformarse(){
		Tablero tablero = new Tablero();
		Cell cell = new Cell(tablero);
		try{
			cell.ubicarEn(10,11);
		}catch(PosicionInadecuada e){
			Assert.fail("No se ubicó el personaje");
		}
		try{
			cell.transformar_1();
		}catch (IncapacidadParaTransformacion e){
			Assert.assertTrue("No se pudo Transformar", true);
		}
		try{
			cell.transformar_2();
		}catch (IncapacidadParaTransformacion e){
			Assert.assertTrue("No se pudo Transformar", true);
		}
	}
	
	@Test
	public void cell_puede_absorber_vida(){
		Tablero tablero = new Tablero();
		Cell cell = new Cell(tablero);
		Goku goku = new Goku(tablero);
		try{
			cell.ubicarEn(1,5);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico el personaje");
		}
		try{
			goku.ubicarEn(2,5);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico el personaje");
		}
		int primeraVidaGoku = goku.obtenerVida();
		cell.aumentarKi(5);
		cell.disminuirVida(200);
		int primeraVidaCell = cell.obtenerVida();
		
		try{
				cell.ataqueEspecial(goku);
		}catch (IncapacidadDeAtacar e){
				Assert.fail("No pudo atacar");
		}
		int poder_especial = cell.obtenerPoderDePeleaEspecial();
		int nuevaVidaCell=cell.obtenerVida();
		int nuevaVidaGoku=goku.obtenerVida();
		Assert.assertTrue("No realizo correctamente el ataque especial" ,nuevaVidaCell == primeraVidaCell + poder_especial);
		Assert.assertTrue("No realizo correctamente el ataque especial" ,nuevaVidaGoku == primeraVidaGoku - poder_especial);
		
	}
	
	@Test
	public void cell_puede_absorber_vidas_y_transformase(){
		Tablero tablero = new Tablero();
		Cell cell = new Cell(tablero);
		Goku goku = new Goku(tablero);
		try{
			cell.ubicarEn(5,5);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico el personaje");
		}
		try{
			goku.ubicarEn(5,4);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico el personaje");
		}
		cell.aumentarKi(40);
		try{
			for(int i=0;i<8;i++){
				cell.ataqueEspecial(goku);
			}
		}catch (IncapacidadDeAtacar e){
			Assert.fail("No pudo atacar");
		}
		try{
			cell.transformar_1();
		}catch (IncapacidadParaTransformacion e){
			Assert.fail("No se pudo Transformar");
		}
		
		Assert.assertTrue("No se pudo transformar", 40 == cell.obtenerPoderDePelea());
		
		try{
			cell.transformar_2();
		}catch (IncapacidadParaTransformacion e){
			Assert.fail("No se pudo Transformar");
		}
		
		Assert.assertTrue("No se pudo transformar", 80 == cell.obtenerPoderDePelea());
	}
	
	@Test
	public void	convertirEnChocolateInvalidaAGokuAAtacar() throws PosicionInadecuada, IncapacidadDeAtacar{
		Tablero tablero = new Tablero();		
		Goku goku = new Goku(tablero);
		goku.ubicarEn(1, 1);
		MajinBoo majinBoo = new MajinBoo(tablero);
		majinBoo.ubicarEn(2, 2);
		majinBoo.ataqueEspecial(goku);

		try {
				goku.ataqueBasico(majinBoo);
			  }catch (InhabilitadoError e) {
				  Assert.assertTrue("No pudo atacar por estar inmovilizado", true);
			  }
	}

	@Test
	public void	convertirEnChocolateInvalidaAGokuAMoverse() throws PosicionInadecuada, IncapacidadDeAtacar{
		
		Tablero tablero = new Tablero();		
		Goku goku = new Goku(tablero);
		goku.ubicarEn(1, 1);
		MajinBoo majinBoo = new MajinBoo(tablero);
		majinBoo.ubicarEn(2, 2);
		majinBoo.ataqueEspecial(goku);
		
		try {
				goku.moverArriba();
		  	} catch (InhabilitadoError e) {
		  		Assert.assertTrue("No pudo moverse por estar inmovilizado", true);
		  		}
		
		
	}
	
	@Test
	public void	convertirEnChocolateInvalidaAGokuPor3Turnos() throws PosicionInadecuada, IncapacidadDeAtacar{
		
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		goku.ubicarEn(1, 1);
		MajinBoo majinBoo = new MajinBoo(tablero);
		majinBoo.ubicarEn(2, 2);
		majinBoo.ataqueEspecial(goku);
		int i=0;
		do {
			i++;
			try {                                         //Modelar los turnos y ver que en 3 turnos pueda moverse
			//Hasta dos acciones por equipo por turno//		//Chequear que el ki no aumente
				goku.moverArriba();
				goku.ataqueBasico(majinBoo);				//Hay que ver si son 3 turnos de este equipo inmovilizado o si son 3 turnos 
	  		} catch (InhabilitadoError e) {					//en total contando el del equipo contrario y por lo tanto serian 2 turnos sin hacer nada
	  			fail("Personaje Inutilizable");
	  		}
			i++;
		}while(i<=3);
	}
		
	@Test
	public void ubicarAGokuYVerificarQueSuDanioAumentaConAtaqueBasico(){
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		Cell cell= new Cell(tablero);
		int vidaInicialGoku=goku.obtenerVida();
		int vidaCellInicial=cell.obtenerVida();
		goku.ataqueBasico(cell);
		int vidaCellAtaqueGokuFuerte=cell.obtenerVida();
		int vidaCriticaGoku=(vidaInicialGoku*29/100);
		goku.modificarVida(vidaCriticaGoku);
		cell.modificarVida(vidaCellInicial);
		goku.ataqueBasico(cell);
		int vidaCellAtaqueGokuDebil=cell.obtenerVida();
		
		Assert.assertEquals((vidaCellAtaqueGokuFuerte+vidaCellAtaqueGokuFuerte*20/100),vidaCellAtaqueGokuDebil);
		

		
	}
		
	@Test	
	public void pasarAJugadorSiguienteCambiaDeJugador(){
		Juego juego=new Juego();
		Jugador jugador1=juego.jugadorSiguiente();
		Jugador jugador2=juego.jugadorSiguiente();
		Assert.assertTrue(jugador1!=jugador2);
	}
	
	@Test	
	public void pasarAJugadorSiguienteDosVecesVuelveAlMismoJugador(){
		Juego juego=new Juego();
		Jugador jugador1=juego.jugadorSiguiente();
		Jugador jugador2=juego.jugadorSiguiente();
		Jugador jugador3=juego.jugadorSiguiente();
		Assert.assertTrue(jugador3==jugador1);
	}
		
}