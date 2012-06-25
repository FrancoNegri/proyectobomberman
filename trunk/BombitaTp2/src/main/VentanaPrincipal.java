package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		frame.setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameLoop.iniciarEjecucion();
			}
		});
		
		btnIniciar.setBounds(42, 16, 77, 25);
		frame.getContentPane().add(btnIniciar);

		JButton btnDetener = new JButton("Detener");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameLoop.detenerEjecucion();
			}
		});
		btnDetener.setBounds(425, 16, 92, 25);
		frame.getContentPane().add(btnDetener);
		
		final Mapa mapa = new Mapa(100);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Persistencia pers = new Persistencia();
				pers.guardar("JUEGOGUARDADO.xml", mapa);
			}
		});
		btnGuardar.setBounds(200, 16, 92, 25);
		frame.getContentPane().add(btnGuardar);
		
		JButton btnCargar=new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				Persistencia pers = new Persistencia();
				try {
					Mapa mapacargado= pers.recuperar("JUEGOGUARDADO.xml");
					gameLoop.iniciarEjecucion();
					gameLoop.agregar(mapacargado);
					VistaMapa VistaDelMapaCargado = new VistaMapa(mapacargado);
					gameLoop.agregar(VistaDelMapaCargado);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
			
		});
		
		btnCargar.setBounds(300,16, 92, 25);
		frame.getContentPane().add(btnCargar);
		
		

		JPanel panel = new SuperficiePanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(42, 53, 500, 500);
		frame.getContentPane().add(panel);

		this.gameLoop = new GameLoop(200, (SuperficieDeDibujo) panel);
		// ///////////Inicializacion grafica Completa
		
		/*Mapa mapa = new Mapa(100);*/
		Personaje modelo3;
		
		Coordenada coord = new Coordenada(99, 99);
		Articulo articulo = new Habano(coord);
		mapa.agregarAlMapa(articulo);
		for (int j = 4; j < 20; j++) {
			coord = new Coordenada(j, j*3);
			Obstaculo obst = new BloqueAcero(coord);
			mapa.agregarAlMapa(obst);
		}
		for (int j = 0; j < 30; j++) {
			coord = new Coordenada(j*3,j^2);
			modelo3 = new Cecilio(coord, mapa);
			gameLoop.agregar(modelo3);
		}
		for (int j = 0; j < 30; j++) {
			coord = new Coordenada(j*3,j^2);
			modelo3 = new LopezComun(coord, mapa);
			gameLoop.agregar(modelo3);
		}
		gameLoop.agregar(mapa);
		VistaMapa VistaDelMapa = new VistaMapa(mapa);
		gameLoop.agregar(VistaDelMapa);
	};
}
