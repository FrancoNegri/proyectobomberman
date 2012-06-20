package modelo.armamentoFactoryTest;

import static org.junit.Assert.assertTrue;
import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.ArmamentoFactory.ProyectilFactory;
import modelo.armamento.Armamento;
import modelo.armamento.Molotov;
import modelo.armamento.Proyectil;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.Personaje;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

public class ProyectilFactoryTest {
	
	Mapa mapa = mock(Mapa.class);
	ArmamentoFactory moloFac = new ProyectilFactory();
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
		verify(mapa).agregarAlMapa((Molotov)anyObject());
		assertTrue(arma.getClass()== Proyectil.class);
	}
	
}
