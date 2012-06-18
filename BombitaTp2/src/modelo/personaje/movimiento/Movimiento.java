package modelo.personaje.movimiento;

import java.util.LinkedList;

import modelo.coordenadas.Coordenada;
import modelo.personaje.Personaje;
import modelo.Translacion.*;

public class Movimiento {

	protected Translacion translacion;
	private LinkedList<Movimiento> movimientos;

	public Movimiento() {
	
	}

	public int obtenerNumeroRandom() {
		// Devuelve un numero entre 1 y 4.
		int numero = (int) Math.round((Math.random() * 1000));
		return ((numero % 4)+1);
	}

	public void mover(Personaje unPersonaje) {
		Coordenada coordenadaActual = unPersonaje.obtenerCoordenadaXY();
		Coordenada nuevaCoordenada = translacion.accion(coordenadaActual);
		unPersonaje.cambiarCoordenadaXY(nuevaCoordenada);
	}
	
	public final LinkedList<Movimiento> inicializarMovimientos() {
		this.movimientos = new LinkedList<Movimiento>();
		Derecha derecha = new Derecha();
		this.movimientos.add(derecha);
		Izquierda izquierda = new Izquierda();
		this.movimientos.add(izquierda);
		Abajo abajo = new Abajo();
		this.movimientos.add(abajo);
		Arriba arriba = new Arriba();
		this.movimientos.add(arriba);
		return movimientos;
	}

}
