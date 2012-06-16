package modelo.Translaciontests;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import modelo.Translacion.Translacion;
import modelo.Translacion.TranslacionArriba;
import modelo.coordenadas.Coordenada;

import org.junit.Test;


public class TranslacionArribaTest {
	@Test
	public void TestQueChequeaLaAccion(){
	Coordenada MiCoordenada = mock(Coordenada.class);
	when(MiCoordenada.obtenerCoordenadaX()).thenReturn(2);
	when(MiCoordenada.obtenerCoordenadaY()).thenReturn(2);
	Translacion trans = new TranslacionArriba();
	trans.accion(MiCoordenada);
	verify(MiCoordenada,atLeastOnce()).obtenerCoordenadaX();
	}
}
