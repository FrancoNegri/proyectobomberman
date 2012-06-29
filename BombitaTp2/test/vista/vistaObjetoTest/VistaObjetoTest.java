package vista.vistaObjetoTest;

import static org.mockito.Mockito.mock;

import java.awt.Graphics;
import modelo.casillero.Casillero;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import vista.fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import vista.objeto.ObjetoVisible;
import vista.objeto.VistaObjeto;


public class VistaObjetoTest {

	
	Graphics graphics = Mockito.mock(Graphics.class);
	SuperficiePanel unaSuperficie = Mockito.mock(SuperficiePanel.class);
	Casillero casilleroMock = mock(Casillero.class);
	ObjetoPosicionable objeto = Mockito.mock(ObjetoPosicionable.class);
	@Before
	public void SetUp(){
		Mockito.when(unaSuperficie.getBuffer()).thenReturn(graphics);
		Mockito.when(objeto.getX()).thenReturn(5);
		Mockito.when(objeto.getY()).thenReturn(5);

	}
	
	@Test
	public void testQuePruevaLaVistaDeCecilio(){
		VistaObjeto vistaO = new VistaObjeto(mock(ObjetoVisible.class));
		vistaO.interactuarConCecilio(objeto);
		vistaO.dibujar(unaSuperficie);
		//A Determinar
		//Mockito.verify(graphics).setColor(circulo.getColor());
		//Mockito.verify(graphics).fillOval(objeto.getX()*5, objeto.getY()*5, circulo.getRadio(), circulo.getRadio());
	}
	
	@Test
	public void testQuePruevaLaVistaDeBombita(){
		VistaObjeto vistaO = new VistaObjeto(mock(ObjetoVisible.class));
		vistaO.InteractuarConBombita(objeto);
		vistaO.dibujar(unaSuperficie);
		//A Determinar
		//Mockito.verify(graphics).setColor(circulo.getColor());
		//Mockito.verify(graphics).fillOval(objeto.getX()*5, objeto.getY()*5, circulo.getRadio(), circulo.getRadio());
	}
	
	@Test
	public void testQuePruevaLaVistaDeLopezComun(){
		VistaObjeto vistaO = new VistaObjeto(mock(ObjetoVisible.class));
		vistaO.InteractuarConLopezComun(objeto);
		vistaO.dibujar(unaSuperficie);
		//A Determinar
		//Mockito.verify(graphics).setColor(circulo.getColor());
		//Mockito.verify(graphics).fillOval(objeto.getX()*5, objeto.getY()*5, circulo.getRadio(), circulo.getRadio());
	}
	
	@Test
	public void testQuePruevaLaVistaDeLopezAlado(){
		VistaObjeto vistaO = new VistaObjeto(mock(ObjetoVisible.class));
		vistaO.InteractuarConLopezAlado(objeto);
		vistaO.dibujar(unaSuperficie);
		//A Determinar
		//Mockito.verify(graphics).setColor(circulo.getColor());
		//Mockito.verify(graphics).fillOval(objeto.getX()*5, objeto.getY()*5, circulo.getRadio(), circulo.getRadio());
	}
	
	@Test
	public void testQuePruevaLaVistaDelToleTole(){
		VistaObjeto vistaO = new VistaObjeto(mock(ObjetoVisible.class));
		vistaO.InteractuarConToleTole(objeto);
		vistaO.dibujar(unaSuperficie);
		//A Determinar
		//Mockito.verify(graphics).setColor(circulo.getColor());
		//Mockito.verify(graphics).fillOval(objeto.getX()*5, objeto.getY()*5, circulo.getRadio(), circulo.getRadio());
	}
	
	@Test
	public void testQuePruevaLaVistaDelProyectil(){
		VistaObjeto vistaO = new VistaObjeto(mock(ObjetoVisible.class));
		vistaO.InteractuarConProyectil(objeto);
		vistaO.dibujar(unaSuperficie);
		//A Determinar
		//Mockito.verify(graphics).setColor(circulo.getColor());
		//Mockito.verify(graphics).fillOval(objeto.getX()*5, objeto.getY()*5, circulo.getRadio(), circulo.getRadio());
	}
	
	@Test
	public void testQuePruevaLaVistaDelMolotov(){
		VistaObjeto vistaO = new VistaObjeto(mock(ObjetoVisible.class));
		vistaO.InteractuarConMolotov(objeto);
		vistaO.dibujar(unaSuperficie);
		//A Determinar
		//Mockito.verify(graphics).setColor(circulo.getColor());
		//Mockito.verify(graphics).fillOval(objeto.getX()*5, objeto.getY()*5, circulo.getRadio(), circulo.getRadio());
	}
	
	@Test
	public void testQuePruevaLaVistaDeHabano(){
		VistaObjeto vistaO = new VistaObjeto(mock(ObjetoVisible.class));
		vistaO.InteractuarConHabano(objeto);
		vistaO.dibujar(unaSuperficie);
		//A Determinar
		//Mockito.verify(graphics).setColor(circulo.getColor());
		//Mockito.verify(graphics).fillOval(objeto.getX()*5, objeto.getY()*5, circulo.getRadio(), circulo.getRadio());
	}
	
	@Test
	public void testQuePruevaLaVistaDelTimer(){
		VistaObjeto vistaO = new VistaObjeto(mock(ObjetoVisible.class));
		vistaO.InteractuarTimer(objeto);
		vistaO.dibujar(unaSuperficie);
		//A Determinar
		//Mockito.verify(graphics).setColor(circulo.getColor());
		//Mockito.verify(graphics).fillOval(objeto.getX()*5, objeto.getY()*5, circulo.getRadio(), circulo.getRadio());
	}
	
	@Test
	public void testQuePruevaLaVistaDelBloqueCemento(){
		VistaObjeto vistaO = new VistaObjeto(mock(ObjetoVisible.class));
		vistaO.InteractuarConBloqueCemento(objeto);
		vistaO.dibujar(unaSuperficie);
		//A Determinar
		//Mockito.verify(graphics).setColor(circulo.getColor());
		//Mockito.verify(graphics).fillOval(objeto.getX()*5, objeto.getY()*5, circulo.getRadio(), circulo.getRadio());
	}
	
	@Test
	public void testQuePruevaLaVistaDelBloqueAcero(){
		VistaObjeto vistaO = new VistaObjeto(mock(ObjetoVisible.class));
		vistaO.InteractuarConBloqueAcero(objeto);
		vistaO.dibujar(unaSuperficie);
		//A Determinar
		//Mockito.verify(graphics).setColor(circulo.getColor());
		//Mockito.verify(graphics).fillOval(objeto.getX()*5, objeto.getY()*5, circulo.getRadio(), circulo.getRadio());
	}
	
	@Test
	public void testQuePruevaLaVistaDelBloqueLadrillo(){
		VistaObjeto vistaO = new VistaObjeto(mock(ObjetoVisible.class));
		vistaO.InteractuarConBloqueLadrillo(objeto);
		vistaO.dibujar(unaSuperficie);
		//A Determinar
		//Mockito.verify(graphics).setColor(circulo.getColor());
		//Mockito.verify(graphics).fillOval(objeto.getX()*5, objeto.getY()*5, circulo.getRadio(), circulo.getRadio());
	}
	
	@Test
	public void testQuePruevaLaVistaDelFuegoDeExplocion(){
		VistaObjeto vistaO = new VistaObjeto(mock(ObjetoVisible.class));
		vistaO.InteractuarConFuegoDeExplocion(objeto);
		vistaO.dibujar(unaSuperficie);
		//A Determinar
		//Mockito.verify(graphics).setColor(circulo.getColor());
		//Mockito.verify(graphics).fillOval(objeto.getX()*5, objeto.getY()*5, circulo.getRadio(), circulo.getRadio());
	}
	
	
}
