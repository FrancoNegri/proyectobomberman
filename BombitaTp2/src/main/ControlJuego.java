package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import modelo.articulo.Articulo;
import modelo.articulo.Habano;
import modelo.articulo.Timer;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.obstaculos.BloqueAcero;
import modelo.obstaculos.BloqueLadrillo;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Bombita;
import modelo.personaje.Personaje;
import modelo.personaje.enemigos.Cecilio;
import modelo.personaje.enemigos.LopezAlado;
import modelo.personaje.enemigos.LopezComun;
import vista.Mapa.VistaMapa;
import vista.fiuba.algo3.titiritero.modelo.GameLoop;
import vista.fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import control.Persistencia.Persistencia;
import control.Teclado.Teclado;

public class ControlJuego {

	Mapa mapa;
	private GameLoop gameLoop;
	private JPanel panel;
	private Bombita bombita;
	private BufferedImage fondo;
	Persistencia pers = new Persistencia();
	Teclado teclado;
	
	public ControlJuego(JPanel unPanel){
		this.gameLoop = new GameLoop(10, (SuperficieDeDibujo) unPanel);
		this.panel = unPanel;
	
		Personaje modelo3;
		
		//Cargo Mapa DE OBJETOS----------------------------------------------------------------
		
		try {
			gameLoop.reiniciar();
			mapa = pers.recuperar("lvls/lvl1.xml");
			bombita = pers.recuperarBombita();
			teclado = new Teclado(bombita);
			unPanel.setVisible(true);
			unPanel.addKeyListener(teclado);
			gameLoop.agregar(mapa);
			VistaMapa VistaDelMapaCargado = new VistaMapa(mapa);
			gameLoop.agregar(VistaDelMapaCargado);
			gameLoop.iniciarEjecucion();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	
	public void IniciarJuego(){
		gameLoop.iniciarEjecucion();
	}
	
	public void DetenerJuego(){
		gameLoop.detenerEjecucion();
	}
	
	
	public void CargarJuego(){
		try {
			gameLoop.reiniciar();
			Mapa mapacargado= pers.recuperar("lvls/JUEGOGUARDADO.xml");
			/*bombita = pers.recuperarBombita();
			Coordenada coord = new Coordenada(38,38);
			mapacargado.agregarSalida(coord)*/
			teclado.set(pers.recuperarBombita());
			gameLoop.agregar(mapacargado);
			VistaMapa VistaDelMapaCargado = new VistaMapa(mapacargado);
			gameLoop.agregar(VistaDelMapaCargado);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}	
	
	public void GuardarJuego(){
		pers.guardar("lvls/JUEGOGUARDADO.xml", mapa);
	}
	
	public void moverBombitaArriba(){
		bombita.moverseArriba();
	}
	
	public void moverBombitaAbajo(){
		bombita.moverseAbajo();
	}
	
	public void moverBombitaDerecha(){
		bombita.moverseDerecha();
	}
	
	public void moverBombitaIzquierda(){
		bombita.moverseIzquierda();
	}
	
	public void ataqueDeBombita(){
		bombita.cambiarActitud();
	}
	
	public JTextArea obtenerAreaDeTexto () {
		String cadena = "      Informacion \n" + "\n";
		Font fuente = new Font(Font.SERIF, Font.BOLD, 15);
		JTextArea area = new JTextArea();
		area.setText(cadena);
		area.setFont(fuente);
		area.setSize(40, 200);
		area.setBackground(Color.white);
		area.setBounds(600, 16, 130, 187);
		area.setEditable(false);
		return area;
	}
	
	public int obtenerPuntajeArea() {
		return mapa.obtenerPuntajeTotal();
	}
	
	public int obtenerVidaArea() {
		return bombita.obtenerVida();
	}
	
	public float obtenerVelocidadArea() {
		return bombita.getVelocidad();
	}
	
	/*MANEJO DEL FONDO DEL MAPA
	private void cargarFondoMapa() {
		try{
			fondo = ImageIO.read(getClass().getClassLoader().getResource("/vista/Imagenes/BloquePiso.png"));
		}catch(Exception e){}
	}
	
	private void drawPane(Graphics g){
		//Hacer un for sobre el panel para ir agregando los bloques
		if(fondo!=null){
			for(int i=0;i<40;i++){
			for(int j=0;j<40;j++){
				g.drawImage(fondo, i*32, j*32, i*32+32, j*32+32, 0, 0, 256, 256, null);
			}
			}
		}
		}
		
	public void dibujarMapa(Graphics g){
		this.cargarFondoMapa();
		this.drawPane(g);
	}*/
	
	public Bombita getBombita() {
		return this.bombita;
	}
}



