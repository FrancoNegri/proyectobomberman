package modelo.enemigostest;

import static org.junit.Assert.*;

import java.util.LinkedList;

import modelo.ArmamentoFactory.*;
import modelo.coordenadas.Coordenada;
import modelo.personaje.enemigos.*;
import modelo.personaje.movimiento.Abajo;
import modelo.personaje.movimiento.Arriba;
import modelo.personaje.movimiento.Derecha;
import modelo.personaje.movimiento.Izquierda;
import modelo.personaje.movimiento.Movimiento;

import org.junit.*;


public class ComunTest {

	private Comun lopez;
	private Coordenada coordenadaL;
	private Derecha derecha;
	private Izquierda izquierda;
	private Arriba arriba;
	private Abajo abajo;
	private Movimiento movimiento;
	
	@Before
	public void setUp(){
		coordenadaL = new Coordenada(2,4);
		lopez = new Comun(coordenadaL);
		derecha = new Derecha();
		izquierda = new Izquierda();
		arriba = new Arriba();
		abajo = new Abajo();
		movimiento = new Movimiento();
	}
	
	@Test
	public void testInicializarVelocidad() {
		assertTrue(lopez.getVelocidad() == 200);
	}
	
	@Test
	public void testInicializarBomba() {
		assertEquals(ProyectilFactory.class,lopez.tirarArmamento().getClass());
	}
	

	@Test
	public void testInicializarVida() {
		assertTrue(lopez.obtenerVida() == 100);
	}
	
	@Test
	public void testInicializarCoordenadaX() {
		assertTrue(lopez.obtenerCoordenadaXY().obtenerCoordenadaX() == 2);
	}
	
	@Test
	public void testInicializarCoordenadaY() {
		assertTrue(lopez.obtenerCoordenadaXY().obtenerCoordenadaY() == 4);
	}
	
	@Test
	public void testRestarVida() {
		lopez.restarVida(10);
		assertTrue(lopez.obtenerVida() == 90);
	}
	
	@Test
	public void testSinVida() {
		lopez.restarVida(100);
		assertTrue(lopez.estaMuerto() == true);
	}
	
	//Agregar test de caminar (los agrego cuando modifique la clase movimiento usando la de translacion)
	
	@Test
	public void testDaniar(){
		this.lopez.Daniar(20);
		assertTrue(lopez.obtenerVida() == 80);
	}
	
	@Test
	public void testchocar(){
		lopez.chocar();
		assertTrue(lopez.obtenerVida() == 99);
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
