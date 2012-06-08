package modelo.personaje.movimiento;

import modelo.personaje.Personaje;
import modelo.coordenadas.*;

public class Abajo extends Movimiento{

	public void mover(Personaje unPersonaje) {
		unPersonaje.obtenerCoordenadaXY().cambiarCoordenadaY(obtenerCoordenadaY() - 1);
	}

}
