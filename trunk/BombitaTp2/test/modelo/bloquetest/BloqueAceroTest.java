package modelo.bloquetest;

import modelo.errores.VidaInvalidaError;
import modelo.obstaculos.*;
import static org.junit.Assert.*;

import org.junit.*;

public class BloqueAceroTest {
	@Test
	public void testQueChequeaQueElObjetoSeCreeCorrectamente()
	{
		Obstaculo Bloque = new BloqueAcero(10);
		assertEquals(Bloque.vidaRestante(), 10);
	}
	
	@Test
	public void testConstructorErrorVida()
	{
		try
		{
		Obstaculo Bloque = new BloqueAcero(-1);
		Bloque.Destruido();
		}catch(VidaInvalidaError e)
		{
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}
	@Test
	public void testQuePruebaQuitarVida()
	{
		Obstaculo Bloque = new BloqueAcero(10);
		Bloque.QuitarVida(5);
		assertTrue(Bloque.vidaRestante() == 5);
	}
	@Test
	public void testQuePruebaQueUnBloqueEsDestruido()
	{
		Obstaculo Bloque = new BloqueAcero(10);
		Bloque.QuitarVida(10);
		assertTrue(Bloque.Destruido());
	}
	
	@Test
	
	public void testDaniar(){
		
		Obstaculo Bloque = new BloqueAcero(50);
		Bloque.Daniar(25);
		assertTrue(Bloque.vidaRestante()==25);
		
	}
	
	
}