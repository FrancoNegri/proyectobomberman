package vista.Armamento;

import java.awt.Graphics;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import vista.fiuba.algo3.titiritero.dibujables.SuperficiePanel;

import static org.mockito.Mockito.*;



import modelo.armamento.Armamento;


public class VistaArmamentoTest {
	
	Armamento arma = mock(Armamento.class);
	VistaArmamento vistaArma;
	Graphics graphics = Mockito.mock(Graphics.class);
	SuperficiePanel unaSuperficie = Mockito.mock(SuperficiePanel.class);
	@Before
	public void SetUp(){
	
		Mockito.when(unaSuperficie.getBuffer()).thenReturn(graphics);
		Mockito.when(arma.getX()).thenReturn(5);
		Mockito.when(arma.getY()).thenReturn(5);
		try {
			vistaArma = new VistaArmamento(arma);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testDibujarArma(){
		vistaArma.dibujar(unaSuperficie);
		Mockito.verify(graphics).setColor(vistaArma.getColor());
		Mockito.verify(graphics).fillOval(arma.getX(), arma.getY(),vistaArma.getRadio(),vistaArma.getRadio());

	}
	
	
}
