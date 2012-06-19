package modelo.movimientotest;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.*;

import modelo.coordenadas.Coordenada;
import modelo.personaje.Bombita;
import modelo.personaje.movimiento.*;

public class MovimientoPersonajeTest {

	private Bombita rodriguez;
	private Derecha derecha;
	private Izquierda izquierda;
	private Abajo abajo;
	private Arriba arriba;
	private Movimiento movimiento;
	
	@Before
	public void setUp(){
		Coordenada coordenada = new Coordenada(1,1);
		rodriguez = new Bombita(coordenada);
		derecha = new Derecha();
		izquierda = new Izquierda();
		abajo = new Abajo();
		arriba = new Arriba();
		movimiento = new Movimiento();
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
		assertTrue(numero == 1 | numero == 2 | numero == 3 | numero == 4);
	}
	
	@Test
	public void testListaDeMovimientosInicializadoCorrectamente() {
		LinkedList<Movimiento> lista = movimiento.inicializarMovimientos();
		assertTrue(lista.size() == 4);
	}
	
	@Test
	public void testGuardaElUltimoMovimiento() {
		rodriguez.caminar(izquierda);
		assertTrue(rodriguez.getUltimoMovimiento() == izquierda);
	}
}
