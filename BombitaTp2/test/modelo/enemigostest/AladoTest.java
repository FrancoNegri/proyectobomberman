package modelo.enemigostest;

import static org.junit.Assert.*;

import java.util.LinkedList;

import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.ArmamentoFactory.MolotovFactory;
import modelo.coordenadas.Coordenada;
import modelo.personaje.enemigos.*;
import modelo.personaje.movimiento.Abajo;
import modelo.personaje.movimiento.Arriba;
import modelo.personaje.movimiento.Derecha;
import modelo.personaje.movimiento.Izquierda;
import modelo.personaje.movimiento.Movimiento;

import org.junit.*;

public class AladoTest {

	private Alado lopez;
	private Coordenada coordenadaC;
	private ArmamentoFactory molotov;
	private Derecha derecha;
	private Izquierda izquierda;
	private Arriba arriba;
	private Abajo abajo;
	private Movimiento movimiento;
	
	@Before
	public void setUp(){
		coordenadaC = new Coordenada(8,2);
		lopez = new Alado(coordenadaC);
		molotov = new MolotovFactory();
		derecha = new Derecha();
		izquierda = new Izquierda();
		arriba = new Arriba();
		abajo = new Abajo();
		movimiento = new Movimiento();
	}
	
	@Test
	public void testInicializarVelocidad() {
		assertTrue(lopez.getVelocidad() == 10);
	}
	
	@Test
	public void testInicializarBomba() {
		assertEquals(molotov.getClass(),lopez.tirarArmamento().getClass());
	}
	

	@Test
	public void testInicializarVida() {
		assertTrue(lopez.obtenerVida() == 5);
	}
	
	@Test
	public void testInicializarCoordenadaX() {
		assertTrue(lopez.obtenerCoordenadaXY().obtenerCoordenadaX() == 8);
	}
	
	@Test
	public void testInicializarCoordenadaY() {
		assertTrue(lopez.obtenerCoordenadaXY().obtenerCoordenadaY() == 2);
	}
	
	@Test
	public void testRestarVida() {
		lopez.restarVida(1);
		assertTrue(lopez.obtenerVida() == 4);
	}
	
	@Test
	public void testSinVida() {
		lopez.restarVida(100);
		assertTrue(lopez.estaMuerto() == true);
	}
	
	@Test
	public void testCaminarHaciaLaDerecha() {
		lopez.caminar(derecha);
		assertTrue(lopez.obtenerCoordenadaXY().obtenerCoordenadaX() == 9);
	}
	
	@Test
	public void testCaminarHaciaLaIzquierda() {
		lopez.caminar(izquierda);
		assertTrue(lopez.obtenerCoordenadaXY().obtenerCoordenadaX() == 7);
	}
	
	@Test
	public void testCaminarHaciaLaDerechaYLuegoHaciaLaIzquierda() {
		lopez.caminar(derecha);
		lopez.caminar(izquierda);
		assertTrue(lopez.obtenerCoordenadaXY().obtenerCoordenadaX() == 8);
	}
	
	@Test
	public void testCaminarHaciaArriba() {
		lopez.caminar(arriba);
		assertTrue(lopez.obtenerCoordenadaXY().obtenerCoordenadaY() == 3);
	}

	public void testCaminarHaciaAbajo() {
		lopez.caminar(abajo);
		assertTrue(lopez.obtenerCoordenadaXY().obtenerCoordenadaY() == 1);
	}
	
	@Test
	public void testDaniar(){
		this.lopez.Daniar(2);
		assertTrue(lopez.obtenerVida() == 3);
	}
	
	@Test
	public void testchocar(){
		lopez.chocar();
		assertTrue(lopez.obtenerVida() == 4);
	}
	
	@Test
	public void testListaDeMovimientosInicializadoCorrectamente() {
		LinkedList<Movimiento> lista = lopez.obtenerMovimientos();
		assertTrue(lista.size() == 4);
	}
	
	@Test
	public void testobtenerMovimientoRandom(){
		movimiento = lopez.obtenerDireccionDeMovimiento();
		assertTrue(movimiento.getClass() == derecha.getClass() | movimiento.getClass() == izquierda.getClass() 
				  | movimiento.getClass() == arriba.getClass() | movimiento.getClass() == abajo.getClass());
	}
	
}
