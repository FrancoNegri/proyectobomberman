package main;

import javax.swing.JPanel;

import control.Persistencia.Persistencia;
import vista.Mapa.VistaMapa;
import vista.fiuba.algo3.titiritero.modelo.GameLoop;
import vista.fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import modelo.articulo.Articulo;
import modelo.articulo.Habano;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.obstaculos.BloqueAcero;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Personaje;
import modelo.personaje.enemigos.Cecilio;
import modelo.personaje.enemigos.LopezComun;

public class ControlJuego {

	final Mapa mapa = new Mapa(100);
	private GameLoop gameLoop;
	
	
	public ControlJuego(JPanel panel){
		this.gameLoop = new GameLoop(100, (SuperficieDeDibujo) panel);

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
	
}
