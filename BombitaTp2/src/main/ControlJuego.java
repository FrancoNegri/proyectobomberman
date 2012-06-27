package main;

import javax.swing.JPanel;

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

	final Mapa mapa = new Mapa(40);
	private GameLoop gameLoop;
	private JPanel panel;
	private Bombita bombita;
	Persistencia pers = new Persistencia();
	
	public ControlJuego(JPanel unPanel){
		this.gameLoop = new GameLoop(100, (SuperficieDeDibujo) unPanel);
		this.panel = unPanel;
	
		Personaje modelo3;
		
		//Cargo Mapa DE OBJETOS----------------------------------------------------------------
		
		try {
			gameLoop.reiniciar();
			Mapa mapacargado= pers.recuperar("lvls/lvl1.xml");
			bombita = pers.recuperarBombita();
			gameLoop.agregar(mapacargado);
			VistaMapa VistaDelMapaCargado = new VistaMapa(mapacargado);
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
			Mapa mapacargado= pers.recuperar("JUEGOGUARDADO.xml");
			bombita = pers.recuperarBombita();
			gameLoop.agregar(mapacargado);
			VistaMapa VistaDelMapaCargado = new VistaMapa(mapacargado);
			gameLoop.agregar(VistaDelMapaCargado);
			gameLoop.iniciarEjecucion();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}	
	
	public void GuardarJuego(){
		pers.guardar("JUEGOGUARDADO.xml", mapa);
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
	
}



