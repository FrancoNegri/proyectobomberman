package modelo.armamentoTest;

import static org.junit.Assert.*;
import modelo.armamento.Armamento;
import modelo.personaje.*;
import modelo.armamento.ToleTole;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import java.util.LinkedList;

public class ArmamentoTest {

	
	Coordenada coordenada;
	Mapa mapa;
	Armamento arma;
	Casillero casilleroADañar = mock(Casillero.class);
	@Before
	public void SetUp(){
		coordenada = new Coordenada(1,2);
		mapa = mock(Mapa.class);
		arma = new ToleTole(coordenada,mapa,4);
		when(casilleroADañar.obtenerPersonajes()).thenReturn(new LinkedList<Personaje>());
		when(casilleroADañar.obtenerObstaculo()).thenReturn(null);
		when(casilleroADañar.esAtacable()).thenReturn(true);
		when(mapa.obtenerCasillero((Coordenada)anyObject())).thenReturn(casilleroADañar);
	}
	
	
	@Test
	public void testCambiarEltiempo(){
		
		arma.cambiarTime(4);
		assertTrue(arma.obtenerTime()==4);
	}
	
	@Test
	public void testActualizarLaBomba(){
		while(arma.obtenerTime() >= 0){
			arma.actualizar();
		}
		arma.actualizar();
		verify(casilleroADañar,times(4)).obtenerPersonajes();
		verify(casilleroADañar,times(4)).obtenerObstaculo();
	}
	
}
