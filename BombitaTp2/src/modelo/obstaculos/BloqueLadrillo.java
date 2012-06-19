package modelo.obstaculos;

import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;

public class BloqueLadrillo extends Obstaculo{

	public BloqueLadrillo(Coordenada unacoordenada) {
		super(ConstantesJuego.resistencia_bloque_ladrillo,unacoordenada);
	}
}
	