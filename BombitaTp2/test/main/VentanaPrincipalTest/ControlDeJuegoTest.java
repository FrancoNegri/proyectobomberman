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
	public void TestQuePruevaElFuncionamientoDelControlador(){
		JPanel panel = new SuperficiePanel();
		JFrame frame = mock(JFrame.class);
		ControlJuego control = new ControlJuego(panel,frame);
		control.IniciarJuego();
		control.DetenerJuego();
	}
	
	@Test
	public void TestQuePruevaElFuncionamientoDelGuardado(){
		JPanel panel = new SuperficiePanel();
		JFrame frame = mock(JFrame.class);
		ControlJuego control = new ControlJuego(panel,frame);
		control.GuardarJuego();
		control.CargarJuego();
	}
	
	
	@Test
	public void TestDondeBombitaTiraBombasYseMueve(){
		JPanel panel = new SuperficiePanel();
		JFrame frame = mock(JFrame.class);
		ControlJuego control = new ControlJuego(panel,frame);
		control.moverBombitaAbajo();
		control.ataqueDeBombita();
		control.moverBombitaArriba();
		control.moverBombitaIzquierda();
		control.moverBombitaDerecha();
		control.ataqueDeBombita();
		control.IniciarJuego();
		control.DetenerJuego();
	}
	
	
	
}
