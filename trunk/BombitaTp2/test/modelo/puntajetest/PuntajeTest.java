package modelo.puntajetest;

import modelo.armamento.ToleTole;
import modelo.articulo.Habano;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.obstaculos.BloqueLadrillo;
import modelo.personaje.Bombita;
import modelo.personaje.enemigos.Cecilio;
import static org.junit.Assert.*;
import org.junit.*;

public class PuntajeTest {

	private Cecilio cecilio,otroCecilio;
	private BloqueLadrillo ladrillo,otroLadrillo;
	private Habano habano;
	private ToleTole tole;
	private Casillero casillero,otroCasillero;
	private Bombita rodriguez;
	private Mapa mapa;
	
	@Before
	public void setUp() {
		mapa = new Mapa(10);
		Coordenada coordenada = new Coordenada(1,1);
		Coordenada otraCoordenada = new Coordenada(2,2);
		cecilio = new Cecilio(coordenada,mapa);
		ladrillo = new BloqueLadrillo(coordenada);
		otroLadrillo = new BloqueLadrillo(otraCoordenada);
		habano = new Habano(coordenada);
		casillero = new Casillero();
		tole = new ToleTole(coordenada,mapa,6);
		otroCasillero = new Casillero();
		rodriguez = new Bombita(coordenada,mapa);
		otroCecilio = new Cecilio(otraCoordenada,mapa);
		casillero.agregar(cecilio);
		casillero.agregar(ladrillo);
		casillero.agregar(rodriguez);
		otroCasillero.agregar(otroCecilio);
		mapa.agregarCasillero(coordenada, casillero);
		mapa.agregarCasillero(otraCoordenada,otroCasillero);
		
	}
	
	@Test
	public void testVerificarPuntajeInicialCorrecto() {
		assertTrue(casillero.obtenerPuntaje() == 0);
	}
	
	@Test
	public void testAumentarPuntaje() {
		int puntaje = 100;
		casillero.actualizarPuntaje(puntaje);
		assertTrue(casillero.obtenerPuntaje() == 100);
	}
	
	@Test
	public void testAumentarPuntajeLuegoDeMatarEnemigo() {
		cecilio.Daniar(5);
		casillero.actualizar();
		assertTrue(casillero.obtenerPuntaje() == 300);
	}
	
	@Test
	public void testAumentarPuntajeLuegoDeDestruirObstaculo() {
		ladrillo.Daniar(5);
		casillero.actualizar();
		assertTrue(casillero.obtenerPuntaje() == 200);
	}
	
	@Test
	public void testAumentarPuntajeLuegoDeObtenerArticulo() {
		casillero.agregar(habano);
		rodriguez.tomarArticulo(habano);
		casillero.actualizar();
		assertTrue(casillero.obtenerPuntaje() == 100);
	}
	
	@Test
	public void testAumentarPuntajeEnDosCasillerosDiferentes() {
		cecilio.Daniar(5);
		casillero.actualizar();
		otroCecilio.Daniar(5);
		otroCasillero.actualizar();
		mapa.vivir();
		assertTrue(mapa.obtenerPuntajeTotal() == 600);
	}
	
	@Test
	public void testObtenerPuntajeToleTole() {
		int puntaje = tole.obtenerPuntaje();
		assertTrue(puntaje == 100);
	}
}
