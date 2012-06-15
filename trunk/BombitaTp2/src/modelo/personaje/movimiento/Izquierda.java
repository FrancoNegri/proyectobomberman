package modelo.personaje.movimiento;

import modelo.personaje.Personaje;

public class Izquierda extends Movimiento{

	public void mover(Personaje unPersonaje) {
		//implemente una clase movimiento fijate si te sirve.
		int coordenadaNueva = unPersonaje.obtenerCoordenadaXY().obtenerCoordenadaX() - 1;
		unPersonaje.obtenerCoordenadaXY().cambiarCoordenadaX(coordenadaNueva);
	}

}
