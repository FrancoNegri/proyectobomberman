package modelo.enemigostest;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;

import modelo.ArmamentoFactory.*;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
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
		assertTrue(cecilio.getVelocidad() == 10);
	}
	
	@Test
	public void testInicializarBomba() {
		assertEquals(molotov.getClass(),cecilio.tirarArmamento().getClass());
	}
	

	@Test
	public void testInicializarVida() {
		assertTrue(cecilio.obtenerVida() == 5);
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
		cecilio.restarVida(1);
		assertTrue(cecilio.obtenerVida() == 4);
	}
	
	@Test
	public void testSinVida() {
		cecilio.restarVida(100);
		assertTrue(cecilio.estaMuerto() == true);
	}
	
	@Test
	public void testCaminarRandom() {
		Mapa mapa = mock(Mapa.class);
		Casillero casi = mock(Casillero.class);
		when(casi.esCaminable()).thenReturn(true);
		when(mapa.obtenerCasillero((Coordenada) anyObject())).thenReturn(casi);
		cecilio.setMapa(mapa);
		cecilio.actualizar();
		verify(casi).eliminar(cecilio);
		verify(mapa).agregarAlMapa(cecilio);
	}
	
	@Test
	public void testDaniar(){
		this.cecilio.Daniar(2);
		assertTrue(cecilio.obtenerVida() == 3);
	}
	
	@Test
	public void testchocar(){
		cecilio.chocar();
		assertTrue(cecilio.obtenerVida() == 4);
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
