package modelo.bloquetest;

import modelo.coordenadas.Coordenada;
import modelo.obstaculos.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;

public class BloqueAceroTest {
	Coordenada coord = mock(Coordenada.class);
	
	@Test
	public void testQueChequeaQueElObjetoSeCreeCorrectamente()
	{
		
		Obstaculo Bloque = new BloqueAcero(coord);
		assertEquals(Bloque.vidaRestante(), 1000);
	}
	
	@Test
	public void testQuePruebaQuitarVida()
	{
		Obstaculo Bloque = new BloqueAcero(coord);
		Bloque.QuitarVida(5);
		assertTrue(Bloque.vidaRestante() == 995);
	}
	@Test
	public void testQuePruebaQueUnBloqueEsDestruido()
	{
		Obstaculo Bloque = new BloqueAcero(coord);
		Bloque.QuitarVida(1000);
		assertTrue(Bloque.Destruido());
	}
	
	@Test
	
	public void testDaniar(){
		
		Obstaculo Bloque = new BloqueAcero(coord);
		Bloque.Daniar(25);
		assertTrue(Bloque.vidaRestante()==975);
	}
	
	
}
