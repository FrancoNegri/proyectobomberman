package modelo.puntajetest;

import java.util.Timer;
import modelo.armamento.ToleTole;
import modelo.articulo.Articulable;
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

	private Cecilio cecilio;
	private BloqueLadrillo ladrillo;
	private Habano habano;
	private Casillero casillero;
	private Casillero otroCasillero;
	private Bombita rodriguez;
	private Mapa mapa;
	
	@Before
	public void setUp() {
		Coordenada coordenada = new Coordenada(1,1);
		Coordenada otraCoor = new Coordenada(2,2);
		cecilio = new Cecilio(coordenada);
		ladrillo = new BloqueLadrillo(coordenada);
		habano = new Habano(coordenada);
		casillero = new Casillero();
		otroCasillero = new Casillero();
		mapa = new Mapa(10);
		rodriguez = new Bombita(coordenada);
		casillero.agregar(cecilio);
		casillero.agregar(habano);
		casillero.agregar(ladrillo);
		casillero.agregar(rodriguez);
		otroCasillero.agregar(ladrillo);
		otroCasillero.agregar(habano);
		otroCasillero.agregar(rodriguez);
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
	public void testAumentarPuntajeLuegoDeMatarEnemigo() { //Pensar en que momento se peude sumar el puntaje al morir un enemigo
		/*cecilio.Daniar(5);
		casillero.actualizar();
		assertTrue(casillero.obtenerPuntaje() == 300);*/
	}
	
	@Test
	public void testAumentarPuntajeLuegoDeDestruirObstaculo() {
		ladrillo.Daniar(5);
		casillero.actualizar();
		assertTrue(casillero.obtenerPuntaje() == 300);
	}
	
	@Test
	public void testAumentarPuntajeLuegoDeObtenerArticulo() {
		rodriguez.tomarArticulo(habano);
		casillero.actualizar();
		assertTrue(casillero.obtenerPuntaje() == 100);
	}
	
	/*@Test
	public void testAumentarPuntajeEnDosCasillerosDiferentes() {
		habano = null;
		rodriguez = null;
		ladrillo = null;
		cecilio = null;
		casillero.actualizarPuntaje(300);
		assertTrue(casillero.obtenerPuntaje() == 300);
		otroCasillero.actualizarPuntaje(300);
		assertTrue(otroCasillero.obtenerPuntaje() == 300);
		mapa.actualizarMapa();
		assertTrue(mapa.obtenerPuntajeTotal() == 600);
	}*/
}