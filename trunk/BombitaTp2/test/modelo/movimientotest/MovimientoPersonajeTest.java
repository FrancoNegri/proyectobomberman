package modelo.movimientotest;

import static org.junit.Assert.*;
import org.junit.*;
import modelo.personaje.Bombita;
import modelo.personaje.movimiento.*;

public class MovimientoPersonajeTest {

	private Bombita rodriguez;
	private Derecha derecha;
	private Izquierda izquierda;
	private Abajo abajo;
	private Arriba arriba;
	
	@Before
	public void setUp(){
		rodriguez = new Bombita();
		derecha = new Derecha();
		izquierda = new Izquierda();
		abajo = new Abajo();
		arriba = new Arriba();
	}
		
	@Test
	public void testMoverDerecha() {
		derecha.mover(rodriguez);
		assertTrue(rodriguez.obtenerCoordenadaXY().obtenerCoordenadaX() == 2);
	}
	
	@Test
	public void testMoverDerechaYNoCambiaOtroSentido() {
		derecha.mover(rodriguez);
		assertTrue(rodriguez.obtenerCoordenadaXY().obtenerCoordenadaY() == 1);
	}
	
	@Test
	public void testMoverIzquierda() {
		izquierda.mover(rodriguez);
		assertTrue(rodriguez.obtenerCoordenadaXY().obtenerCoordenadaX() == 0);
	}
		
	@Test
	public void testMoverArriba() {
		arriba.mover(rodriguez);
		assertTrue(rodriguez.obtenerCoordenadaXY().obtenerCoordenadaY() == 2);
	}	
	
	@Test
	public void testMoverAbajo() {
		abajo.mover(rodriguez);
		assertTrue(rodriguez.obtenerCoordenadaXY().obtenerCoordenadaY() == 0);
	}

	@Test
	public void testObtenerNumeroRandom() {
		int numero = derecha.obtenerNumeroRandom();
		assertTrue(numero == 0 | numero == 1 | numero == 2 | numero == 3);
	}
}
