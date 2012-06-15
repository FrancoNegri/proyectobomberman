package modelo.bloquetest;

import modelo.errores.VidaInvalidaError;
import modelo.obstaculos.*;
import static org.junit.Assert.*;
import org.junit.*;

public class BloqueCementotest {

	@Test
	public void testQueChequeaQueElObjetoSeCreeCorrectamente() {
		Obstaculo Bloque = new BloqueCemento(10);
		assertEquals(Bloque.vidaRestante(), 10);
	}

	@Test
	public void testConstructorErrorVida() {
		try {
			Obstaculo Bloque = new BloqueCemento(-1);
			Bloque.Destruido();//para que no moleste
		} catch (VidaInvalidaError e) {
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}

	@Test
	public void testQuePruebaQuitarVida() {
		Obstaculo Bloque = new BloqueCemento(10);
		Bloque.QuitarVida(5);
		assertTrue(Bloque.vidaRestante() == 5);
	}

	@Test
	public void testQuePruebaQueUnBloqueEsDestruido() {
		Obstaculo Bloque = new BloqueCemento(10);
		Bloque.QuitarVida(10);
		assertTrue(Bloque.Destruido());
	}
}
