package modelo.armamentoFactoryTest;

import static org.junit.Assert.assertTrue;
import modelo.ArmamentoFactory.ProyectilFactory;
import modelo.armamento.Armamento;
import modelo.armamento.Proyectil;
import modelo.coordenadas.Coordenada;

import org.junit.Test;


public class ProyectilFactoryTest {
	@Test
	public void testQueChequeaLaContruccionDeUnProyectil(){
		ProyectilFactory proyFac = new ProyectilFactory();
		Coordenada coord = new Coordenada(1,1);
		Armamento proyectil = proyFac.crear(coord);
		assertTrue(proyectil.getClass() == Proyectil.class);
	}
	@Test
	public void testQueCambiaElTiempoAUnProyectil(){
		ProyectilFactory proyFac = new ProyectilFactory();
		proyFac.cambiarTime(4);
		Coordenada coord = new Coordenada(1,1);
		Armamento proyectil = proyFac.crear(coord);
		assertTrue(proyectil.obtenerTime()==4);
	}
}
