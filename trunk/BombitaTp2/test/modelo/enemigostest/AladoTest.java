package modelo.enemigostest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.LinkedList;

import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.ArmamentoFactory.MolotovFactory;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.Personaje;
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
	public void testCaminarRandom() {
		
		Mapa mapa = mock(Mapa.class);
		Casillero casi = mock(Casillero.class);
		when(casi.esCaminable()).thenReturn(true);
		when(mapa.obtenerCasillero((Coordenada) anyObject())).thenReturn(casi);
		lopez.setMapa(mapa);
		lopez.actualizar();
		verify(casi).eliminar(lopez);
		verify(mapa).agregarAlMapa(lopez);
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
