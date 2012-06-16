package modelo.personaje.movimiento;

import java.util.LinkedList;
import modelo.personaje.Personaje;
import modelo.Translacion.*;

public abstract class Movimiento {

	private Translacion translacion;
	// private LinkedList<Movimiento> movimientos;
	// private Derecha derecha;
	// private Izquierda izquierda;
	// private Arriba arriba;
	// private Abajo abajo;

	public Movimiento() {
		// this.movimientos = new LinkedList<Movimiento>();
		this.translacion = new TranslacionDerecha();

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

	public abstract void mover(Personaje unPersonaje);

}
