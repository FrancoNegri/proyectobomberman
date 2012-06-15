package modelo.ondaexpantest;
import org.junit.Before;
import org.junit.Test;

import modelo.casillero.Casillero;
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
		
		mapa = mock(Mapa.class);///Creo un Mapita Falzo para que pueda Testear
		when(mapa.obtenerCasillero(2,2)).thenReturn(casilleroVacio);
		when(mapa.obtenerCasillero(1,2)).thenReturn(casilleroOcupado);
		when(mapa.obtenerCasillero(3,2)).thenReturn(casilleroOcupado);
		when(mapa.obtenerCasillero(2,1)).thenReturn(casilleroOcupado);
		when(mapa.obtenerCasillero(2,3)).thenReturn(casilleroOcupado);
	}
	@Test
	public void testQueVerificaLaExplocionDeLaBomba(){
		onda.Expandirse(2,2,mapa);
	}

}
