package vista.fiuba.algo3.titiritero.dibujables;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.junit.Test;
import org.mockito.Mockito;

import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

@SuppressWarnings("unused")
public class ImagenTest {
//<copy file="test/res/imagen.png" tofile="${build}/tests/res/imagen.png"/>
	@Test
	public void testDibujar() throws IOException {
		Graphics graphics = Mockito.mock(Graphics.class);
		SuperficiePanel unaSuperficie = Mockito.mock(SuperficiePanel.class);
		Mockito.when(unaSuperficie.getBuffer()).thenReturn(graphics);
		ObjetoPosicionable objeto = Mockito.mock(ObjetoPosicionable.class);
		Mockito.when(objeto.getX()).thenReturn(5);
		Mockito.when(objeto.getY()).thenReturn(5);
		URL imagenUrl = this.getClass().getResource("/res/imagen.png");
	    System.out.println(imagenUrl);

		Imagen imagen = new Imagen(imagenUrl, objeto);
		imagen.dibujar(unaSuperficie);
		Mockito.verify(graphics).drawImage(Mockito.any(BufferedImage.class), Mockito.eq(5*13), Mockito.eq(5*13), Mockito.isNull(ImageObserver.class));
	}

}
