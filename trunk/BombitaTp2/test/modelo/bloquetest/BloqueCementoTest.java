package modelo.bloquetest;

import modelo.coordenadas.Coordenada;
import modelo.errores.VidaInvalidaError;
import modelo.obstaculos.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.junit.*;

public class BloqueCementoTest {
	Coordenada coord = mock(Coordenada.class);
	@Test
	public void testQueChequeaQueElObjetoSeCreeCorrectamente() {
		Obstaculo Bloque = new BloqueCemento(10,coord);
		assertEquals(Bloque.vidaRestante(), 10);
	}

	@Test
	public void testConstructorErrorVida() {
		try {
			Obstaculo Bloque = new BloqueCemento(-1,coord);
			Bloque.Destruido();//para que no moleste
		} catch (VidaInvalidaError e) {
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}

	@Test
	public void testQuePruebaQuitarVida() {
		Obstaculo Bloque = new BloqueCemento(10,coord);
		Bloque.QuitarVida(5);
		assertTrue(Bloque.vidaRestante() == 5);
	}

	@Test
	public void testQuePruebaQueUnBloqueEsDestruido() {
		Obstaculo Bloque = new BloqueCemento(10,coord);
		Bloque.QuitarVida(10);
		assertTrue(Bloque.Destruido());
	}
	
	
	@Test
	
	public void testDaniar(){
		
		Obstaculo Bloque = new BloqueCemento(50,coord);
		Bloque.Daniar(25);
		assertTrue(Bloque.vidaRestante()==25);
		
	}
	
}
