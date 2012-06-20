package modelo.puntaje;

import modelo.articulo.Habano;
import modelo.coordenadas.Coordenada;
import modelo.obstaculos.BloqueLadrillo;
import modelo.personaje.Bombita;
import modelo.personaje.enemigos.Cecilio;
import static org.junit.Assert.*;
import org.junit.*;

public class PuntajeTest {

	private Bombita rodriguez;
	private Cecilio cecilio;
	private BloqueLadrillo ladrillo;
	private Habano habano;
	
	@Before
	public void setUp() {
		Coordenada coordenada = new Coordenada(1, 1);
		rodriguez = new Bombita(coordenada);
		cecilio = new Cecilio(coordenada);
		ladrillo = new BloqueLadrillo(coordenada);
		habano = new Habano(coordenada);
	}
	
	@Test
	public void testVerificarPuntajeInicialCorrectoEnBombita() {
		assertTrue(rodriguez.obtenerPuntaje() == 0);
	}
	
	@Test
	public void testAumentarPuntajeBombita() {
		int puntaje = 100;
		rodriguez.actualizarPuntaje(puntaje);
		assertTrue(rodriguez.obtenerPuntaje() == 100);
	}
	
	@Test
	public void testAumentarPuntajeBombitaLuegoDeMatarEnemigo() {
		cecilio.Daniar(5);
		rodriguez.actualizarPuntaje(cecilio.obtenerPuntaje());
		assertTrue(rodriguez.obtenerPuntaje() == 300);
	}
	
	@Test
	public void testAumentarPuntajeBombitaLuegoDeDestruirObstaculo() {
		ladrillo.Daniar(5);
		rodriguez.actualizarPuntaje(ladrillo.obtenerPuntaje());
		assertTrue(rodriguez.obtenerPuntaje() == 200);
	}
	
	@Test
	public void testAumentarPuntajeBombitaLuegoDeObtenerArticulo() {
		rodriguez.actualizarPuntaje(habano.obtenerPuntaje());
		assertTrue(rodriguez.obtenerPuntaje() == 100);
	}
}
