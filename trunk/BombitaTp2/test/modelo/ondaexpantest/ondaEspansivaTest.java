package modelo.ondaexpantest;
import org.junit.Before;
import org.junit.Test;

import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.obstaculos.BloqueCemento;
import modelo.ondaexpansiva.OndaExpansiva;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ondaEspansivaTest {
	
	private OndaExpansiva onda;
	private Mapa mapa;
	@Before
	public void setUp(){
		onda = new OndaExpansiva(2,2);
	}
	@Test
	public void testQueVerificaLaExplocionDeLaBombaConMocks(){
		//Uso Mocks Para Testear Comportamiento
		BloqueCemento bloque = mock(BloqueCemento.class);
		Coordenada cord1 = new Coordenada(2,2);
		Coordenada cord2 = new Coordenada(1,2);
		Coordenada cord3 = new Coordenada(3,2);
		Coordenada cord4 = new Coordenada(2,1);
		Coordenada cord5 = new Coordenada(2,3);
		when(bloque.obtenerCoordenadaXY()).thenReturn(cord1).thenReturn(cord2).thenReturn(cord3).thenReturn(cord4).thenReturn(cord5);
		//agrego algo de comportamiento para que pasen los tests
		
		//creo coordenadas
		//agrego los casilleros fake a un mapa
		mapa = new Mapa(4);
		mapa.agregarAlMapa(bloque);
		mapa.agregarAlMapa(bloque);
		mapa.agregarAlMapa(bloque);
		mapa.agregarAlMapa(bloque);
		mapa.agregarAlMapa(bloque);
		//Testeo
		cord1 = new Coordenada(2,2);
		onda.Expandirse(cord1,mapa);
		verify(bloque,times(4)).Daniar(anyInt());
	}
	@Test
	public void testQueVerificaLaExplocionDeLaBombasinMocksEnElMedio(){
		try{
			mapa = new Mapa(4);
			Coordenada cord1 = new Coordenada(2,2);
			onda.Expandirse(cord1,mapa);
		}catch(Exception e){
			assertTrue(false);
		}
	}
	@Test
	public void testQueVerificaLaExplocionDeLaBombasinMocksEnUnLateral(){
		try{
			mapa = new Mapa(4);
			Coordenada cord1 = new Coordenada(1,1);
			onda.Expandirse(cord1,mapa);
		}catch(Exception e){
			assertTrue(false);
		}
	}
}
