package modelo.fuegoDeExplocion;

import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import vista.objeto.ObjetoVisible;
import vista.objeto.VistaObjeto;
import modelo.coordenadas.Coordenada;

public class FuegoDeExplocion implements ObjetoVisible,ObjetoPosicionable {

	private Coordenada coordenada;
	int vidaDelFuego;
	public FuegoDeExplocion(Coordenada Coord, int vida){
		coordenada = Coord.copiar();
		vidaDelFuego = vida;
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

	public boolean estaMuerto() {
		return (vidaDelFuego <= 0);
	}

	public void vivir() {
		vidaDelFuego = vidaDelFuego -1;
	}
	
}
