package modelo.armamentoFactoryTest;

import static org.junit.Assert.assertTrue;
import modelo.ArmamentoFactory.ProyectilFactory;
import modelo.Translacion.Translacion;
import modelo.Translacion.TranslacionArriba;
import modelo.armamento.Armamento;
import modelo.armamento.Proyectil;
import modelo.coordenadas.Coordenada;

import org.junit.Test;


public class ProyectilFactoryTest {
	@Test
	public void testQueChequeaLaContruccionDeUnProyectil(){
		ProyectilFactory proyFac = new ProyectilFactory();
		Coordenada coord = new Coordenada(1,1);
		Translacion trans = new TranslacionArriba(); 
		Armamento proyectil = proyFac.crear(coord,trans);
		assertTrue(proyectil.getClass() == Proyectil.class);
	}
}
