package modelo.armamentoFactoryTest;

import static org.junit.Assert.assertTrue;
import modelo.ArmamentoFactory.ToleToleFactory;
import modelo.armamento.Armamento;
import modelo.armamento.ToleTole;
import modelo.coordenadas.Coordenada;

import org.junit.Test;


public class ToleToleFactoryTest {
	@Test
	public void testQueChequeaLaContruccionDeUnToleTole(){
		ToleToleFactory ToleFac = new ToleToleFactory();
		Coordenada coord = new Coordenada(1,1);
		Armamento tole = ToleFac.crear(coord);
		assertTrue(tole.getClass() == ToleTole.class);
	}
	@Test
	public void testQueCambiaElTiempoAUnProyectil(){
		ToleToleFactory ToleFac = new ToleToleFactory();
		ToleFac.cambiarTime(4);
		Coordenada coord = new Coordenada(1,1);
		Armamento tole = ToleFac.crear(coord);
		assertTrue(tole.obtenerTime()==4);
	}
}
