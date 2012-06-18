package modelo.Translacion;

import modelo.coordenadas.Coordenada;

public abstract class Translacion {
	public Coordenada accion(Coordenada cordenada) {
		Coordenada nuevaCord = new Coordenada(cordenada.obtenerCoordenadaX(),
				cordenada.obtenerCoordenadaY());
		nuevaCord = this.actuar(cordenada, nuevaCord); // Agregue el .this para poder usar polimorfimo en la clase movimiento. Fede
		return nuevaCord;
	}

	protected abstract Coordenada actuar(Coordenada cordenada,
			Coordenada nuevaCord);
}
