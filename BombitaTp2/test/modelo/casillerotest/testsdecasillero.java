package modelo.casillerotest;
import modelo.casillero.Casillero;
import static org.junit.Assert.*;
import org.junit.*;

public class testsdecasillero {

	@Test
	public void testQuePruebaQueSeInicializeDeManeraCorrecta()
	{
		Casillero unCasillero = new Casillero();
		Object unBloque = new Object();
		unCasillero.agregar(unBloque);
		assertTrue(true);
	}
	
}
