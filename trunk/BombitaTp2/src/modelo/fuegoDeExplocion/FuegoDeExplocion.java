package modelo.fuegoDeExplocion;

import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import vista.objeto.ObjetoVisible;
import vista.objeto.VistaObjeto;
import modelo.coordenadas.Coordenada;

public class FuegoDeExplocion implements ObjetoVisible,ObjetoPosicionable {

	private Coordenada coordenada;
	public FuegoDeExplocion(Coordenada Coord){
		coordenada = Coord.copiar();
	}	
	
	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConFuegoDeExplocion(this);
	}

	public int getX() {
		
		return coordenada.obtenerCoordenadaX();
	}
	
	public int getY() {
		return coordenada.obtenerCoordenadaY();
	}
	
}
