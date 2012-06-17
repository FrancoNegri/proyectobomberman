package modelo.enemigostest;

import static org.junit.Assert.*;
import modelo.ArmamentoFactory.*;
import modelo.coordenadas.Coordenada;
import modelo.personaje.enemigos.*;

import org.junit.*;


public class ComunTest {

	private Comun lopez;
	private Coordenada coordenadaL;
	private ArmamentoFactory proyectil;
	
	@Before
	public void setUp(){
		coordenadaL = new Coordenada(2,4);
		lopez = new Comun(coordenadaL);
		proyectil = new ProyectilFactory();
	}
	
	@Test
	public void testInicializarVelocidad() {
		assertTrue(lopez.getVelocidad() == 200);
	}
	
	@Test
	public void testInicializarBomba() {
		assertEquals(proyectil.getClass(),lopez.tirarArmamento().getClass());
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
}