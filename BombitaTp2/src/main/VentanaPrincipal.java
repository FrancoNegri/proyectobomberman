package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JPopupMenu;

import control.Persistencia.Persistencia;
import control.Teclado.Teclado;
import modelo.armamento.Armamento;
import modelo.armamento.ToleTole;
import modelo.articulo.Articulo;
import modelo.articulo.Habano;
//import modelo.bombitatest.BombitaTest;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.obstaculos.BloqueAcero;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Bombita;
import modelo.personaje.Personaje;
import modelo.personaje.enemigos.Cecilio;
import modelo.personaje.enemigos.LopezComun;
import vista.Mapa.VistaMapa;
import vista.fiuba.algo3.titiritero.dibujables.Circulo;
import vista.fiuba.algo3.titiritero.dibujables.Figura;
import vista.fiuba.algo3.titiritero.dibujables.Imagen;
import vista.fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import vista.fiuba.algo3.titiritero.modelo.GameLoop;
import vista.fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

@SuppressWarnings("unused")
public class VentanaPrincipal {

	private JFrame frame;
	private JLabel labelPts, labelVida, labelVel, labelNiv, labelImg;
	
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
		frame = new JFrame("Bombita Rodriguez - Algortimos y ProgramacionIII - FIUBA ©");
		Container contenedor = frame.getContentPane();
		frame.setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
	
		
		// PANEL
		JPanel panel = new SuperficiePanel();
		panel.setBackground(Color.green);
		panel.setBounds(20, 20, 550, 550);
		contenedor.add(panel);
		
		
		// CONTROL DEL JUEGO
		final ControlJuego controlDelJuego = new ControlJuego(panel);
		
		
		// LABELS 
		int puntajeMapa = controlDelJuego.obtenerPuntajeArea();
		float velocidadBombita = controlDelJuego.obtenerVelocidadArea();
		labelPts = new JLabel("Puntos: "+ puntajeMapa);
		labelPts.setBounds(600, 21, 100, 50);
		labelVida = new JLabel("Vida: "+ (controlDelJuego.obtenerVidaArea()));
		labelVida.setBounds(600, 37, 100, 50);
		labelVel = new JLabel("Velocidad: "+ velocidadBombita);
		labelVel.setBounds(600, 52, 100, 50);
		labelNiv = new JLabel("Nivel: 1");
		labelNiv.setBounds(600, 67, 100, 50);
		labelImg = new JLabel();
		labelImg.setIcon(new ImageIcon(getClass().getResource("/vista/Imagenes/BombitaRodriguez1.png")));
		labelImg.setBounds(600,380,200,200);
		
		contenedor.add(labelPts);
		contenedor.add(labelVida);
		contenedor.add(labelVel);
		contenedor.add(labelNiv);
		contenedor.add(labelImg);
		

		// MENU HERRAMIENTAS
		JMenu menuArchivo = new JMenu("Archivo");
		menuArchivo.setMnemonic('A');

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
				System.exit(0);
			}
		});

		JMenu menuAyuda = new JMenu("Ayuda");
		menuArchivo.setMnemonic('A');

		JMenuItem elementoControles = new JMenuItem("Controles");
		final String informacionControles = "Moverse: Flechas del Teclado \n" 
											+ "Plantar bomba: A\n"
											+ "Ingresar a la salida: ";
		elementoControles.setMnemonic('i');
		menuAyuda.add(elementoControles);
		elementoControles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				JOptionPane.showMessageDialog(frame, informacionControles,
						"Controles", JOptionPane.PLAIN_MESSAGE);
			}
		});

		JMenuItem elementoAcerca = new JMenuItem("Acerca de...");
		final String informacion = "TP2 - Bombita Rodriguez - Algoritmos III\n"
				+ "\n"
				+ "Franco Negri - Francisco Disalvo - Matias Barro - Federico Di Rocco\n";
		elementoAcerca.setMnemonic('A');
		menuAyuda.add(elementoAcerca);
		elementoAcerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				JOptionPane.showMessageDialog(frame, informacion, "Acerca de",
						JOptionPane.PLAIN_MESSAGE);
			}
		});

		JMenuBar barra = new JMenuBar();
		frame.setJMenuBar(barra);
		barra.add(menuArchivo);
		barra.add(menuAyuda);

		// BOTONES
		JButton btnIniciar = new JButton("Jugar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlDelJuego.IniciarJuego();
			}
		});

		btnIniciar.setBounds(600, 220, 130, 25);
		contenedor.add(btnIniciar);

		JButton btnDetener = new JButton("Pausar");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlDelJuego.DetenerJuego();
			}
		});
		btnDetener.setBounds(600, 260, 130, 25);
		contenedor.add(btnDetener);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlDelJuego.GuardarJuego();
			}
		});
		btnGuardar.setBounds(600, 300, 130, 25);
		contenedor.add(btnGuardar);
		
		JButton btnCargar=new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				controlDelJuego.CargarJuego();
			}
		});
		btnCargar.setBounds(600, 340, 130, 25);
		contenedor.add(btnCargar);
		
		

		//AREA DE TEXTO
		JTextArea area = new JTextArea();
		area = controlDelJuego.obtenerAreaDeTexto();
		contenedor.add(area);
		
		//CONTROLES (TECLADO)
		panel.addKeyListener(new Teclado(controlDelJuego.getBombita()));
		panel.setVisible(true);
		
	};
}
