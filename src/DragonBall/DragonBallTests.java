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
		Assert.assertEquals("La ubicacion horizontal es correcta",7, ubicacion.obtenerUbicacionHorizontal());
		Assert.assertEquals("La ubicacion vertical es correcta",5, ubicacion.obtenerUbicacionVertical());
	}
	
	@Test
	public void testUbicarPersonajeUnoArribaDeOtro(){
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		MajinBoo boo = new MajinBoo(tablero);
		try{
			goku.ubicarEn(7,5);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}
		try{
			boo.ubicarEn(7,5);
		}catch (PosicionInadecuada e){
			Assert.assertTrue("No se pudo ubicar a MajinBoo porque estaba ocupado el casillero", true);
		}
	}
	
	@Test
	public void testMoverArribaAPersonaje() throws InhabilitadoError {
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Goku goku= new Goku(tablero);
		Gohan gohan= new Gohan(tablero);
		Piccolo piccolo= new Piccolo(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, piccolo);
		equipo.esTuTurno();
		try{
			goku.ubicarEn(7,5);
			goku.moverArriba();
		}
		catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}catch (IncapacidadParaMoverse e) {				  
			Assert.fail("No puede moverse");
		}catch (InhabilitadoError e){
			fail("Inmovilizado, No puede atacar");
		}
		
		Ubicacion ubicacion = goku.obtenerUbicacion();
		Assert.assertEquals("La ubicacion horizontal es correcta",7, ubicacion.obtenerUbicacionHorizontal());
		Assert.assertEquals("La ubicacion vertical es correcta",6, ubicacion.obtenerUbicacionVertical());
	}
	
	@Test
	public void testMoverArribaPersonajeMal() throws InhabilitadoError{
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Goku goku=new Goku(tablero);
		Gohan gohan= new Gohan(tablero);
		Piccolo piccolo= new Piccolo(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, piccolo);
		equipo.esTuTurno();
		try{
			goku.ubicarEn(5,29);
		}
		catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}
		try {
			goku.moverArriba();
		  }catch (IncapacidadParaMoverse e) {				  
			  Assert.fail("No puede moverse");
		  }catch (InhabilitadoError e){
				  fail("Inmovilizado, No puede atacar");
		  }catch (PosicionInadecuada e){
			      Assert.assertTrue("No se ubico al personaje",true);
		  }
			
		Ubicacion ubicacion = goku.obtenerUbicacion();
		Assert.assertEquals("La ubicacion horizontal es incorrecta",5, ubicacion.obtenerUbicacionHorizontal());
		Assert.assertEquals("La ubicacion vertical es incorrecta",29, ubicacion.obtenerUbicacionVertical());
	}
	
	@Test
	public void testMoverABooAUnCasilleroOcupadoPorGoku() throws InhabilitadoError{
		boolean prueba = false;
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		
		Goku goku= new Goku(tablero);
		Gohan gohan= new Gohan(tablero);
		Piccolo piccolo= new Piccolo(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, piccolo);
		
		MajinBoo boo= new MajinBoo(tablero);
		Cell cell=new Cell(tablero);
		Freezer freezer=new Freezer(tablero);
		Equipo equipo2=new Equipo();
		equipo2.asignarPersonajes(boo,cell, freezer);
		
		try{
			goku.ubicarEn(7,5);
			boo.ubicarEn(8,5);
		}
		catch (PosicionInadecuada e){
			Assert.fail("No se ubicion el personaje");
		}
		
		equipo2.esTuTurno();
		
		try {
			boo.moverIzquierda();
		  }catch (IncapacidadParaMoverse e) {
			  Assert.fail("No puede moverse");
		  }catch (InhabilitadoError e){
			  Assert.assertTrue("No pudo moverse por estar inmovilizado", true);
		  }catch (PosicionInadecuada e){
		      Assert.assertTrue("No se ubico al personaje",true);
		  }
		Ubicacion ubicacion = goku.obtenerUbicacion();
		Assert.assertEquals("La ubicacion horizontal fallo",7, ubicacion.obtenerUbicacionHorizontal());
		Assert.assertEquals("La ubicacion vertical fallo",5, ubicacion.obtenerUbicacionVertical());
		Ubicacion ubicacion2 = boo.obtenerUbicacion();
		Assert.assertEquals("La ubicacion horizontal fallo",8, ubicacion2.obtenerUbicacionHorizontal());
		Assert.assertEquals("La ubicacion vertical fallo",5, ubicacion2.obtenerUbicacionVertical());
	}
	
	@Test
	public void testUbicarYTransformarPersonajeSinCapacidad(){
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		try{
			goku.ubicarEn(7,5);
			goku.transformar_1();//se intenta transformar a Kaio-Ken que es su primer transformacion
		}
		catch (PosicionInadecuada e){
			Assert.fail("No se ubicion el personaje");
		}catch (IncapacidadParaTransformacion e){
			Assert.assertTrue("No se pudo transformar", 20 == goku.obtenerPoderDePelea());
		}
	}
	
	@Test
	public void testUbicarYTransformarPersonajeConCapacidad(){
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		try{
			goku.ubicarEn(7,5);
			goku.aumentarKi(50);
			goku.transformar_1();
		}
		catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}catch (IncapacidadParaTransformacion e){
			Assert.fail("No se pudo transformar");
		}
		assertEquals("No se transformo",40,goku.obtenerPoderDePelea());//Si se trasnformo va a tener un poder de pelea de 40 en vez de 20
	}
	
	@Test
	public void ubicar_transformar_y_mover_personaje() throws InhabilitadoError {
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		
		Goku goku= new Goku(tablero);
		Gohan gohan= new Gohan(tablero);
		Piccolo piccolo= new Piccolo(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, piccolo);
		
		Personaje freezer= new Freezer(tablero);
		Equipo equipo2=new Equipo();
		equipo2.asignarPersonaje1(freezer);
		
		equipo.esTuTurno();
		try{
			goku.ubicarEn(7,5);
			goku.aumentarKi(50);
			goku.transformar_2();
			goku.moverAbajo();
		}
		catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}catch (IncapacidadParaTransformacion e){
			Assert.fail("Fallo la transfomracion");
		}catch (IncapacidadParaMoverse e) {
			Assert.fail("No puede moverse");
		}catch (InhabilitadoError e){
			Assert.assertTrue("No pudo moverse por estar inmovilizado", true);
		}
		
		Ubicacion ubicacion = goku.obtenerUbicacion();
		Assert.assertEquals(7, ubicacion.obtenerUbicacionHorizontal());
		Assert.assertEquals(4, ubicacion.obtenerUbicacionVertical());
	}
	
	@Test
	public void ubicar_transformar_y_mover_personajeMal() throws InhabilitadoError {
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Goku goku= new Goku(tablero);
		Gohan gohan= new Gohan(tablero);
		Piccolo piccolo= new Piccolo(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, piccolo);
		equipo.esTuTurno();
		try{
			goku.ubicarEn(29,5);
			goku.aumentarKi(50);
			goku.transformar_2();
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}catch (IncapacidadParaTransformacion e){
			Assert.fail("Fallo la transfomracion");
		}
		
		
		try{
			goku.moverDerecha();
		}catch (PosicionInadecuada e){
			Assert.assertTrue("No se pudo mover", true);
		}catch (IncapacidadParaMoverse e){
			Assert.fail("No se puede mover");
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
	public void atacar_respetando_distancias() throws InhabilitadoError{
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		Cell cell = new Cell(tablero);
		Equipo equipo1=new Equipo();
		Equipo equipo2=new Equipo();
		equipo1.asignarPersonaje1(goku);
		equipo2.asignarPersonaje2(cell);
		
		try{
			goku.ubicarEn(1,1);
			cell.ubicarEn(2,2);
			equipo2.esTuTurno();
			cell.ataqueBasico(goku);
			equipo1.esTuTurno();
			goku.ataqueBasico(cell);
			
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}catch (IncapacidadDeAtacar e){
			Assert.fail("No ataco");
		}
		Assert.assertEquals(480, goku.obtenerVida());
		Assert.assertEquals(480, cell.obtenerVida());
	}
		
	@Test
	public void AtacarAUnEnemigoDeMayorPoderDePelea() throws InhabilitadoError{
		Tablero tablero = new Tablero();
		Gohan gohan = new Gohan(tablero);
		Cell cell = new Cell(tablero);
		Equipo equipo= new Equipo();
		equipo.asignarPersonaje1(gohan);
		equipo.esTuTurno();
		
		try{
			gohan.ubicarEn(1,1);
			cell.ubicarEn(2,2);
			gohan.ataqueBasico(cell);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubic� el personaje");
		}catch (IncapacidadDeAtacar e){
			Assert.fail("No ataco");
		}
		Assert.assertEquals(488, cell.obtenerVida());
	}
	
	@Test
	public void atacar_sin_respetar_distancias() throws InhabilitadoError{
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		Cell cell = new Cell(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonaje1(goku);
		Equipo equipo2=new Equipo();
		equipo2.asignarPersonaje1(cell);
		
		try{
			goku.ubicarEn(1,1);
			cell.ubicarEn(10,10);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubicion el personaje");
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
			piccolo.ubicarEn(1,2);
			gohan.ubicarEn(1,3);
			gohan.aumentarKi(15);
			gohan.transformar_1();
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubicion el personaje");
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
			piccolo.ubicarEn(1,2);
			gohan.ubicarEn(1,3);
			gohan.aumentarKi(50);
			goku.disminuirVida(400);
			piccolo.disminuirVida(400);
			gohan.transformar_2();
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubicion el personaje");
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
			gohan.ubicarEn(2,1);
			piccolo.aumentarKi(20);
			piccolo.transformar_1();
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubicion el personaje");
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
			gohan.ubicarEn(2,1);
			gohan.disminuirVida(250);
			piccolo.transformar_2();
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubicion el personaje");
		}catch (IncapacidadParaTransformacion e){
			Assert.fail("Fallo la Transformacion");
		}
	
		Assert.assertTrue("No se pudo transformar", 60 == piccolo.obtenerPoderDePelea());
		
	}
	
	@Test
	public void cell_no_puede_transformarse(){
		boolean capacidad_transformacion1 = false;
		boolean capacidad_transformacion2 = false;
		
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
			capacidad_transformacion1 = false;
		}
		try{
			cell.transformar_2();
		}catch (IncapacidadParaTransformacion e){
			capacidad_transformacion2 = false;
		}
		Assert.assertFalse(capacidad_transformacion1);
		Assert.assertFalse(capacidad_transformacion2);
	}
	
	@Test
	public void cell_puede_absorber_vida() throws InhabilitadoError{
		Tablero tablero = new Tablero();
		Goku goku = new Goku(tablero);
		Equipo equipo1=new Equipo();
		Personaje gohan= new Gohan(tablero);
		Personaje piccolo= new Piccolo(tablero);
		equipo1.asignarPersonajes(goku,gohan,piccolo);
		
		MajinBoo boo= new MajinBoo(tablero);
		Cell cell=new Cell(tablero);
		Freezer freezer=new Freezer(tablero);
		Equipo equipo2=new Equipo();
		equipo2.asignarPersonajes(boo,cell, freezer);
		equipo2.esTuTurno();
		
		try{
			cell.ubicarEn(1,5);
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
	public void cell_puede_absorber_vidas_y_transformase() throws InhabilitadoError{
	
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Goku goku= new Goku(tablero);
		Gohan gohan= new Gohan(tablero);
		Piccolo piccolo= new Piccolo(tablero);
		Cell cell = new Cell(tablero);
		Equipo equipo=new Equipo();
		
		equipo.asignarPersonajes(gohan, cell, piccolo);
		
		equipo.esTuTurno();
		try{
			cell.ubicarEn(5,5);
			goku.ubicarEn(5,4);
			cell.aumentarKi(40);
			
			for(int i=0;i<8;i++){
				equipo.esTuTurno();
				cell.ataqueEspecial(goku);
				equipo.finalizarTurno();
			}
			cell.transformar_1();
			Assert.assertTrue("No se pudo transformar", 40 == cell.obtenerPoderDePelea());	
			cell.transformar_2();
			Assert.assertTrue("No se pudo transformar", 80 == cell.obtenerPoderDePelea());
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico el personaje");
		}catch (IncapacidadDeAtacar e){
			Assert.fail("No pudo atacar");
		}catch (IncapacidadParaTransformacion e){
			Assert.fail("No se pudo Transformar");
		}
	}
	
	@Test
	public void	convertirEnChocolateInvalidaAGokuAAtacar() throws PosicionInadecuada, IncapacidadDeAtacar, InhabilitadoError{
		boolean inmovilizado = false;
		
		Tablero tablero = new Tablero();		
		Goku goku = new Goku(tablero);
		Equipo equipo1= new Equipo();
		equipo1.asignarPersonaje1(goku);
		MajinBoo majinBoo = new MajinBoo(tablero);
		Equipo equipo2= new Equipo();
		equipo2.asignarPersonaje1(majinBoo);

		try {
			goku.ubicarEn(1, 1);
			majinBoo.ubicarEn(2, 2);
			majinBoo.aumentarKi(50);
			equipo2.esTuTurno();
			majinBoo.ataqueEspecial(goku);
		  }catch (IncapacidadDeAtacar e) {
			  fail("No puede atacar");
		  }catch (InhabilitadoError e){
			  fail("Inmovilizado, No puede atacar");
		  }

		try {
			goku.ataqueBasico(majinBoo);
		}catch (IncapacidadDeAtacar e) {
			fail("No puede atacar");
		}catch (InhabilitadoError e){
			inmovilizado = true;
		}
		
		Assert.assertTrue(inmovilizado);
	}

	@Test
	public void	convertirEnChocolateInvalidaAGokuAMoverse() throws PosicionInadecuada, IncapacidadDeAtacar, InhabilitadoError{
		boolean inmovilizado = false;
		Tablero tablero = new Tablero();		
		Goku goku = new Goku(tablero);
		Equipo equipo1= new Equipo();
		equipo1.asignarPersonaje1(goku);
		MajinBoo majinBoo = new MajinBoo(tablero);
		Equipo equipo2= new Equipo();
		equipo2.asignarPersonaje1(majinBoo);
		majinBoo.aumentarKi(50);
		equipo2.esTuTurno();
		
		try {
			goku.ubicarEn(1, 1);
			majinBoo.ubicarEn(2, 2);
			majinBoo.ataqueEspecial(goku);
		}catch (IncapacidadDeAtacar e) {
			fail("No puede atacar");
		}catch (InhabilitadoError e){
			fail("Inmovilizado, No puede atacar");
		}

		try {
			goku.moverArriba();
		}catch (IncapacidadParaMoverse e) {
			Assert.fail("No puede moverse");
		}catch (InhabilitadoError e){
			inmovilizado = true;
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico al personaje");
		}
		
		Assert.assertTrue(inmovilizado);
	}
	
	/*@Test
	public void	convertirEnChocolateInvalidaAGokuPor3Turnos() throws PosicionInadecuada, IncapacidadDeAtacar, InhabilitadoError{
		
		boolean gokuSeMovio=true;
		
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Personaje goku= new Goku(tablero);
		Personaje gohan= new Gohan(tablero);
		Personaje piccolo= new Piccolo(tablero);
		Personaje majinBoo=new MajinBoo(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, majinBoo);
		goku.ubicarEn(1, 1);
		gohan.ubicarEn(1,0);
		piccolo.ubicarEn(3, 2);
		majinBoo.ubicarEn(0, 0);
		majinBoo.aumentarKi(50);
		majinBoo.ataqueEspecial(goku);
		try {
			goku.moverArriba();
			goku.moverArriba();
			equipo.finalizarTurno();
		}catch (IncapacidadParaMoverse e) {
	
		}catch (InhabilitadoError e){
			fail("Inmovilizado");
		}catch (PosicionInadecuada e){
		      Assert.fail("No se ubico al personaje");
		}
		
		try {
			goku.moverArriba();
			goku.moverArriba();
			equipo.finalizarTurno();
		}catch (IncapacidadParaMoverse e) {
	
		}catch (InhabilitadoError e){
			fail("Inmovilizado");
		}catch (PosicionInadecuada e){
		      Assert.fail("No se ubico al personaje");
		}
		
		try {
			goku.moverArriba();
			goku.moverArriba();
			equipo.finalizarTurno();
		}catch (IncapacidadParaMoverse e) {
	
		}catch (InhabilitadoError e){
			fail("Inmovilizado");
			gokuSeMovio=false;
		}catch (PosicionInadecuada e){
		      Assert.fail("No se ubico al personaje");
		}
		
		Assert.assertFalse(gokuSeMovio);
	}*/
		
	@Test
	public void ubicarAGokuYVerificarQueSuDanioAumenta() throws PosicionInadecuada, IncapacidadDeAtacar, InhabilitadoError{

		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Personaje goku= new Goku(tablero);
		Personaje gohan= new Gohan(tablero);
		Personaje piccolo= new Piccolo(tablero);
		Personaje cell=new Cell(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, piccolo);
		equipo.esTuTurno();
		try{
			goku.ubicarEn(1, 1);
			gohan.ubicarEn(1,0);
			piccolo.ubicarEn(3, 2);
			cell.ubicarEn(2, 1);
			goku.aumentarKi(50);
			goku.disminuirVida(400);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico el personaje");
		}
		
		int vida_inicial_cell = cell.obtenerVida();
		goku.ataqueBasico(cell);
		equipo.finalizarTurno();
		equipo.esTuTurno();
		goku.ataqueEspecial(cell);
		int vida_cell = cell.obtenerVida();
		Assert.assertTrue( "Los ataques hicieron un 20% mas de danio", vida_inicial_cell == vida_cell + 60);
	}
	
	@Test
	public void equipoNoPuedeRealizarAtaqueBasicoDosVecesConDosPersonajesDiferentes(){
		
		boolean gohanAtaco=true;
		
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Personaje goku= new Goku(tablero);
		Personaje gohan= new Gohan(tablero);
		Personaje piccolo= new Piccolo(tablero);
		Personaje cell= new Cell(tablero);
		Personaje freezer= new Freezer(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, piccolo);
		equipo.esTuTurno();
		
		try{
			goku.ubicarEn(2,3);
			gohan.ubicarEn(2,1);
			cell.ubicarEn(3,2);
			freezer.ubicarEn(2,2);
			goku.ataqueBasico(cell);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico el personaje");
		}catch (IncapacidadDeAtacar e) {
			Assert.fail("No puede atacar");
		}catch (InhabilitadoError e){
			fail("Inmovilizado, No puede atacar");
		}
		Assert.assertTrue(equipo.ataco());
		
		try {
			gohan.ataqueBasico(freezer);
		}catch (IncapacidadDeAtacar e) {
			gohanAtaco=false;
		}catch (InhabilitadoError e){
			fail("Inmovilizado, No puede atacar");
		}
		Assert.assertTrue("Gohan no pudo atacar porque el equipo no puede atacar dos veces",!gohanAtaco);
	}

	@Test
	public void equipoNoPuedeRealizarAtaqueBasicoDosVecesConElMismoPersonaje(){
	
		boolean gokuAtaco=true;
	
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Personaje goku= new Goku(tablero);
		Personaje gohan= new Gohan(tablero);
		Personaje piccolo= new Piccolo(tablero);
		Personaje cell= new Cell(tablero);
		Personaje freezer= new Freezer(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, piccolo);
		equipo.esTuTurno();
	
		try{
			goku.ubicarEn(2,3);
			cell.ubicarEn(3,2);
			freezer.ubicarEn(2,2);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico el personaje");
		}
		
		try {
			goku.ataqueBasico(cell);
		}catch (IncapacidadDeAtacar e) {
			Assert.fail("No puede atacar");
		}catch (InhabilitadoError e){
			fail("Inmovilizado, No puede atacar");
		}
		Assert.assertTrue(equipo.ataco());
		
		try {
			goku.ataqueBasico(freezer);
		}catch (IncapacidadDeAtacar e) {
			gokuAtaco=false;
		}catch (InhabilitadoError e){
			fail("Inmovilizado, No puede atacar");
		}
		Assert.assertTrue("Goku no pudo atacar porque el equipo no puede atacar dos veces",!gokuAtaco);
	}
	
	@Test
	public void equipoPuedeRealizarUnAtaqueYMoverseConElMismoPersonaje(){
		
		boolean gokuAtaco=true;
		boolean gokuSeMovio=true;
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Personaje goku= new Goku(tablero);
		Personaje gohan= new Gohan(tablero);
		Personaje piccolo= new Piccolo(tablero);
		Personaje cell= new Cell(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, piccolo);
		equipo.esTuTurno();
		
		try{
			goku.ubicarEn(2,3);
			cell.ubicarEn(3,2);
			goku.moverArriba();
			goku.ataqueBasico(cell);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico el personaje");
		}catch (IncapacidadParaMoverse e) {
			gokuSeMovio=false;
		}catch (InhabilitadoError e){
			fail("Inmovilizado");
		}catch (IncapacidadDeAtacar e) {
			gokuAtaco=false;
		}
		Assert.assertTrue("Goku puede atacar y moverse",gokuAtaco);
		Assert.assertTrue("Goku puede atacar y moverse",gokuSeMovio);
	}
	
	@Test
	public void gokuEnEstadoNormalNoSePuedeMoverParaArribaMasDeLoQueSuVelocidadIndica(){
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Personaje goku= new Goku(tablero);
		Personaje gohan= new Gohan(tablero);
		Personaje piccolo= new Piccolo(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, piccolo);
		equipo.esTuTurno();
		
		try{
			goku.ubicarEn(2,3);
			goku.moverArriba();
			goku.moverArriba();
		}catch (PosicionInadecuada e){
			Assert.fail();
		}catch (IncapacidadParaMoverse e) {
			  Assert.fail("No puede moverse");
		}catch (InhabilitadoError e){
			Assert.fail("Inmovilizado");
		}

		boolean pruebaOk=false;
		try {
			goku.moverArriba();
		}catch (IncapacidadParaMoverse e) {
			pruebaOk=true;
		}catch (InhabilitadoError e){
			Assert.fail("Inmovilizado");
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico al personaje");
		}
		Assert.assertTrue(pruebaOk);
	}
	
	@Test
	public void gokuEnEstadoNormalNoSePuedeMoverParaAbajoMasDeLoQueSuVelocidadIndica(){
		boolean pruebaOk=false;
		
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Personaje goku= new Goku(tablero);
		Personaje gohan= new Gohan(tablero);
		Personaje piccolo= new Piccolo(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, piccolo);
		equipo.esTuTurno();
		
		try{
			goku.ubicarEn(2,3);
			goku.moverAbajo();
			goku.moverAbajo();
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico el personaje");
		}catch (IncapacidadParaMoverse e) {
			Assert.fail("No puede moverse");
		}catch (InhabilitadoError e){
			  Assert.fail("Inmovilizado");
		}
		
		try {
			goku.moverAbajo();
		}catch (IncapacidadParaMoverse e) {
			pruebaOk=true;
		}catch (InhabilitadoError e){
			Assert.fail("Inmovilizado");
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico al personaje");
		}
		Assert.assertTrue(pruebaOk);
	}
	
	@Test
	public void gokuSeMueveUnaVezYAtacaYNoPuedeVolverAMoverse(){
		boolean pruebaOk=false;
		
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Personaje goku= new Goku(tablero);
		Personaje gohan= new Gohan(tablero);
		Personaje piccolo= new Piccolo(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, piccolo);
		Personaje freezer= new Freezer(tablero);
		Equipo equipo2=new Equipo();
		equipo2.asignarPersonaje1(freezer);
		equipo.esTuTurno();
		try{
			goku.ubicarEn(2,3);
			freezer.ubicarEn(1,3);
			goku.moverAbajo();
			goku.ataqueBasico(freezer);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico el personaje");
		}catch (IncapacidadParaMoverse e) {
			Assert.fail("No puede moverse");
		}catch (InhabilitadoError e){
			Assert.fail("Inmovilizado");
		}catch (IncapacidadDeAtacar e) {
			Assert.fail("No puede atacar");
		}
		
		try {
			goku.moverAbajo();
		  }catch (IncapacidadParaMoverse e) {
			  pruebaOk=true;
		  }catch (InhabilitadoError e){
			  Assert.fail("Inmovilizado");
		  }catch (PosicionInadecuada e){
		      Assert.fail("No se ubico al personaje");
		  }
		
		Assert.assertTrue(pruebaOk);
	}
	
	@Test
	public void GokuNoPuedeMoverseSiAtacaGohanYAntesSeMueveGoku(){
		boolean pruebaOk=false;
		
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Personaje goku= new Goku(tablero);
		Personaje gohan= new Gohan(tablero);
		Personaje piccolo= new Piccolo(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, piccolo);
		Personaje freezer= new Freezer(tablero);
		Equipo equipo2=new Equipo();
		equipo2.asignarPersonaje1(freezer);
		equipo.esTuTurno();
		
		try{
			goku.ubicarEn(2,3);
			gohan.ubicarEn(1,4);
			freezer.ubicarEn(1,5);
			goku.moverAbajo();
			gohan.ataqueBasico(freezer);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico el personaje");
		}catch (IncapacidadParaMoverse e) {
			Assert.fail("No puede moverse");
		}catch (InhabilitadoError e){
			Assert.fail("Inmovilizado");
		}catch (IncapacidadDeAtacar e) {
			  Assert.fail("No puede atacar");
		}
		Assert.assertTrue(goku.enMovimiento());
		Assert.assertTrue(equipo.ataco());
		Assert.assertTrue(equipo.otrosCompanierosSeEstanMoviendo(gohan));
		
		try {
			goku.moverDerecha();
		  }catch (IncapacidadParaMoverse e) {
			  pruebaOk=true;
		  }catch (InhabilitadoError e){
			  Assert.fail("Inmovilizado");
		  }catch (PosicionInadecuada e){
		      Assert.fail("No se ubico al personaje");
		  }
		
		Assert.assertTrue(pruebaOk);
	}
	
	@Test
	public void siGokuSeMueveUnPasoGohanNoPuedeMoverse(){
		boolean pruebaOk=false;
		
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Personaje goku= new Goku(tablero);
		Personaje gohan= new Gohan(tablero);
		Personaje piccolo= new Piccolo(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, piccolo);
		Personaje freezer= new Freezer(tablero);
		Equipo equipo2=new Equipo();
		equipo2.asignarPersonaje1(freezer);
		equipo.esTuTurno();
		
		try{
			goku.ubicarEn(2,3);
			gohan.ubicarEn(1,4);
			goku.moverAbajo();
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico el personaje");
		}catch (IncapacidadParaMoverse e) {
			Assert.fail("No puede moverse");
		}catch (InhabilitadoError e){
			Assert.fail("Inmovilizado");
		}

		try {
			gohan.moverDerecha();
		}catch (IncapacidadParaMoverse e) {
			pruebaOk=true;
		}catch (InhabilitadoError e){
			Assert.fail("Inmovilizado");
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico al personaje");
		}
		
		Assert.assertTrue(pruebaOk);
	}

	@Test
	public void siGokuSeMueveDosPasosGohanPuedeAtacarPeroGokuNoSePuedeMoverDespues(){
		boolean pruebaOk=false;
		
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Personaje goku= new Goku(tablero);
		Personaje gohan= new Gohan(tablero);
		Personaje piccolo= new Piccolo(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, piccolo);
		Personaje freezer= new Freezer(tablero);
		Equipo equipo2=new Equipo();
		equipo2.asignarPersonaje1(freezer);
		equipo.esTuTurno();
		
		try{
			goku.ubicarEn(2,3);
			gohan.ubicarEn(1,4);
			freezer.ubicarEn(1,5);
			goku.moverAbajo();
			goku.moverDerecha();
			gohan.ataqueBasico(freezer);
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico el personaje");
		}catch (IncapacidadParaMoverse e) {
			Assert.fail("No puede moverse");
		}catch (InhabilitadoError e){
			Assert.fail("Inmovilizado");
		}catch (IncapacidadDeAtacar e) {
			Assert.fail("No puede atacar");
		}
		
		try {
			goku.moverDerecha();
		}catch (IncapacidadParaMoverse e) {
			pruebaOk=true;
		}catch (InhabilitadoError e){
			Assert.fail("Inmovilizado");
		}catch (PosicionInadecuada e){
			Assert.fail("No se ubico al personaje");
		}
		
		Assert.assertTrue(pruebaOk);
	}
	
	@Test
	public void noSePuedeAtacarBasicoAlMismoEquipo() throws InhabilitadoError{
		boolean puede_atacar = true;
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Personaje goku= new Goku(tablero);
		Personaje gohan= new Gohan(tablero);
		Personaje piccolo= new Piccolo(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, piccolo);
		equipo.esTuTurno();
		try{
			goku.ataqueBasico(gohan);
		}catch(IncapacidadDeAtacar excepcion){
			puede_atacar = false;
		}
		Assert.assertFalse(puede_atacar);
	}
	
	@Test
	public void noSePuedeAtacarEspecialAlMismoEquipo() throws InhabilitadoError{
		boolean puede_atacar = true;
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Personaje goku= new Goku(tablero);
		Personaje gohan= new Gohan(tablero);
		Personaje piccolo= new Piccolo(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, piccolo);
		equipo.esTuTurno();
		goku.aumentarKi(60);
		try{
			goku.ataqueEspecial(gohan);
		}catch(IncapacidadDeAtacar excepcion){
			puede_atacar = false;
		}
		Assert.assertFalse(puede_atacar);
	}
	
	@Test
	public void majinBooNoPuedeAtacarEspecialAlMismoEquipo() throws InhabilitadoError{
		boolean puede_atacar = true;
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Personaje goku= new Goku(tablero);
		Personaje gohan= new Gohan(tablero);
		Personaje majinboo= new MajinBoo(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, majinboo);
		equipo.esTuTurno();
		majinboo.aumentarKi(60);
		try{
			majinboo.ataqueEspecial(gohan);
		}catch(IncapacidadDeAtacar excepcion){
			puede_atacar = false;
		}
		Assert.assertFalse(puede_atacar);
	}
	
	@Test
	public void cellNoPuedeAtacarEspecialAlMismoEquipo() throws InhabilitadoError{
		boolean puede_atacar = true;
		Juego juego= new Juego();
		Tablero tablero=juego.obtenerTablero();
		Personaje goku= new Goku(tablero);
		Personaje gohan= new Gohan(tablero);
		Personaje cell= new Cell(tablero);
		Equipo equipo=new Equipo();
		equipo.asignarPersonajes(goku, gohan, cell);
		equipo.esTuTurno();
		cell.aumentarKi(60);
		try{
			cell.ataqueEspecial(gohan);
		}catch(IncapacidadDeAtacar excepcion){
			puede_atacar = false;
		}
		Assert.assertFalse(puede_atacar);
	}
	
}