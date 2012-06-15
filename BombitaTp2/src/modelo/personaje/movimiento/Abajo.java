package modelo.personaje.movimiento;

import modelo.personaje.Personaje;

public class Abajo extends Movimiento{

	public void mover(Personaje unPersonaje) {
		int coordenadaNueva = unPersonaje.obtenerCoordenadaXY().obtenerCoordenadaY() - 1;
		//translacion.accion
		unPersonaje.obtenerCoordenadaXY().cambiarCoordenadaY(coordenadaNueva);
	}

}
