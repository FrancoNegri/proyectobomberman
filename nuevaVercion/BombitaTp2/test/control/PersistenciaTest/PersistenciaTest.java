package control.PersistenciaTest;

import java.io.IOException;

import modelo.mapa.Mapa;
import static org.junit.Assert.*;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import control.Persistencia.Persistencia;


public class PersistenciaTest {

	Persistencia persistencia = new Persistencia();
	Mapa mapa = mock(Mapa.class);
	Element elementoMapa = DocumentHelper.createElement("Mapa");
	@Before
	public void SetUp(){
		when(mapa.guardar()).thenReturn(elementoMapa);
	}
	
	@Test
	public void testGuardarElJuego(){
		persistencia.guardar("test/testDeGuardado/test.xml", mapa);
		persistencia.recuperarBombita();
	}
	@Test
	public void testQueRecuperaElJuego(){
		try {
			persistencia.recuperar("test/testDeGuardado/lvl1.xml");
		} catch (IOException e) {
			assertTrue(false);
		}
	}
	
}
