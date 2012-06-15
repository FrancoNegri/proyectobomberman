package modelo.ondaexpantest;
import org.junit.Before;
import org.junit.Test;

import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.ondaexpansiva.OndaExpansiva;
import static org.mockito.Mockito.*;

public class ondaEspansivaTest {
	
	private OndaExpansiva onda;
	private Mapa mapa;
	private Casillero casilleroVacio;
	private Casillero casilleroOcupado;
	@Before
	public void setUp(){
		onda = new OndaExpansiva(2,2);
		//Uso Mocks Para Testear Comportamiento
		casilleroVacio = mock(Casillero.class);
		casilleroOcupado = mock(Casillero.class);
		when(casilleroVacio.estaVacio()).thenReturn(true);
		when(casilleroOcupado.estaVacio()).thenReturn(false);
		Coordenada cord1 = new Coordenada(2,2);
		Coordenada cord2 = new Coordenada(1,2);
		Coordenada cord3 = new Coordenada(3,2);
		Coordenada cord4 = new Coordenada(2,1);
		Coordenada cord5 = new Coordenada(2,3);
		mapa = new Mapa(4);
		mapa.agregarCasillero(cord1, casilleroVacio);
		mapa.agregarCasillero(cord2, casilleroOcupado);
		mapa.agregarCasillero(cord3, casilleroOcupado);
		mapa.agregarCasillero(cord4, casilleroOcupado);
		mapa.agregarCasillero(cord5, casilleroOcupado);
	}
	@Test
	public void testQueVerificaLaExplocionDeLaBomba(){
		Coordenada cord1 = new Coordenada(2,2);
		onda.Expandirse(cord1,mapa);
	}
	

}
