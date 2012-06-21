package modelo.Translacion;

import modelo.coordenadas.Coordenada;
import modelo.errores.coordenadaInvalida;

public abstract class Translacion {
	public Coordenada accion(Coordenada cordenada) {
		Coordenada nuevaCord = new Coordenada(cordenada.obtenerCoordenadaX(),
				cordenada.obtenerCoordenadaY());
		try{
		nuevaCord = this.actuar(cordenada, nuevaCord);
		}catch(coordenadaInvalida e){
			nuevaCord = cordenada;
		}
		return nuevaCord;
	}

	protected abstract Coordenada actuar(Coordenada cordenada,
			Coordenada nuevaCord);
}
