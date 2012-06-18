package modelo.bombitatest;

import static org.junit.Assert.*;
import org.junit.*;
import modelo.ArmamentoFactory.*;
import modelo.armamento.*;
import modelo.articulo.*;
import modelo.coordenadas.Coordenada;
import modelo.personaje.*;
import modelo.personaje.movimiento.*;


public class BombitaTest {
	private Bombita rodriguez;
	private ArmamentoFactory molotovFactory;
	private Habano habano;
	private ArmamentoFactory toleToleFactory;
	private ToleTole toleTole;
	private Timer timer;
	private Derecha derecha;
	private Abajo abajo;

	@Before
	public void setUp(){
		Coordenada coordenada = new Coordenada(1,1);
		rodriguez = new Bombita(coordenada);
		molotovFactory = new MolotovFactory();
		habano = new Habano(coordenada);
		toleToleFactory = new ToleToleFactory();
		timer = new Timer(coordenada);
		derecha = new Derecha();
		abajo = new Abajo();
		toleTole = new ToleTole(coordenada,0);
	}
	
	@Test
	public void testInicializarVelocidad() {
		assertTrue(rodriguez.getVelocidad() == 5);
	}
	
	@Test
	public void testInicializarBomba() {
		assertEquals(molotovFactory.getClass(),rodriguez.tirarArmamento().getClass());
	}
	

	@Test
	public void testInicializarVida() {
		assertTrue(rodriguez.obtenerVida() == 100);
	}
	
	@Test
	public void testInicializarCoordenadaX() {
		assertTrue(rodriguez.obtenerCoordenadaXY().obtenerCoordenadaX() == 1);
	}
	
	@Test
	public void testInicializarCoordenadaY() {
		assertTrue(rodriguez.obtenerCoordenadaXY().obtenerCoordenadaY() == 1);
	}
	
	@Test
	public void testRestarVida() {
		rodriguez.restarVida(10);
		assertTrue(rodriguez.obtenerVida() == 90);
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
		rodriguez.cambiarArmamento(toleToleFactory);
		assertEquals(toleToleFactory.getClass(),rodriguez.tirarArmamento().getClass());
	}
	
	@Test
	public void testObtenerToleToleYCambiarBomba() {
		rodriguez.tomarArticulo(toleTole);
		assertEquals(toleToleFactory.getClass(),rodriguez.tirarArmamento().getClass());
	}
	
	@Test
	//Aca esta andando mal el resultado obtenido, habria que ver con el test unitario de obtenerTime
	public void testObtenerTimerYCambiarTiempoRetraso() {
		rodriguez.tomarArticulo(timer);
		assertEquals(0, rodriguez.tirarArmamento().obtenerTime(), 5 );
	}
	
	@Test
	public void testCaminarHaciaLaDerecha() {
		rodriguez.caminar(derecha);
		assertTrue(rodriguez.obtenerCoordenadaXY().obtenerCoordenadaX() == 2);
	}
	
	public void testCaminarHaciaAbajo() {
		rodriguez.caminar(abajo);
		assertTrue(rodriguez.obtenerCoordenadaXY().obtenerCoordenadaY() == 0);
	}
	
	@Test
	public void testDaniar(){
		this.rodriguez.Daniar(20);
		assertTrue(rodriguez.obtenerVida() == 80);
	}
	
	@Test
	public void testchocar(){
		rodriguez.chocar();
		assertTrue(rodriguez.obtenerVida() == 0);
	}
}
