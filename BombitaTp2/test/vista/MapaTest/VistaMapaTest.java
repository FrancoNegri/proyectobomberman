package vista.MapaTest;
import static org.mockito.Mockito.*;
import java.util.LinkedList;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.Personaje;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import vista.Mapa.VistaMapa;
import vista.fiuba.algo3.titiritero.dibujables.SuperficiePanel;

public class VistaMapaTest {
	
	Mapa mapa = mock(Mapa.class);
	VistaMapa vistaMapa;
	SuperficiePanel unaSuperficie = Mockito.mock(SuperficiePanel.class);
	Casillero casilleroMock = mock(Casillero.class);
	@Before
	public void SetUp(){
		when(casilleroMock.obtenerPersonajes()).thenReturn(new LinkedList<Personaje>());
		when(mapa.obtenerTamanio()).thenReturn(4);
		when(mapa.obtenerCasillero((Coordenada)anyObject())).thenReturn(casilleroMock);
		
		
		vistaMapa = new VistaMapa(mapa);
	}
	@Test
	public void testVistaMapaDibujar(){
		vistaMapa.dibujar(unaSuperficie);
		verify(casilleroMock,times(16)).obtenerArmamento();
		verify(casilleroMock,times(16)).obtenerArticulo();
		verify(casilleroMock,times(16)).obtenerPersonajes();
		verify(casilleroMock,times(16)).obtenerObstaculo();
	}
	
}
