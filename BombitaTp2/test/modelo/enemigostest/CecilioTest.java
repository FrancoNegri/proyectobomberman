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

public class CecilioTest {

	private Cecilio cecilio;
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
		cecilio = new Cecilio(coordenadaC);
		molotov = new MolotovFactory();
		derecha = new Derecha();
		izquierda = new Izquierda();
		arriba = new Arriba();
		abajo = new Abajo();
		movimiento = new Movimiento();
	}
	
	@Test
	public void testInicializarVelocidad() {
		assertTrue(cecilio.getVelocidad() == 100);
	}
	
	@Test
	public void testInicializarBomba() {
		assertEquals(molotov.getClass(),cecilio.tirarArmamento().getClass());
	}
	

	@Test
	public void testInicializarVida() {
		assertTrue(cecilio.obtenerVida() == 100);
	}
	
	@Test
	public void testInicializarCoordenadaX() {
		assertTrue(cecilio.obtenerCoordenadaXY().obtenerCoordenadaX() == 8);
	}
	
	@Test
	public void testInicializarCoordenadaY() {
		assertTrue(cecilio.obtenerCoordenadaXY().obtenerCoordenadaY() == 2);
	}
	
	@Test
	public void testRestarVida() {
		cecilio.restarVida(10);
		assertTrue(cecilio.obtenerVida() == 90);
	}
	
	@Test
	public void testSinVida() {
		cecilio.restarVida(100);
		assertTrue(cecilio.estaMuerto() == true);
	}
	
	//Agregar test de caminar (los agrego cuando modifique la clase movimiento usando la de translacion)
	
	@Test
	public void testDaniar(){
		this.cecilio.Daniar(20);
		assertTrue(cecilio.obtenerVida() == 80);
	}
	
	@Test
	public void testchocar(){
		cecilio.chocar();
		assertTrue(cecilio.obtenerVida() == 99);
	}
	
	@Test
	public void testListaDeMovimientosInicializadoCorrectamente() {
		LinkedList<Movimiento> lista = cecilio.obtenerMovimientos();
		assertTrue(lista.size() == 4);
	}
	
	@Test
	public void testobtenerMovimientoRandom(){
		movimiento = cecilio.obtenerDireccionDeMovimiento();
		assertTrue(movimiento.getClass() == derecha.getClass() | movimiento.getClass() == izquierda.getClass() 
				  | movimiento.getClass() == arriba.getClass() | movimiento.getClass() == abajo.getClass());
	}
}
