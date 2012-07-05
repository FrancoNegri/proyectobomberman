package main;

import java.awt.EventQueue;
import javax.swing.JFrame;

	public class Main {
		private static JFrame frame;
		public static void main(String[] args) {
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
