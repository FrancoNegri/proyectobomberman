package main;

import java.awt.EventQueue;
import javax.swing.JFrame;

import modelo.errores.TiempoInvalidoError;

	public class Main {
		private static JFrame frame;
		
		public static void main(String[] args) {
			new VentanaCargador();
			for (int vuelta=0; vuelta<6; vuelta++) {
				for (float i=0; i<10000000; i++) i = (float) (i + 0.1);
			}
			EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					frame = window.obtenerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		}
}
