package modelo.personaje.movimiento;

import modelo.personaje.Personaje;

public class Derecha extends Movimiento{

	
	public void mover(Personaje unPersonaje) {
		int coordenadaNueva = unPersonaje.obtenerCoordenadaXY().obtenerCoordenadaX() + 1;
		unPersonaje.obtenerCoordenadaXY().cambiarCoordenadaX(coordenadaNueva);
	}

}
