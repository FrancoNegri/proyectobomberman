package main.VentanaPrincipalTest;

import static org.junit.Assert.*;

import java.awt.Container;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import main.BarraEstado;
import main.ControlJuego;
import main.VentanaPrincipal;
import org.junit.Before;
import org.junit.Test;

import vista.fiuba.algo3.titiritero.dibujables.SuperficiePanel;

public class BarraEstadoTest {
	
	BarraEstado barra;
	Container cont;
	ControlJuego contr;
	JPanel panel;
	JFrame frame;
	
	@Before
	public void setUp() throws Exception {
		panel = new SuperficiePanel();
		frame = new JFrame();
		cont = frame.getContentPane();
		contr = new ControlJuego(panel,frame);
	}
	
	@Test
	public void testBarraEstado(){
		try{
			barra = new BarraEstado(panel,null);
		}catch(Exception e){
			assertTrue(true);
		}
		
		
	}
}
