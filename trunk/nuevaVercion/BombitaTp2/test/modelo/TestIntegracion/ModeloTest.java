package modelo.TestIntegracion;

import modelo.Level.Level;

import org.junit.Test;


public class ModeloTest {
	
	@Test
	 public void testJuego(){
		Level level = new Level();
		level.Crear();
		level.run();
	}
	
}
