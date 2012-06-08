package modelo.bloquetest;

import modelo.errores.VidaInvalidaError;
import modelo.obstaculos.*;
import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.*;

public class testBloqueAcero{
	@Test
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
