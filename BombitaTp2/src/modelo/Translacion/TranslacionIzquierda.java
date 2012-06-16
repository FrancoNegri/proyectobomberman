package modelo.Translacion;

import modelo.coordenadas.Coordenada;

public class TranslacionIzquierda extends Translacion {
	@Override
	protected Coordenada actuar(Coordenada cordenada, Coordenada nuevaCord) {
		nuevaCord.cambiarCoordenadaX(cordenada.obtenerCoordenadaX()+1);
		return nuevaCord;
	}
}
