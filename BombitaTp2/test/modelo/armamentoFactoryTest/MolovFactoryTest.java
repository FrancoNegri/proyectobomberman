package modelo.armamentoFactoryTest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.ArmamentoFactory.MolotovFactory;
import modelo.armamento.Armamento;
import modelo.armamento.Molotov;
import modelo.coordenadas.Coordenada;
import modelo.personaje.Personaje;

import org.junit.Test;

public class MolovFactoryTest {

	@Test
	public void testQueChequeaLaContruccionDeUnaMolotov(){
		ArmamentoFactory moloFac = new MolotovFactory();
		Coordenada coord = new Coordenada(1,1);
		Personaje pers = mock(Personaje.class);
		when(pers.obtenerCoordenadaXY()).thenReturn(coord);
		Armamento molo = moloFac.crear(pers);
		assertTrue(molo.getClass()==Molotov.class);
	}
	@Test
	public void testQueCambiaElTiempoAUnaMolotov(){
		MolotovFactory moloFac = new MolotovFactory();
		moloFac.cambiarTime(4);
		Coordenada coord = new Coordenada(1,1);
		Personaje pers = mock(Personaje.class);
		when(pers.obtenerCoordenadaXY()).thenReturn(coord);
		Armamento molo = moloFac.crear(pers);
		assertTrue(molo.obtenerTime()==4);
	}
}
