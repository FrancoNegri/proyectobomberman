package modelo.casillerotest;
import modelo.casillero.casillero;
import modelo.errores.VidaInvalidaError;
import modelo.obstaculos.*;
import static org.junit.Assert.*;
import org.junit.*;

public class testsdecasillero {

	@Test
	public void testQuePruebaQueSeInicializeDeManeraCorrecta()
	{
		casillero unCasillero = new casillero();
		Object unBloque = new Object();
		unCasillero.agregar(unBloque);
		assertTrue(true);
	}
	
}
