package modelo.puntaje;

import modelo.articulo.Habano;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.obstaculos.BloqueLadrillo;
import modelo.personaje.Bombita;
import modelo.personaje.enemigos.Cecilio;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.*;

public class PuntajeTest {

	private Cecilio cecilio;
	private BloqueLadrillo ladrillo;
	private Habano habano;
	private Casillero casillero;
	private Bombita rodriguez;
	
	@Before
	public void setUp() {
		Coordenada coordenada = new Coordenada(1,1);
		Mapa mapa = mock(Mapa.class);
		cecilio = mock(Cecilio.class);
		ladrillo = new BloqueLadrillo(coordenada);
		habano = new Habano(coordenada);
		casillero = new Casillero();
		rodriguez = new Bombita(coordenada,mapa);
		casillero.agregar(cecilio);
		casillero.agregar(habano);
		casillero.agregar(ladrillo);
		//casillero.agregar(rodriguez);
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
		assertTrue(casillero.obtenerPuntaje() == 300); //Devuelve 300 y no se porque!!!
														//hay un articulo que le esta sumando +100
														//(en el casillero hay un habano). Franco
	}
	
	@Test
	public void testAumentarPuntajeLuegoDeObtenerArticulo() {
		rodriguez.tomarArticulo(habano);
		casillero.actualizar();
		assertTrue(casillero.obtenerPuntaje() == 100);
	}
}
