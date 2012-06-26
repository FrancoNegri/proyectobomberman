package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import control.Persistencia.Persistencia;
import control.Teclado.Teclado;
import modelo.armamento.Armamento;
import modelo.armamento.ToleTole;
import modelo.articulo.Articulo;
import modelo.articulo.Habano;
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
	private GameLoop gameLoop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		frame = new JFrame();
		Container contenedor = frame.getContentPane();
		frame.setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		final Mapa mapa = new Mapa(100);

		// MENU HERRAMIENTAS
		JMenu menuArchivo = new JMenu("Archivo");
		menuArchivo.setMnemonic('A');

		JMenuItem elementoJugar = new JMenuItem("Jugar");
		elementoJugar.setMnemonic('J');
		menuArchivo.add(elementoJugar);
		elementoJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				gameLoop.detenerEjecucion();
			}
		});
		
		JMenuItem elementoCargar = new JMenuItem("Cargar");
		elementoCargar.setMnemonic('C');
		menuArchivo.add(elementoCargar);
		elementoCargar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e){
				Persistencia pers = new Persistencia();
				try {
					Mapa mapacargado= pers.recuperar("c:/JUEGOGUARDADO.xml");
					gameLoop.iniciarEjecucion();
					gameLoop.agregar(mapacargado);
					VistaMapa VistaDelMapaCargado = new VistaMapa(mapacargado);
					gameLoop.agregar(VistaDelMapaCargado);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		JMenuItem elementoPausar = new JMenuItem("Pausar");
		elementoPausar.setMnemonic('P');
		menuArchivo.add(elementoPausar);
		elementoPausar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				gameLoop.iniciarEjecucion();
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
		menuArchivo.setMnemonic('Y');

		JMenuItem elementoControles = new JMenuItem("Controles");
		final String informacionControles = "Moverse: \n" + "Plantar bomba: \n"
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
		elementoAcerca.setMnemonic('c');
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
				gameLoop.iniciarEjecucion();
			}
		});

		btnIniciar.setBounds(42, 16, 77, 25);
		contenedor.add(btnIniciar);

		JButton btnDetener = new JButton("Pausar");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameLoop.detenerEjecucion();
			}
		});
		btnDetener.setBounds(425, 16, 92, 25);
		contenedor.add(btnDetener);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Persistencia pers = new Persistencia();
				pers.guardar("JUEGOGUARDADO.xml", mapa);
			}
		});
		btnGuardar.setBounds(200, 16, 92, 25);
		contenedor.add(btnGuardar);
		
		JButton btnCargar=new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				Persistencia pers = new Persistencia();
				try {
					gameLoop.reiniciar();
					Mapa mapacargado= pers.recuperar("JUEGOGUARDADO.xml");
					gameLoop.agregar(mapacargado);
					VistaMapa VistaDelMapaCargado = new VistaMapa(mapacargado);
					gameLoop.agregar(VistaDelMapaCargado);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnCargar.setBounds(300,16, 92, 25);
		contenedor.add(btnCargar);
		

		// AREA DE TEXTO
		String cadena = "         Información \n" + "\n" + "Puntos: 0000 \n"
				+ "Vida: 100 \n" + "Nivel: 1 \n" + "Usuario: Bombita \n";
		Font fuente = new Font(Font.SERIF, Font.BOLD, 15);
		JTextArea area = new JTextArea();
		area.setText(cadena);
		area.setFont(fuente);
		area.setSize(40, 200);
		area.setBackground(Color.white);
		area.setBounds(800, 16, 150, 187);
		area.setEditable(false);
		contenedor.add(area);

		// PANEL
		JPanel panel = new SuperficiePanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(42, 53, 700, 500);
		contenedor.add(panel);

		this.gameLoop = new GameLoop(200, (SuperficieDeDibujo) panel);
		// ///////////Inicializacion grafica Completa

		Personaje modelo3;
		
		//INGRESO DE OBJETOS
		Coordenada coord = new Coordenada(10, 10);
		Coordenada otraCoord = new Coordenada(18, 45);
		Articulo articulo = new Habano(otraCoord);
		mapa.agregarAlMapa(articulo);
		//Bombita bombita = new Bombita(coord,mapa);
		//mapa.agregarAlMapa(bombita);
		
		//panel.addKeyListener(new Teclado(bombita));
		
		for (int j = 4; j < 20; j++) {
			coord = new Coordenada(j, j * 3);
			Obstaculo obst = new BloqueAcero(coord);
			mapa.agregarAlMapa(obst);
		}
		for (int j = 0; j < 30; j++) {
			coord = new Coordenada(j * 3, j ^ 2);
			modelo3 = new Cecilio(coord, mapa);
			gameLoop.agregar(modelo3);
		}
		for (int j = 0; j < 30; j++) {
			coord = new Coordenada(j * 3, j ^ 2);
			modelo3 = new LopezComun(coord, mapa);
			gameLoop.agregar(modelo3);
		}
		//gameLoop.agregar(bombita);
		gameLoop.agregar(mapa);
		VistaMapa VistaDelMapa = new VistaMapa(mapa);
		gameLoop.agregar(VistaDelMapa);
	};
}
