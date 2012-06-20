package modelo.armamentoFactoryTest;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.ArmamentoFactory.ToleToleFactory;
import modelo.armamento.Armamento;
import modelo.armamento.ToleTole;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.Personaje;

import org.junit.Before;
import org.junit.Test;


public class ToleToleFactoryTest {
	Mapa mapa = mock(Mapa.class);
	ArmamentoFactory moloFac = new ToleToleFactory();
	Coordenada coord = new Coordenada(1,1);
	Personaje pers = mock(Personaje.class);
	@Before
	public void SetUp(){
		when(pers.obtenerCoordenadaXY()).thenReturn(coord);
		when(pers.getMapa()).thenReturn(mapa);
	}
	
	@Test
	public void testQueChequeaLaContruccionDeUnaMolotov(){
		Armamento arma = moloFac.crear(pers);
		verify(mapa).agregarAlMapa((Armamento)anyObject());
		assertTrue(arma.getClass()== ToleTole.class);
	}
}
