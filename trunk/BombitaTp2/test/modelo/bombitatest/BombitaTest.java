package modelo.bombitatest;

import static org.junit.Assert.*;
import org.junit.*;
import modelo.ArmamentoFactory.*;
import modelo.armamento.*;
import modelo.articulo.*;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.*;
import static org.mockito.Mockito.*;

public class BombitaTest {
	private Bombita rodriguez;
	private ArmamentoFactory molotovFactory;
	private Habano habano;
	private ArmamentoFactory toleToleFactory;
	private ToleTole toleTole;
	private Timer timer;
	
	@Before
	public void setUp() {
		Coordenada coordenada = new Coordenada(1, 1);
		molotovFactory = new MolotovFactory();
		habano = new Habano(coordenada);
		toleToleFactory = new ToleToleFactory();
		timer = new Timer(coordenada);
		Mapa mapa = mock(Mapa.class);
		rodriguez = new Bombita(coordenada,mapa);
		toleTole = new ToleTole(coordenada,mapa,1);
	}

	@Test
	public void testInicializarVelocidad() {
		assertTrue(rodriguez.getVelocidad() == 10);
	}

	@Test
	public void testInicializarBomba() {
		assertEquals(molotovFactory.getClass(), rodriguez.tirarArmamento()
				.getClass());
	}

	@Test
	public void testInicializarVida() {
		assertTrue(rodriguez.obtenerVida() == 5);
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
		rodriguez.restarVida(1);
		assertTrue(rodriguez.obtenerVida() == 4);
	}

	@Test
	public void testSinVida() {
		rodriguez.restarVida(100);
		assertTrue(rodriguez.estaMuerto() == true);
	}

	@Test
	public void testObtenerHabanoYAumentarVelocidad() {
		rodriguez.tomarArticulo(habano);
		assertTrue(rodriguez.getVelocidad() == 20);
	}

	@Test
	public void testCambiarArmamentoInicialPorToleTole() {
		rodriguez.cambiarArmamento(toleToleFactory);
		assertEquals(toleToleFactory.getClass(), rodriguez.tirarArmamento().getClass());
	}

	@Test
	public void testObtenerToleToleYCambiarBomba() {
		ArticuloToleTole artTole = new ArticuloToleTole(mock(Coordenada.class));
		rodriguez.tomarArticulo(artTole);
		assertEquals(toleToleFactory.getClass(), rodriguez.tirarArmamento().getClass());
	}

	@Test
	public void testObtenerTimerYCambiarTiempoRetraso() {
		rodriguez.tomarArticulo(timer);
		assertEquals(0, rodriguez.tirarArmamento().obtenerTime(), 500);
	}

	@Test
	public void testDaniar() {
		this.rodriguez.Daniar(2);
		assertTrue(rodriguez.obtenerVida() == 3);
	}
	
	@Test
	public void testDaniarEstandoMuerto() {
		this.rodriguez.Daniar(5);
		this.rodriguez.Daniar(1);
		assertTrue(rodriguez.obtenerVida() == 0);
	}

	@Test
	public void testchocar() {
		rodriguez.chocar();
		assertTrue(rodriguez.obtenerVida() == 0);
	}
	
	@Test
	public void testMoverseHaciaArriba() {
		rodriguez.moverseArriba();
		assertTrue(rodriguez.obtenerCoordenadaXY().obtenerCoordenadaY() == 1);
	}
	
	@Test
	public void testMoverseHaciaAbajo() {
		rodriguez.moverseAbajo();
		assertTrue(rodriguez.obtenerCoordenadaXY().obtenerCoordenadaY() == 1);
	}
	
	@Test
	public void testMoverseHaciaDerecha() {
		rodriguez.moverseDerecha();
		assertTrue(rodriguez.obtenerCoordenadaXY().obtenerCoordenadaX() == 1);
	}
	
	@Test
	public void testMoverseHaciaIzquierda() {
		rodriguez.moverseIzquierda();
		assertTrue(rodriguez.obtenerCoordenadaXY().obtenerCoordenadaX() == 1);
	}

	@Test
	public void testInicializarActitudAtaque() {
		assertTrue(rodriguez.obtenerActitudAtaque() == false);
	}
	
	@Test
	public void testCambiarActitudAtaque() {
		rodriguez.cambiarActitud();
		assertTrue(rodriguez.obtenerActitudAtaque() == true);
	}
	

	@Test
	public void testCambiarActitudAlAtacarYVolverAFalso() {
		rodriguez.cambiarActitud();
		rodriguez.Atacar();
		assertTrue(rodriguez.obtenerActitudAtaque() == false);
	}
	
}
