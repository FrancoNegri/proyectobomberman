package modelo.bloquetest;

import static org.junit.Assert.assertEquals;
import modelo.obstaculos.BloqueLadrillo;
import modelo.obstaculos.Obstaculo;
import org.junit.Test;

import modelo.coordenadas.Coordenada;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class BloqueLadrilloTest {
	Coordenada coord = mock(Coordenada.class);
	@Test
	public void testQueChequeaQueElObjetoSeCreeCorrectamente() {
		Obstaculo Bloque = new BloqueLadrillo(coord);
		assertEquals(Bloque.vidaRestante(), 5);
	}

	@Test
	public void testQuePruebaQuitarVida() {
		Obstaculo Bloque = new BloqueLadrillo(coord);
		Bloque.QuitarVida(5);
		assertTrue(Bloque.vidaRestante() == 0);
	}

	@Test
	public void testQuePruebaQueUnBloqueEsDestruido() {
		Obstaculo Bloque = new BloqueLadrillo(coord);
		Bloque.QuitarVida(10);
		assertTrue(Bloque.Destruido());
	}
	
	
	@Test
	
	public void testDaniar(){
		
		Obstaculo Bloque = new BloqueLadrillo(coord);
		Bloque.Daniar(25);
		assertTrue(Bloque.vidaRestante()<0);
		
	}
	
}
