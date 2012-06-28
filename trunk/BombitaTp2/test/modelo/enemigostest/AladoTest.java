package modelo.enemigostest;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;
import modelo.ArmamentoFactory.MolotovFactory;
import modelo.armamento.Armamento;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.enemigos.*;
import org.junit.*;



public class AladoTest {

	private LopezAlado lopez;
	private Coordenada coordenadaC;
	MolotovFactory molotov;
	Mapa mapa = mock(Mapa.class);
	Casillero casi = mock(Casillero.class);
	
	@Before
	public void setUp(){
		when(casi.esCaminable()).thenReturn(true);
		when(mapa.obtenerCasillero((Coordenada) anyObject())).thenReturn(casi);
		coordenadaC = new Coordenada(8,2);
		lopez = new LopezAlado(coordenadaC,mapa);
		molotov = new MolotovFactory();
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
		lopez = new LopezAlado(coordenadaC, mapa);
		lopez = spy(lopez);
		when(lopez.decideAtacar()).thenReturn(true);
		Casillero casi = mock(Casillero.class);
		when(casi.esCaminable()).thenReturn(true);
		when(mapa.obtenerCasillero((Coordenada) anyObject())).thenReturn(casi);
		lopez.vivir();
		verify(casi).eliminar(lopez);
		verify(mapa).agregarAlMapa(lopez);
	}
	
	@Test
	public void testEnemigoAtacar() {
		Mapa mapa = mock(Mapa.class);
		Casillero casi = mock(Casillero.class);
		lopez = new LopezAlado(coordenadaC, mapa);
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
		assertTrue(lopez.obtenerVida() == 3);
	}
	
	@Test
	public void testchocar(){
		lopez.chocar();
		assertTrue(lopez.obtenerVida() == 5);
	}
}
