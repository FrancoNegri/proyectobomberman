package main.VentanaPrincipalTest;

import static org.junit.Assert.*;
import main.VentanaCargador;
import org.junit.Before;
import org.junit.Test;

public class VentanaCargadorTest {
	
	VentanaCargador ventana;
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testVentanaCargador(){
		try{
			ventana = new VentanaCargador();
		}catch(Exception e){
			assertTrue(false);
		}
		
	}
}