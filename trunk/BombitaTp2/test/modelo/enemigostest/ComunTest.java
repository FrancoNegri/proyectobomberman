package modelo.enemigostest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import modelo.ArmamentoFactory.*;
import modelo.armamento.Armamento;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.enemigos.*;

import org.junit.*;


public class ComunTest {
	
	private LopezComun lopez;
	private Coordenada coordenadaL;
	Mapa mapa = mock(Mapa.class);
	Casillero casi = mock(Casillero.class);
	
	@Before
	public void setUp(){
		when(casi.esCaminable()).thenReturn(true);
		when(mapa.obtenerCasillero((Coordenada) anyObject())).thenReturn(casi);
		coordenadaL = new Coordenada(2,4);
		lopez = new LopezComun(coordenadaL,mapa);
	}
	
	@Test
	public void testInicializarVelocidad() {
		assertTrue(lopez.getVelocidad() == 20);
	}
	
	@Test
	public void testInicializarBomba() {
		assertEquals(ProyectilFactory.class,lopez.tirarArmamento().getClass());
	}
	

	@Test
	public void testInicializarVida() {
		assertTrue(lopez.obtenerVida() == 10);
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
		lopez.restarVida(1);
		assertTrue(lopez.obtenerVida() == 9);
	}
	
	@Test
	public void testSinVida() {
		lopez.restarVida(100);
		assertTrue(lopez.estaMuerto() == true);
	}
	
	@Test
	public void testCaminarRandom() {
		Mapa mapa = mock(Mapa.class);
		lopez = new LopezComun(coordenadaL,mapa);
		when(casi.esCaminable()).thenReturn(true);
		when(mapa.obtenerCasillero((Coordenada) anyObject())).thenReturn(casi);
		lopez = spy(lopez);
		lopez.vivir();
		verify(casi).eliminar(lopez);
		verify(mapa,times(1)).agregarAlMapa(lopez);
	}
	@Test
	public void testEnemigoAtacar() {
		Mapa mapa = mock(Mapa.class);
		lopez = new LopezComun(coordenadaL,mapa);
		when(casi.esCaminable()).thenReturn(true);
		when(mapa.obtenerCasillero((Coordenada) anyObject())).thenReturn(casi);
		Casillero casi = mock(Casillero.class);
		when(casi.esCaminable()).thenReturn(true);
		when(mapa.obtenerCasillero((Coordenada) anyObject())).thenReturn(casi);
		lopez = spy(lopez);
		when(lopez.decideAtacar()).thenReturn(true);
		lopez.vivir();
		verify(mapa).agregarAlMapa((Armamento)anyObject());
	}
	@Test
	public void testDaniar(){
		this.lopez.Daniar(2);
		assertTrue(lopez.obtenerVida() == 8);
	}
	
	@Test
	public void testchocar(){
		lopez.chocar();
		assertTrue(lopez.obtenerVida() == 10);
	}
}