package modelo.bloquetest;

import static org.junit.Assert.assertEquals;
import modelo.obstaculos.BloqueLadrillo;
import modelo.obstaculos.Obstaculo;
import org.junit.Test;
import modelo.errores.VidaInvalidaError;
import static org.junit.Assert.*;

public class BloqueLadrilloTest {
	@Test
	public void testQueChequeaQueElObjetoSeCreeCorrectamente() {
		Obstaculo Bloque = new BloqueLadrillo(10);
		assertEquals(Bloque.vidaRestante(), 10);
	}

	@Test
	public void testConstructorErrorVida() {
		try {
			Obstaculo Bloque = new BloqueLadrillo(-1);
			Bloque.Destruido();//para que no moleste
		} catch (VidaInvalidaError e) {
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}

	@Test
	public void testQuePruebaQuitarVida() {
		Obstaculo Bloque = new BloqueLadrillo(10);
		Bloque.QuitarVida(5);
		assertTrue(Bloque.vidaRestante() == 5);
	}

	@Test
	public void testQuePruebaQueUnBloqueEsDestruido() {
		Obstaculo Bloque = new BloqueLadrillo(10);
		Bloque.QuitarVida(10);
		assertTrue(Bloque.Destruido());
	}
	
	
	@Test
	
	public void testDaniar(){
		
		Obstaculo Bloque = new BloqueLadrillo(50);
		Bloque.Daniar(25);
		assertTrue(Bloque.vidaRestante()==25);
		
	}
	
}
