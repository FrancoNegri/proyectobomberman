package modelo.Translacion;


import modelo.coordenadas.Coordenada;

public class TranslacionAbajo extends Translacion {
	@Override
	protected Coordenada actuar(Coordenada cordenada, Coordenada nuevaCord) {
		nuevaCord.cambiarCoordenadaY(cordenada.obtenerCoordenadaY()-1);
		return nuevaCord;
	}
}
