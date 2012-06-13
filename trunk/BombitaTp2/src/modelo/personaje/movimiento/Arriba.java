package modelo.personaje.movimiento;

import modelo.personaje.Personaje;

public class Arriba extends Movimiento{

	public void mover(Personaje unPersonaje){
		int coordenadaNueva = unPersonaje.obtenerCoordenadaXY().obtenerCoordenadaY() + 1;
		unPersonaje.obtenerCoordenadaXY().cambiarCoordenadaY(coordenadaNueva);
	}
}
