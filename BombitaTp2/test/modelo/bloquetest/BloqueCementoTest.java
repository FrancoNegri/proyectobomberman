package modelo.bloquetest;

import modelo.coordenadas.Coordenada;
import modelo.obstaculos.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.*;

public class BloqueCementoTest {
	Coordenada coord = mock(Coordenada.class);

	@Test
	public void testQueChequeaQueElObjetoSeCreeCorrectamente() {
		Obstaculo Bloque = new BloqueCemento(coord);
		assertEquals(Bloque.vidaRestante(), 10);
	}

	@Test
	public void testQuePruebaQuitarVida() {
		Obstaculo Bloque = new BloqueCemento(coord);
		Bloque.Daniar(5);
		assertTrue(Bloque.vidaRestante() == 5);
	}

	@Test
	public void testQuePruebaQueUnBloqueEsDestruido() {
		Obstaculo Bloque = new BloqueCemento(coord);
		Bloque.Daniar(10);
		assertTrue(Bloque.Destruido());
	}

	@Test
	public void testDaniar() {

		Obstaculo Bloque = new BloqueCemento(coord);
		Bloque.Daniar(25);
		assertTrue(Bloque.vidaRestante() < 0);

	}

	@Test
	public void testDaniarConVidaNula() {

		Obstaculo Bloque = new BloqueAcero(coord);
		Bloque.Daniar(1000);
		Bloque.Daniar(10);
	}
	
	@Test
	public void testNoObtenerPuntajeAlNoMatarlo() {
		
		Obstaculo Bloque = new BloqueAcero(coord);
		Bloque.Daniar(10);
		assertTrue(Bloque.obtenerPuntaje() == 0);
	}
}
