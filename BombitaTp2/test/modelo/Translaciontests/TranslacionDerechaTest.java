package modelo.Translaciontests;


import modelo.Translacion.Translacion;
import modelo.Translacion.TranslacionDerecha;
import modelo.coordenadas.Coordenada;
import static org.mockito.Mockito.*;
import org.junit.Test;


public class TranslacionDerechaTest {
	@Test
	public void TestQueChequeaLaAccion(){
	Coordenada MiCoordenada = mock(Coordenada.class);
	when(MiCoordenada.obtenerCoordenadaX()).thenReturn(2);
	when(MiCoordenada.obtenerCoordenadaY()).thenReturn(2);
	Translacion trans = new TranslacionDerecha();
	trans.accion(MiCoordenada);
	verify(MiCoordenada,atLeastOnce()).obtenerCoordenadaX();
	}
}
