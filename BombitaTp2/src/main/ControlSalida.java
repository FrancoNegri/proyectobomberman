package main;

import java.util.Iterator;
import java.util.LinkedList;

import vista.fiuba.algo3.titiritero.modelo.GameLoop;
import modelo.mapa.*;

public class ControlSalida implements Runnable{
	private Mapa mapa;
	private Thread hilo;
	private boolean estaEjecutando;
	
	
	
	public ControlSalida(int frecuencia, GameLoop gameLoop, Mapa mapa) {
		this.mapa = mapa;
	}

	public void reiniciar(){
		
	}
	
	
	/*@Override*/
	public void run() {
		while(this.estaEjecutando) {
			int k = 0;
			
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
