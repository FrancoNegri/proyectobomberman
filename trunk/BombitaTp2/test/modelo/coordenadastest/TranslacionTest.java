package modelo.coordenadastest;

import modelo.Translacion.Translacion;
import modelo.Translacion.TranslacionAbajo;
import modelo.coordenadas.Coordenada;
import static org.mockito.Mockito.*;
import org.junit.Test;


public class TranslacionTest {
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
