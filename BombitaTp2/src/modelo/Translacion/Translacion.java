package modelo.Translacion;

import modelo.coordenadas.Coordenada;

public abstract class Translacion {
	public Coordenada accion(Coordenada cordenada) {
		Coordenada nuevaCord = new Coordenada(cordenada.obtenerCoordenadaX(),
				cordenada.obtenerCoordenadaY());
		nuevaCord = actuar(cordenada, nuevaCord); // Como llama por polimorfismo al actuar correcto? Fede.
		return nuevaCord;
	}

	protected abstract Coordenada actuar(Coordenada cordenada,
			Coordenada nuevaCord);
}
