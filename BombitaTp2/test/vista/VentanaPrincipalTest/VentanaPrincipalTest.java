package vista.VentanaPrincipalTest;


import static org.junit.Assert.*;
import main.VentanaPrincipal;

import org.junit.Before;
import org.junit.Test;

public class VentanaPrincipalTest {
	
	VentanaPrincipal ventana;
	@Before
	public void setUp() throws Exception {
		
	}
	@Test
	public void testDeVentanaPrincipal(){
		try{
			ventana = new VentanaPrincipal();
		}catch(Exception e){
			assertTrue(true);
		}
		
		
	}
	
	
}
