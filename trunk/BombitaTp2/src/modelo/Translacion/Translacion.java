package modelo.Translacion;

import modelo.coordenadas.Coordenada;

public abstract class Translacion {
	public Coordenada accion(Coordenada cordenada){
		Coordenada nuevaCord = new Coordenada(cordenada.obtenerCoordenadaX(),cordenada.obtenerCoordenadaY());
		nuevaCord = actuar(cordenada, nuevaCord);
		return nuevaCord;
	}
	protected abstract Coordenada actuar(Coordenada cordenada,Coordenada nuevaCord);
}
