package main;

import java.awt.Color; 
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import modelo.salida.*;
public class ControlJuego implements Runnable {

	Mapa mapa;
	private GameLoop gameLoop;
	private JPanel panel;
	private Bombita bombita;
	private BufferedImage fondo;
	private JFrame frame;
	Persistencia pers = new Persistencia();
	Teclado teclado;
	private boolean finDelJuego = false;
	
	public ControlJuego(JPanel unPanel, JFrame unFrame)  {
		this.gameLoop = new GameLoop(0, (SuperficieDeDibujo) unPanel);
		this.panel = unPanel;
		this.frame = unFrame;
	
		Personaje modelo3;
		
		//Cargo Mapa DE OBJETOS----------------------------------------------------------------
		
		try {
			gameLoop.reiniciar();
			mapa = pers.recuperar("lvls/lvl1.xml");
			Thread juego = new Thread(this);
			juego.start();	
			bombita = pers.recuperarBombita();
			teclado = new Teclado(bombita);
			unPanel.setVisible(true);
			unPanel.addKeyListener(teclado);
			gameLoop.agregar(mapa);
			VistaMapa VistaDelMapaCargado = new VistaMapa(mapa);
			gameLoop.agregar(VistaDelMapaCargado);
			gameLoop.iniciarEjecucion();
			juego.start();
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
			cargarMapaEnXml("lvls/JUEGOGUARDADO.xml");
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
	
	public int obtenerPuntajeArea() {
		return mapa.obtenerPuntajeTotal();
	}
	
	public int obtenerVidaArea() {
		return bombita.obtenerVida();
	}
	
	public int obtenerVelocidadArea() {
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
	
	
	//GAME OVER
	public void gameOver() {
	       int n = JOptionPane.showConfirmDialog(frame,
	               "Perdiste, queres volver a jugar?",
	               "Game Over",
	               JOptionPane.YES_NO_OPTION);
	       if (n == JOptionPane.YES_OPTION) {
	           this.IniciarJuego(); //Aca deberia reiniciar el nivel correcto
	       } else
	           System.exit(0);
	}
	
	//PASAJE A OTRO NIVEL
	public void pasajeDeNivel() {
	       int n = JOptionPane.showConfirmDialog(frame,
	               "Ganaste, queres pasar al otro nivel?",
	               "Ganaste",
	               JOptionPane.YES_NO_OPTION);
	       if (n == JOptionPane.YES_OPTION) {
	           this.IniciarJuego(); //Aca deberia pasar al nivel correcto
	       } else
	           System.exit(0);
	}
	
	//JUEGO GANADO
	public void juegoGanado() {
		      int n = JOptionPane.showConfirmDialog(frame,
		              "GANASTE EL JUEGO, queres volver a comenzar el juego?",
		              "Ganador",
		              JOptionPane.YES_NO_OPTION);
		      if (n == JOptionPane.YES_OPTION) {
		          this.IniciarJuego();
		      } else
		          System.exit(0);
		}


	public void run() {
		int k = 1;
		while(!finDelJuego){
			if(mapa.terminoNivel()){
				try {
					cargarMapaEnXml("lvl"+k+".xml");
					pasajeDeNivel();
					finDelJuego = false;
				} catch (IOException e) {
					juegoGanado();
				}
				k = k+1;
			}
		}
	}


	public void terminar() {
		finDelJuego = true;
	}


	public void cargarMapaEnXml(String ruta) throws IOException{
		gameLoop.reiniciar();
		mapa= pers.recuperar(ruta);
		teclado.set(pers.recuperarBombita());
		gameLoop.agregar(mapa);
		VistaMapa VistaDelMapaCargado = new VistaMapa(mapa);
		gameLoop.agregar(VistaDelMapaCargado);
	}
}
