package vista.fiuba.algo3.titiritero.modelo;

import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLoop implements Runnable{

	private static final int FRECUENCIA_DEFAULT = 500;
	private LinkedList<ObjetoVivo> objetosVivos;
	private LinkedList<ObjetoDibujable> objetosDibujables;
	private boolean estaEjecutando;
	private int frecuencia;
	private SuperficieDeDibujo superficieDeDibujo;
	private Thread hilo;
	
	public GameLoop(int frecuencia, SuperficieDeDibujo superficieDeDibujo) {
		this.frecuencia = frecuencia;
		this.superficieDeDibujo = superficieDeDibujo;
		this.objetosVivos = new LinkedList<ObjetoVivo>();
		this.objetosDibujables= new LinkedList<ObjetoDibujable>();
	}

	public GameLoop(SuperficieDeDibujo superficieDeDibujo) {
		this(FRECUENCIA_DEFAULT, superficieDeDibujo);
	}

	public void agregar(ObjetoVivo objetoVivo) {
		if(!this.objetosVivos.contains(objetoVivo)){
			this.objetosVivos.add(objetoVivo);
		}
	}

	public void remover(ObjetoVivo objetoVivo) {
		this.objetosVivos.remove(objetoVivo);
	}

	public void agregar(ObjetoDibujable objetoDibujable) {
		if(!this.objetosDibujables.contains(objetoDibujable)){
			this.objetosDibujables.add(objetoDibujable);
		}
		
	}

	public void remover(ObjetoDibujable objetoDibujable) {
		this.objetosDibujables.remove(objetoDibujable);
	}
	
	/*@Override*/
	public void run() {
		while(this.estaEjecutando) {
			Iterator<ObjetoVivo> iterator = objetosVivos.iterator();
			while(iterator.hasNext()){
				ObjetoVivo objetoVivo = iterator.next();
				objetoVivo.vivir();
			}
			for(ObjetoDibujable objetoDibujable : this.objetosDibujables) {
				objetoDibujable.dibujar(this.superficieDeDibujo);
			}
			this.superficieDeDibujo.actualizar();
			try {
				Thread.sleep(this.frecuencia);
			} catch (InterruptedException e) {
				// TODO log de exception
				e.printStackTrace();
			}
		}
	}

	public int getCantidadDeObjetosVivos() {
		return this.objetosVivos.size();
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