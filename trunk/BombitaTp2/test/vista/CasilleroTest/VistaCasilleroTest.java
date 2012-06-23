package vista.CasilleroTest;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Graphics;
import java.util.LinkedList;
import modelo.armamento.Armamento;
import modelo.armamento.ToleTole;
import modelo.articulo.Articulo;
import modelo.casillero.Casillero;
import modelo.obstaculos.BloqueAcero;
import modelo.personaje.Personaje;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import vista.Casillero.VistaCasillero;
import vista.fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import vista.objeto.VistaObjeto;

public class VistaCasilleroTest {

	Graphics graphics = Mockito.mock(Graphics.class);
	SuperficiePanel unaSuperficie = Mockito.mock(SuperficiePanel.class);
	Casillero casillero = mock(Casillero.class);
	Armamento arma = mock(ToleTole.class);
	Personaje pers = mock(Personaje.class);
	BloqueAcero bloque = mock(BloqueAcero.class);
	Articulo articulo = mock(Articulo.class);

	@Before
	public void SetUp(){
		Mockito.when(unaSuperficie.getBuffer()).thenReturn(graphics);
		
		when(arma.getX()).thenReturn(4);
		when(arma.getY()).thenReturn(4);
		when(pers.getX()).thenReturn(5);
		when(pers.getY()).thenReturn(5);
		when(bloque.getX()).thenReturn(6);
		when(bloque.getY()).thenReturn(6);
		when(articulo.getX()).thenReturn(7);
		when(articulo.getY()).thenReturn(7);
		
		answers();
		
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
