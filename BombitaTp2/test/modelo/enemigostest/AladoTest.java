package modelo.enemigostest;

import static org.junit.Assert.*;
import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.ArmamentoFactory.MolotovFactory;
import modelo.coordenadas.Coordenada;
import modelo.personaje.enemigos.*;

import org.junit.*;

public class AladoTest {

	private Alado lopez;
	private Coordenada coordenadaC;
	private ArmamentoFactory molotov;
	
	@Before
	public void setUp(){
		coordenadaC = new Coordenada(8,2);
		lopez = new Alado(coordenadaC);
		molotov = new MolotovFactory();
	}
	
	@Test
	public void testInicializarVelocidad() {
		assertTrue(lopez.getVelocidad() == 100);
	}
	
	@Test
	public void testInicializarBomba() {
		assertEquals(molotov.getClass(),lopez.tirarArmamento().getClass());
	}
	

	@Test
	public void testInicializarVida() {
		assertTrue(lopez.obtenerVida() == 100);
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
