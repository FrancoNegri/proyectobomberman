package modelo.bombitatest;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.*;
import modelo.armamento.*;
import modelo.articulo.*;
import modelo.personaje.*;


public class BombitaTest {

	private Bombita rodriguez;
	private Molotov molotov;
	private Habano habano;
	private ToleTole toleTole;
	private Timer timer;

	
	@Before
	public void setUp(){
		rodriguez = new Bombita();
		molotov = new Molotov();
		habano = new Habano();
		toleTole = new ToleTole();
		timer = new Timer();
	}
	
	@Test
	public void testInicializarVelocidad() {
		assertTrue(rodriguez.getVelocidad() == 5);
	}
	
	@Test
	public void testInicializarBomba() {
		assertEquals(molotov.getClass(),rodriguez.armamentoActual().getClass());
	}
	

	@Test
	public void testInicializarVida() {
		assertTrue(rodriguez.getVida() == 100);
	}
	
	@Test
	public void testRestarVida() {
		rodriguez.restarVida(10);
		assertTrue(rodriguez.getVida() == 90);
	}
	
	@Test
	public void testSinVida() {
		rodriguez.restarVida(100);
		assertTrue(rodriguez.estaMuerto() == true);
	}
	
	@Test
	public void testObtenerHabanoYAumentarVelocidad() {
		rodriguez.tomarArticulo(habano);
		assertTrue(rodriguez.getVelocidad() == 15 );
	}
	
	@Test
	public void testCambiarArmamentoInicialPorToleTole() {
		rodriguez.cambiarArmamento(toleTole);
		assertEquals(toleTole.getClass(),rodriguez.armamentoActual().getClass());
	}
	
	@Test
	public void testObtenerToleToleYCambiarBomba() {
		rodriguez.tomarArticulo(toleTole);
		assertEquals(toleTole.getClass(),rodriguez.armamentoActual().getClass());
	}
	
	@Test
	//Aca esta andando mal el resultado obtenido, habria que ver con el test unitario de obtenerTime
	public void testObtenerTimerYCambiarTiempoRetraso() {
		rodriguez.tomarArticulo(timer);
		assertEquals(0,0, rodriguez.armamentoActual().obtenerTime() );
	}
//	@Test
//	public void testCambiarAEstadoHabanoChalaYVerVelocidad() {
//		rodriguez.cambiarEstado(unEstado);
//		rodriguez.actualizarAtributosBombita(rodriguez);
//		assertTrue(rodriguez.getVelocidad() == 10);
//	}
//	
//	@Test
//	public void testCambiarAEstadoToleToleYVerBomba() {
//		rodriguez.cambiarEstado(otroEstado);
//		rodriguez.actualizarAtributosBombita(rodriguez);
//		assertTrue(rodriguez.conocerBomba() == "ToleTole");
//	}
}
