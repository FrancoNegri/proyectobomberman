package modelo.bloquetest;

import modelo.bombitatest.Test;
import modelo.errores.VidaInvalidaError;
import modelo.obstaculos.*;
import junit.framework.TestCase;

public class TestBloqueAcero extends TestCase {
	@test
	public void testConstructor()
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
		}catch(VidaInvalidaError e)
		{
			assert(true);
		}
	}
	@Test
	public void testQuitarVida()
	{
		Obstaculo Bloque = new BloqueAcero(10);
		Bloque.QuitarVida(5);
		assertTrue(Bloque.vidaRestante() == 5);
	}
	@Test
	public void testBloqueDestruido()
	{
		Obstaculo Bloque = new BloqueAcero(10);
		Bloque.QuitarVida(10);
		assertTrue(Bloque.Destruido());
	}
}
