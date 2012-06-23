package vista.CasilleroTest;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Graphics;
import java.util.LinkedList;
import modelo.armamento.Armamento;
import modelo.armamento.ToleTole;
import modelo.articulo.Articulo;
import modelo.articulo.Habano;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.obstaculos.BloqueAcero;
import modelo.personaje.Personaje;
import modelo.personaje.enemigos.Cecilio;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import vista.Casillero.VistaCasillero;
import vista.fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import vista.objeto.VistaObjeto;

public class VistaCasilleroTest {
	Graphics graphics = Mockito.mock(Graphics.class);
	SuperficiePanel unaSuperficie = Mockito.mock(SuperficiePanel.class);
	Casillero casillero = mock(Casillero.class);
	Armamento arma = new ToleTole(new Coordenada(1,1),mock(Mapa.class),4);
	Personaje pers = new Cecilio(new Coordenada(1,1),mock(Mapa.class));
	BloqueAcero bloque = new BloqueAcero(new Coordenada(1,1));
	Articulo articulo = new Habano(new Coordenada(1,1));

	@Before
	public void SetUp(){
		Mockito.when(unaSuperficie.getBuffer()).thenReturn(graphics);
		
		arma = spy(arma);
		pers = spy(pers);
		bloque = spy(bloque);
		articulo = spy(articulo);
		
		LinkedList<Personaje> personajes = new LinkedList<Personaje>();
		personajes.add(pers);
		
		when(casillero.obtenerArmamento()).thenReturn(arma);
		when(casillero.obtenerPersonajes()).thenReturn(personajes);
		when(casillero.obtenerArticulo()).thenReturn(articulo);
		when(casillero.obtenerObstaculo()).thenReturn(bloque);
		
	}
	@Test
	public void testVistaMapaDibujar(){
		
		VistaCasillero vistaDelCasillero = new VistaCasillero(casillero);
		vistaDelCasillero.dibujar(unaSuperficie);
		
		verify(arma).getX();
		verify(arma).getY();
		verify(pers).getX();
		verify(pers).getY();
		verify(bloque).getX();
		verify(bloque).getY();
		verify(articulo).getX();
		verify(articulo).getY();
		
	}
	
}
