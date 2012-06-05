package modelo.personajetest;

import static org.junit.Assert.*;
import org.junit.*;

import modelo.personajes.bombita.Bombita;

public class BombitaTest {
	
	private Bombita rodriguez;
	
	@Before
	public void setUp(){
		rodriguez = new Bombita();
	}

	@Test
	public void testInicializarVelocidad() {
		assertTrue(rodriguez.getVelocidad() == 5);
	}
	
	@Test
	public void testInicializarVida() {
		assertTrue(rodriguez.getVida() == 100);
	}
	
	@Test
	public void testRestarVida() {
		rodriguez.restarVida(10);
		assertTrue(rodriguez.getVida() == 90);
	}
	
	@Test
	public void testSinVida() {
		rodriguez.restarVida(100);
		assertTrue(rodriguez.estaMuerto() == true);
	}
}
