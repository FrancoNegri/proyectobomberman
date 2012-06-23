package vista.ArticuloTest;

import java.awt.Graphics;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import vista.Articulo.VistaArticulo;
import vista.fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import modelo.articulo.Articulo;
import static org.mockito.Mockito.*;

public class ArticuloTest {
	Articulo articulo = mock(Articulo.class);
	VistaArticulo vistaDelArmamento;
	Graphics graphics = Mockito.mock(Graphics.class);
	SuperficiePanel unaSuperficie = Mockito.mock(SuperficiePanel.class);
	@Before
	public void SetUp(){
		
		Mockito.when(unaSuperficie.getBuffer()).thenReturn(graphics);
		Mockito.when(articulo.getX()).thenReturn(5);
		Mockito.when(articulo.getY()).thenReturn(5);
		vistaDelArmamento = new VistaArticulo(articulo);
	}
	
	@Test
	public void testDibujarPersonaje(){
		vistaDelArmamento.dibujar(unaSuperficie);
		Mockito.verify(graphics).setColor(vistaDelArmamento.getColor());
		Mockito.verify(graphics).fillRect(articulo.getX()*5, articulo.getY()*5,10,4);
	}
	
}
