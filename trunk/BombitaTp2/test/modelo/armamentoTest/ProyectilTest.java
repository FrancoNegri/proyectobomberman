package modelo.armamentoTest;

import static org.mockito.Mockito.*;
import modelo.Translacion.Translacion;
import modelo.armamento.Proyectil;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;

import org.junit.Before;
import org.junit.Test;

public class ProyectilTest {

	Casillero casillero = mock(Casillero.class);
	Coordenada coord = mock(Coordenada.class);
	Mapa mapa = mock(Mapa.class);
	Translacion trans = mock(Translacion.class);
	Proyectil proyectil;
	
	@Before
	public void setUp() throws Exception {
		when(coord.copiar()).thenReturn(coord);
		proyectil = new Proyectil(coord,mapa,trans);
		
	}
	
	@Test
	public void testQueActualizaLaBombaYLaHaceExplotar(){
		Coordenada coordenadaNueva = mock(Coordenada.class);
		when(trans.accion(coord)).thenReturn(coordenadaNueva);
		when(coordenadaNueva.equals(coord)).thenReturn(true);
		when(coord.equals(coordenadaNueva)).thenReturn(true);
		when(mapa.obtenerCasillero((Coordenada)anyObject())).thenReturn(casillero);
		proyectil.vivir();
		verify(mapa,times(4)).obtenerCasillero((Coordenada)anyObject());
	}
	
	

}
