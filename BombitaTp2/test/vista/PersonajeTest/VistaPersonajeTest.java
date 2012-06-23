package vista.PersonajeTest;

import java.awt.Graphics;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import vista.Personaje.vistaPersonaje;
import vista.fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import modelo.personaje.Personaje;
import static org.mockito.Mockito.*;

public class VistaPersonajeTest {

	
	Personaje personaje = mock(Personaje.class);
	vistaPersonaje vistaDelPersonaje;
	Graphics graphics = Mockito.mock(Graphics.class);
	SuperficiePanel unaSuperficie = Mockito.mock(SuperficiePanel.class);
	@Before
	public void SetUp(){
		
		Mockito.when(unaSuperficie.getBuffer()).thenReturn(graphics);
		Mockito.when(personaje.getX()).thenReturn(5);
		Mockito.when(personaje.getY()).thenReturn(5);
		try {
			vistaDelPersonaje = new vistaPersonaje(personaje);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDibujarPersonaje(){
		vistaDelPersonaje.dibujar(unaSuperficie);
		Mockito.verify(graphics).setColor(vistaDelPersonaje.getColor());
		Mockito.verify(graphics).fillRect(personaje.getX(), personaje.getY(),10,10);
	}
	
}
