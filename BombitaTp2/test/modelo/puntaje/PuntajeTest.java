package modelo.puntaje;

import modelo.articulo.Habano;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
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
	private Bombita rodriguez;
	
	@Before
	public void setUp() {
		Coordenada coordenada = new Coordenada(1,1);
		cecilio = new Cecilio(coordenada);
		ladrillo = new BloqueLadrillo(coordenada);
		habano = new Habano(coordenada);
		casillero = new Casillero();
		rodriguez = new Bombita(coordenada);
		casillero.agregar(cecilio);
		casillero.agregar(habano);
		casillero.agregar(ladrillo);
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
		/*cecilio.Daniar(5);
		rodriguez.actualizarPuntaje(cecilio.obtenerPuntaje());
		assertTrue(rodriguez.obtenerPuntaje() == 300);*/
	}
	
	@Test
	public void testAumentarPuntajeLuegoDeDestruirObstaculo() {
		ladrillo.Daniar(5);
		casillero.actualizar();
		assertTrue(casillero.obtenerPuntaje() == 200);
	}
	
	@Test
	public void testAumentarPuntajeBombitaLuegoDeObtenerArticulo() {
		
		casillero.actualizarPuntaje(habano.obtenerPuntaje());
		assertTrue(casillero.obtenerPuntaje() == 100);
	}
}
