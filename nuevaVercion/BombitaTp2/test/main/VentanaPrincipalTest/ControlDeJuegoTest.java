package main.VentanaPrincipalTest;

import javax.swing.JFrame;
import javax.swing.JPanel;
import static org.mockito.Mockito.*;
import main.ControlJuego;

import org.junit.Test;

import vista.fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import vista.fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;


public class ControlDeJuegoTest {

	@Test
	public void testQuePruevaElFuncionamientoDelControlador(){
		JPanel panel = new SuperficiePanel();
		JFrame frame = mock(JFrame.class);
		ControlJuego control = new ControlJuego(panel,frame);
		control.IniciarJuego();
		control.DetenerJuego();
	}
	
	@Test
	public void testQuePruevaElFuncionamientoDelGuardado(){
		JPanel panel = new SuperficiePanel();
		JFrame frame = mock(JFrame.class);
		ControlJuego control = new ControlJuego(panel,frame);
		control.GuardarJuego();
		control.CargarJuego();
	}
	
	
}
