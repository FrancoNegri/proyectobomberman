package modelo.armamentoFactoryTest;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.ArmamentoFactory.MolotovFactory;
import modelo.armamento.Armamento;
import modelo.armamento.Molotov;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.Personaje;

import org.junit.Before;
import org.junit.Test;

public class MolovFactoryTest {
	
	Mapa mapa = mock(Mapa.class);
	ArmamentoFactory moloFac = new MolotovFactory();
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
		assertTrue(arma.getClass()== Molotov.class);
	}
}
