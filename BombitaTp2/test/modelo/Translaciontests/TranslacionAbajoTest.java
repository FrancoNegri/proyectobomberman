package modelo.Translaciontests;

import static org.mockito.Mockito.*;
import org.junit.Test;
import modelo.Translacion.*;
import modelo.coordenadas.Coordenada;

public class TranslacionAbajoTest {
	@Test
	public void TestQueChequeaLaAccion(){
		Coordenada MiCoordenada = mock(Coordenada.class);
		when(MiCoordenada.obtenerCoordenadaX()).thenReturn(2);
		when(MiCoordenada.obtenerCoordenadaY()).thenReturn(2);
		Translacion trans = new TranslacionAbajo();
		trans.accion(MiCoordenada);
		verify(MiCoordenada,atLeastOnce()).obtenerCoordenadaX();
		}
}
