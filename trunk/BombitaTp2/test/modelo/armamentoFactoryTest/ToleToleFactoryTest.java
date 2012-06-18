package modelo.armamentoFactoryTest;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import modelo.ArmamentoFactory.ToleToleFactory;
import modelo.armamento.Armamento;
import modelo.armamento.ToleTole;
import modelo.coordenadas.Coordenada;
import modelo.personaje.Personaje;

import org.junit.Test;


public class ToleToleFactoryTest {
	@Test
	public void testQueChequeaLaContruccionDeUnToleTole(){
		ToleToleFactory ToleFac = new ToleToleFactory();
		Coordenada coord = new Coordenada(1,1);
		Personaje pers = mock(Personaje.class);
		when(pers.obtenerCoordenadaXY()).thenReturn(coord);
		Armamento tole = ToleFac.crear(pers);
		assertTrue(tole.getClass() == ToleTole.class);
	}
	@Test
	public void testQueCambiaElTiempoAUnToleTole(){
		ToleToleFactory ToleFac = new ToleToleFactory();
		ToleFac.cambiarTime(4);
		Coordenada coord = new Coordenada(1,1);
		Personaje pers = mock(Personaje.class);
		when(pers.obtenerCoordenadaXY()).thenReturn(coord);
		Armamento tole = ToleFac.crear(pers);
		assertTrue(tole.obtenerTime()==4);
	}
}
