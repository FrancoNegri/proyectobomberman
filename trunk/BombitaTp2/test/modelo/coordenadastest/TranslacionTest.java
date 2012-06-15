package modelo.coordenadastest;

import modelo.coordenadas.Coordenada;
import modelo.coordenadas.Translacion;
import static org.mockito.Mockito.*;
import org.junit.Test;


public class TranslacionTest {
	@Test
	public void TestQueChequeaLaAccion(){
	Coordenada MiCoordenada = mock(Coordenada.class);
	when(MiCoordenada.obtenerCoordenadaX()).thenReturn(2);
	when(MiCoordenada.obtenerCoordenadaY()).thenReturn(2);
	Translacion trans = new Translacion(true,false,false,false);
	trans.accion(MiCoordenada);
	verify(MiCoordenada,atLeastOnce()).obtenerCoordenadaX();
	}
}
