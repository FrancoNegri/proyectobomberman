package testBloque;
import junit.framework.TestCase;
import Errores.VidaInvalidaError;
import Modelo.BloqueAcero;
import Modelo.Obstaculo;


public class TestBloqueAcero extends TestCase {
	
	public void testConstructor()
	{
		Obstaculo Bloque = new BloqueAcero(10);
		assertEquals(Bloque.vidaRestante(), 10);
	}
	
	
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
	
	public void testQuitarVida()
	{
		Obstaculo Bloque = new BloqueAcero(10);
		Bloque.QuitarVida(5);
		assertTrue(Bloque.vidaRestante() == 5);
	}
	
	public void testBloqueDestruido()
	{
		Obstaculo Bloque = new BloqueAcero(10);
		Bloque.QuitarVida(10);
		assertTrue(Bloque.Destruido());
	}
}
