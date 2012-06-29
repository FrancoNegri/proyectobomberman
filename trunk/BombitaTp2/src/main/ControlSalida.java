package main;

import java.util.Iterator;
import java.util.LinkedList;

import vista.fiuba.algo3.titiritero.modelo.GameLoop;
import modelo.mapa.*;

public class ControlSalida implements Runnable{
	
	private GameLoop gameloop;
	private Mapa mapa;
	private int frecuencia;
	private Thread hilo;
	private boolean estaEjecutando;
	
	
	
	public ControlSalida(int frecuencia, GameLoop gameLoop, Mapa mapa) {
		this.frecuencia = frecuencia;
		this.mapa = mapa;
		this.gameloop = gameloop;
	}

	public void reiniciar(){
		
	}
	
	
	/*@Override*/
	public void run() {
		while(this.estaEjecutando) {
			int k = 0;
			while(!mapa.terminoNivel()){
				k = k+1;
			}
			this.gameloop.detenerEjecucion();
			try {
				Thread.sleep(this.frecuencia);
			} catch (InterruptedException e) {
				// TODO log de exception
				e.printStackTrace();
			}
		}
	}



	public void iniciarEjecucion() {
		this.estaEjecutando = true;
		this.hilo = new Thread(this);
		this.hilo.start();
	}

	public void detenerEjecucion() {
		this.estaEjecutando = false;
		this.hilo.interrupt();
	}

}
