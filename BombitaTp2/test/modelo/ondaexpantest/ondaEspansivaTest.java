package modelo.ondaexpantest;
import org.junit.Before;
import org.junit.Test;

import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.ondaexpansiva.OndaExpansiva;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ondaEspansivaTest {
	
	private OndaExpansiva onda;
	private Mapa mapa;
	private Casillero casilleroVacio;
	private Casillero casilleroOcupado;
	@Before
	public void setUp(){
		onda = new OndaExpansiva(2,2);
	}
	@Test
	public void testQueVerificaLaExplocionDeLaBombaConMocks(){
		//Uso Mocks Para Testear Comportamiento
		casilleroVacio = mock(Casillero.class);
		casilleroOcupado = mock(Casillero.class);
		//agrego algo de comportamiento para que pasen los tests
		when(casilleroVacio.esAtacable()).thenReturn(false);
		when(casilleroOcupado.esAtacable()).thenReturn(true);
		//creo coordenadas
		Coordenada cord1 = new Coordenada(2,2);
		Coordenada cord2 = new Coordenada(1,2);
		Coordenada cord3 = new Coordenada(3,2);
		Coordenada cord4 = new Coordenada(2,1);
		Coordenada cord5 = new Coordenada(2,3);
		//agrego los casilleros fake a un mapa
		mapa = new Mapa(4);
		mapa.agregarCasillero(cord1, casilleroVacio);
		mapa.agregarCasillero(cord2, casilleroOcupado);
		mapa.agregarCasillero(cord3, casilleroOcupado);
		mapa.agregarCasillero(cord4, casilleroOcupado);
		mapa.agregarCasillero(cord5, casilleroOcupado);
		//Testeo
		cord1 = new Coordenada(2,2);
		onda.Expandirse(cord1,mapa);
		verify(casilleroOcupado,times(4)).esAtacable();
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
