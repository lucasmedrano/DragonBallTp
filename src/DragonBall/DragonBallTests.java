package DragonBall;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

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
		
		jugador1.asignarPersonaje1(goku);
		jugador1.asignarPersonaje2(gohan);
		jugador1.asignarPersonaje3(piccolo);
		jugador2.asignarPersonaje1(cell);
		jugador2.asignarPersonaje2(freezer);
		jugador2.asignarPersonaje3(majinboo);
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


}
