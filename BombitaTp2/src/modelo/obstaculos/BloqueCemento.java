package modelo.obstaculos;

import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;

public class BloqueCemento extends Obstaculo {

	public BloqueCemento(Coordenada unacoordenada) {
		super(ConstantesJuego.resistencia_bloque_cemento,unacoordenada);
	}
	
}
