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

	public ControlJuego(JPanel unPanel){
		this.gameLoop = new GameLoop(100, (SuperficieDeDibujo) unPanel);
		this.panel = unPanel;
	
		Personaje modelo3;
		
		//INGRESO DE OBJETOS----------------------------------------------------------------
		
		//ARTICULOS
		Coordenada otraCoord = new Coordenada(18, 25);
		Coordenada coord = new Coordenada(30, 10);
		Articulo articulo = new Habano(otraCoord);
		mapa.agregarAlMapa(articulo);
		Articulo otroArticulo = new Timer(coord);
		mapa.agregarAlMapa(otroArticulo);
		
		
		//BOMBITA
		Coordenada coord1 = new Coordenada(20, 36);
		this.bombita = new Bombita(coord1,mapa);
		panel.addKeyListener(new Teclado(bombita)); //Agrego teclado para Bombita
		mapa.agregarAlMapa(bombita);
		
		
		//BLOQUE ACERO
		for (int j = 2; j < 9; j++) {
			coord = new Coordenada(j, j * 3);
			Obstaculo obst = new BloqueAcero(coord);
			mapa.agregarAlMapa(obst);
		}
		
		//BLOQUE LADRILLO
		for (int j = 5; j < 9; j++) {
			coord = new Coordenada(j * 3, j);
			Obstaculo obst = new BloqueLadrillo(coord);
			mapa.agregarAlMapa(obst);
		}
		
		//CECILIO
		for (int j = 0; j < 12; j++) {
			coord = new Coordenada(j * 3, j ^ 6);
			modelo3 = new Cecilio(coord, mapa);
		}
		
		//LOPEZ COMUN
		for (int j = 0; j < 7; j++) {
			coord = new Coordenada(j * 6, j ^ 2);
			modelo3 = new LopezComun(coord, mapa);
		}
		
		//LOPEZ ALADO
		for (int j = 7; j < 12; j++) {
			coord = new Coordenada(j * 2, j ^ 2);
			modelo3 = new LopezAlado(coord, mapa);
		}
		
		gameLoop.agregar(bombita);
		gameLoop.agregar(mapa);
		VistaMapa VistaDelMapa = new VistaMapa(mapa);
		gameLoop.agregar(VistaDelMapa);
	}
	
	
	public void IniciarJuego(){
		gameLoop.iniciarEjecucion();
	}
	
	public void DetenerJuego(){
		gameLoop.detenerEjecucion();
	}
	
	
	public void CargarJuego(){
		Persistencia pers = new Persistencia();
		try {
			gameLoop.reiniciar();
			Mapa mapacargado= pers.recuperar("JUEGOGUARDADO.xml");
			bombita = pers.recuperarBombita();
			gameLoop.iniciarEjecucion();
			gameLoop.agregar(mapacargado);
			VistaMapa VistaDelMapaCargado = new VistaMapa(mapacargado);
			gameLoop.agregar(VistaDelMapaCargado);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}	
	
	public void GuardarJuego(){
		Persistencia pers = new Persistencia();
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



