package modelo.enemigostest;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;
import modelo.ArmamentoFactory.*;
import modelo.armamento.Armamento;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.enemigos.*;

import org.junit.*;

public class CecilioTest {

	private Cecilio cecilio;
	private Coordenada coordenadaC;
	MolotovFactory molotov;
	Mapa mapa = mock(Mapa.class);
	Casillero casi = mock(Casillero.class);
	
	@Before
	public void setUp(){
		when(casi.esCaminable()).thenReturn(true);
		when(mapa.obtenerCasillero((Coordenada) anyObject())).thenReturn(casi);
		coordenadaC = new Coordenada(8,2);
		cecilio = new Cecilio(coordenadaC,mapa);
		molotov = new MolotovFactory();
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
		cecilio = new Cecilio(coordenadaC,mapa);
		when(casi.esCaminable()).thenReturn(true);
		when(mapa.obtenerCasillero((Coordenada) anyObject())).thenReturn(casi);
		cecilio.vivir();
		verify(casi).eliminar(cecilio);
		verify(mapa,times(2)).agregarAlMapa(cecilio);
	}
	@Test
	public void testEnemigoAtacar() {
		Mapa mapa = mock(Mapa.class);
		Casillero casi = mock(Casillero.class);
		cecilio = new Cecilio(coordenadaC,mapa);
		when(casi.esCaminable()).thenReturn(true);
		when(mapa.obtenerCasillero((Coordenada) anyObject())).thenReturn(casi);
		cecilio = spy(cecilio);
		when(cecilio.decideAtacar()).thenReturn(true);
		cecilio.vivir();
		verify(mapa).agregarAlMapa((Armamento)anyObject());
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
}