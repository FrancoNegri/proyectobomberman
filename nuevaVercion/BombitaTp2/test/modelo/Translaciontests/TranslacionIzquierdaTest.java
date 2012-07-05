package modelo.Translaciontests;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import modelo.Translacion.*;
import modelo.coordenadas.Coordenada;

import org.dom4j.Element;
import org.junit.Test;


public class TranslacionIzquierdaTest {
	@Test
	public void TestQueChequeaLaAccion(){
	Coordenada MiCoordenada = mock(Coordenada.class);
	when(MiCoordenada.obtenerCoordenadaX()).thenReturn(2);
	when(MiCoordenada.obtenerCoordenadaY()).thenReturn(2);
	Translacion trans = new TranslacionIzquierda();
	trans.accion(MiCoordenada);
	verify(MiCoordenada,atLeastOnce()).obtenerCoordenadaX();
	}
	@Test
	public void TestQueGuardaLaTranslacion(){
		Translacion trans = new TranslacionIzquierda();
		Element elem = trans.guardar();
		assertTrue(elem.getName() == "TranslacionIzquierda");
	}
}
