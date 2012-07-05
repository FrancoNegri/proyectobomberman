package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import control.Teclado.Teclado;
import vista.fiuba.algo3.titiritero.dibujables.SuperficiePanel;

public class VentanaPrincipal {

	private JFrame frame;
	
	public JFrame obtenerFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize() throws IOException {
		// ///////////Inicializacion grafica
		frame = new JFrame("Bombita Rodriguez, The Game - Algortimos y Programacion III - FIUBA");
		Container contenedor = frame.getContentPane();
		frame.setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 770, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		
		// PANEL
		JPanel panel = new SuperficiePanel();
		panel.setBackground(Color.green);
		panel.setBounds(20, 20, 550, 550);
		contenedor.add(panel);
		
		
		// CONTROL DEL JUEGO
		final ControlJuego controlDelJuego = new ControlJuego(panel, null);

		BarraEstado barraEstado = new BarraEstado(contenedor,controlDelJuego);


		// MENU HERRAMIENTAS
		JMenu menuArchivo = new JMenu("Archivo");
		menuArchivo.setForeground(Color.red);
		JMenuItem elementoJugar = new JMenuItem("Jugar");
		elementoJugar.setMnemonic('J');
		menuArchivo.add(elementoJugar);
		elementoJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				controlDelJuego.IniciarJuego();
			}
		});
		
		JMenuItem elementoCargar = new JMenuItem("Cargar");
		elementoCargar.setMnemonic('C');
		menuArchivo.add(elementoCargar);
		elementoCargar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e){
				controlDelJuego.CargarJuego();
			}
		});

		JMenuItem elementoPausar = new JMenuItem("Pausar");
		elementoPausar.setMnemonic('P');
		menuArchivo.add(elementoPausar);
		elementoPausar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				controlDelJuego.DetenerJuego();
			}
		});
		JMenuItem elementoSalir = new JMenuItem("Salir");
		elementoSalir.setMnemonic('S');
		menuArchivo.add(elementoSalir);
		elementoSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				controlDelJuego.terminar();
				System.exit(0);
			}
		});

		JMenu menuAyuda = new JMenu("Ayuda");
		menuAyuda.setForeground(Color.red);
		menuArchivo.setMnemonic('A');

		JMenuItem elementoControles = new JMenuItem("Controles");
		final String informacionControles = "Moverse: Flechas del Teclado \n" 
											+ "Plantar bomba: A\n"
											+ "Ingresar a la salida: Luego de haber matado a todos los enemigos, posicionarse sobre ella";
		elementoControles.setMnemonic('i');
		menuAyuda.add(elementoControles);
		elementoControles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				JOptionPane.showMessageDialog(frame, informacionControles,
						"Controles", JOptionPane.PLAIN_MESSAGE);
			}
		});

		JMenuItem elementoAcerca = new JMenuItem("Acerca de...");
		final String informacion = "              TP2 - Bombita Rodriguez - Algoritmos III\n"
				+ "\n"
				+ "Franco Negri - 93817 - franconegri2004@hotmail.com \n" 
				+ "Francisco Disalvo - 91545 - fran_disa@hotmail.com \n"
				+ "Matias Barro - 92970 - matias.barro@gmail.com \n"
				+ "Federico Di Rocco - 92853 - fede.dirocco@hotmail.com \n"
				+ "\n";
		elementoAcerca.setMnemonic('A');
		menuAyuda.add(elementoAcerca);
		elementoAcerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				JOptionPane.showMessageDialog(frame, informacion, "Acerca de",
						JOptionPane.PLAIN_MESSAGE);
			}
		});

		JMenuBar barra = new JMenuBar();
		barra.setBackground(Color.black);
		frame.setJMenuBar(barra);
		barra.add(menuArchivo);
		barra.add(menuAyuda);

		// BOTONES
		JButton btnIniciar = new JButton("Jugar");
		btnIniciar.setBackground(Color.red);
		btnIniciar.setForeground(Color.white);
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlDelJuego.IniciarJuego();
			}
		});

		btnIniciar.setBounds(600, 220, 130, 25);
		contenedor.add(btnIniciar);

		JButton btnDetener = new JButton("Pausar");
		btnDetener.setBackground(Color.red);
		btnDetener.setForeground(Color.white);
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlDelJuego.DetenerJuego();
			}
		});
		btnDetener.setBounds(600, 260, 130, 25);
		contenedor.add(btnDetener);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.red);
		btnGuardar.setForeground(Color.white);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlDelJuego.GuardarJuego();
			}
		});
		btnGuardar.setBounds(600, 300, 130, 25);
		contenedor.add(btnGuardar);
		
		JButton btnCargar=new JButton("Cargar");
		btnCargar.setBackground(Color.red);
		btnCargar.setForeground(Color.white);
		btnCargar.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				controlDelJuego.CargarJuego();
			}
		});
		btnCargar.setBounds(600, 340, 130, 25);
		contenedor.add(btnCargar);
		
		
		//CONTROLES (TECLADO)
		panel.addKeyListener(new Teclado(controlDelJuego.getBombita()));
		panel.setVisible(true);
		
	};
}
