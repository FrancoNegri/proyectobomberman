package main;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.mapa.Mapa;
import modelo.personaje.Bombita;
import vista.Mapa.VistaMapa;
import vista.fiuba.algo3.titiritero.modelo.GameLoop;
import vista.fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import control.Persistencia.Persistencia;
import control.Teclado.Teclado;

public class ControlJuego implements Runnable {

	Mapa mapa;
	int nivel = 1;
	private GameLoop gameLoop;
	private JPanel panel;
	private Bombita bombita;
	private JFrame frame;
	Persistencia pers = new Persistencia();
	Teclado teclado;
	private boolean finDelJuego = false;
	
	public ControlJuego(JPanel unPanel, JFrame unFrame)  {
		this.gameLoop = new GameLoop(1, (SuperficieDeDibujo) unPanel);
		this.panel = unPanel;
		this.frame = unFrame;
		//Cargo Mapa DE OBJETOS----------------------------------------------------------------
		
		try {
			gameLoop.reiniciar();
			mapa = pers.recuperar("lvls/lvl1.xml");
			Thread juego = new Thread(this);
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
	
	public Bombita getBombita() {
		return this.bombita;
	}
	
	public Mapa getMapa() {
		return this.mapa;
	}
	
	public int getNivel() {
		return this.nivel;
	}
	
	//GAME OVER
	public void gameOver() throws IOException {
	       int n = JOptionPane.showConfirmDialog(frame,
	               "Perdiste, queres volver a jugar?",
	               "Game Over",
	               JOptionPane.YES_NO_OPTION);
	       if (n == JOptionPane.YES_OPTION) {
	    	   nivel = 1;
	    	   this.cargarMapaEnXml("lvls/lvl"+nivel+".xml");
	    	   gameLoop.iniciarEjecucion();
	       } else
	           System.exit(0);
	}
	
	//PASAJE A OTRO NIVEL
	public void pasajeDeNivel() throws IOException {
	       int n = JOptionPane.showConfirmDialog(frame,
	               "Ganaste, queres pasar al otro nivel?",
	               "Ganaste",
	               JOptionPane.YES_NO_OPTION);
	       if (n == JOptionPane.YES_OPTION) {
	    	   cargarMapaEnXml("lvls/lvl"+nivel+".xml");
	    	   gameLoop.iniciarEjecucion();
	       } else
	           System.exit(0);
	}
	
	//JUEGO GANADO
	public void juegoGanado() throws IOException {
		      int n = JOptionPane.showConfirmDialog(frame,
		              "GANASTE EL JUEGO, queres volver a comenzar el juego?",
		              "Ganador",
		              JOptionPane.YES_NO_OPTION);
		      if (n == JOptionPane.YES_OPTION) {
		    	  nivel = 1;
		    	  cargarMapaEnXml("lvls/lvl"+nivel+".xml");
		    	  gameLoop.iniciarEjecucion();
		      } else
		          System.exit(0);
		}


	public void run() {
		while(!finDelJuego){
			if(mapa.terminoNivel()){
				try {
					nivel = nivel+1;
					pasajeDeNivel();
					finDelJuego = false;
				} catch (IOException e) {
					try {
						juegoGanado();
					} catch (IOException e1) {}
				}
			}
			if(bombita.estaMuerto()){
				try {
					gameOver();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}


	public void terminar() {
		finDelJuego = true;
	}


	public void cargarMapaEnXml(String ruta) throws IOException{
		
		gameLoop.reiniciar();
		mapa= pers.recuperar(ruta);
		bombita = pers.recuperarBombita();
		teclado.set(bombita);
		gameLoop.agregar(mapa);
		VistaMapa VistaDelMapaCargado = new VistaMapa(mapa);
		gameLoop.agregar(VistaDelMapaCargado);
	}
}
