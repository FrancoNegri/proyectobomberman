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
import javax.swing.JPopupMenu;

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
		frame.setBounds(100, 100, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		// PANEL
		JPanel panel = new SuperficiePanel();
		panel.setBackground(Color.white);
		panel.setBounds(20, 20, 550, 550);
		contenedor.add(panel);
		final ControlJuego controlDelJuego = new ControlJuego(panel);

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
		
		//INICIO BOTONES DE MOVIMIENTO
		
		JButton btnArriba = new JButton("U");
		btnArriba.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				controlDelJuego.moverBombitaArriba();
			}
		});
		btnArriba.setBounds(650, 420, 50, 25);
		contenedor.add(btnArriba);
		
		JButton btnAbajo = new JButton("D");
		btnAbajo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				controlDelJuego.moverBombitaAbajo();
			}
		});
		btnAbajo.setBounds(650, 500, 50, 25);
		contenedor.add(btnAbajo);
		
		JButton btnDerecha = new JButton("R");
		btnDerecha.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				controlDelJuego.moverBombitaDerecha();
			}
		});
		btnDerecha.setBounds(600, 460, 50, 25);
		contenedor.add(btnDerecha);
		
		JButton btnIzquierda = new JButton("L");
		btnIzquierda.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				controlDelJuego.moverBombitaIzquierda();
			}
		});
		btnIzquierda.setBounds(700, 460, 50, 25);
		contenedor.add(btnIzquierda);
		
		//FIN BOTONES DE MOVIMIENTO.
		
		// AREA DE TEXTO
		String cadena = "      Información \n" + "\n" 
						+ "Puntos: " +  controlDelJuego.mapa.obtenerPuntajeTotal() + "\n"
						+ "Vida: " + controlDelJuego.mapa.obtenerVidaBombita() + "\n" 
						+ "Velocidad: 5 \n" 
						+ "Nivel: 1 \n" 
						+ "Usuario: Bombita \n";
		Font fuente = new Font(Font.SERIF, Font.BOLD, 15);
		JTextArea area = new JTextArea();
		area.setText(cadena);
		area.setFont(fuente);
		area.setSize(40, 200);
		area.setBackground(Color.white);
		area.setBounds(600, 16, 130, 187);
		area.setEditable(false);
		contenedor.add(area);

		
	};
}
