package modelo.armamentoFactoryTest;

import static org.junit.Assert.assertTrue;
import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.ArmamentoFactory.ProyectilFactory;
import modelo.armamento.Armamento;
import modelo.armamento.Proyectil;
import modelo.coordenadas.Coordenada;
import modelo.personaje.Personaje;

import org.junit.Test;
import static org.mockito.Mockito.*;

public class ProyectilFactoryTest {
	@Test
	public void testQueChequeaLaContruccionDeUnProyectil(){
		ArmamentoFactory proyFac = new ProyectilFactory();
		Coordenada coord = new Coordenada(1,1);
		Personaje pers = mock(Personaje.class);
		when(pers.obtenerCoordenadaXY()).thenReturn(coord);
		Armamento proyectil = proyFac.crear(pers);
		assertTrue(proyectil.getClass() == Proyectil.class);
	}
	@Test
	public void testQueCambiaElTiempoAUnProyectil(){
		ArmamentoFactory proyFac = new ProyectilFactory();
		Coordenada coord = new Coordenada(1,1);
		Personaje pers = mock(Personaje.class);
		when(pers.obtenerCoordenadaXY()).thenReturn(coord);
		proyFac.cambiarTime(4);
		Armamento proyectil = proyFac.crear(pers);
		assertTrue(proyectil.obtenerTime()==4);
	}
}
