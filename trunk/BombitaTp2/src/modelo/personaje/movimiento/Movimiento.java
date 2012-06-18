package modelo.personaje.movimiento;

import modelo.coordenadas.Coordenada;
import modelo.personaje.Personaje;
import modelo.Translacion.*;

public abstract class Movimiento {

	protected Translacion translacion;
	// private LinkedList<Movimiento> movimientos;
	// private Derecha derecha;
	// private Izquierda izquierda;
	// private Arriba arriba;
	// private Abajo abajo;

	public Movimiento() {
		// this.movimientos = new LinkedList<Movimiento>();

		// derecha = new Derecha();
		// izquierda = new Izquierda();
		// abajo = new Abajo();
		// arriba = new Arriba();

		// Inicializo la lista de objetos movimientos
		// this.movimientos.add(derecha);
		// this.movimientos.add(izquierda);
		// this.movimientos.add(abajo);
		// this.movimientos.add(arriba);
	}

	public int obtenerNumeroRandom() {
		// Devuelve un numero entre 0 y 3.
		int numero = (int) Math.round((Math.random() * 1000));
		return ((numero % 3) + 1);
	}

	public void mover(Personaje unPersonaje){
		Coordenada coordenadaActual = unPersonaje.obtenerCoordenadaXY();
		Coordenada nuevaCoordenada = translacion.accion(coordenadaActual);
		unPersonaje.cambiarCoordenadaXY(nuevaCoordenada);
	}

}
