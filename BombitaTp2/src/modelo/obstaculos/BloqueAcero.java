package modelo.obstaculos;

import modelo.coordenadas.Coordenada;
import modelo.constantesjuego.ConstantesJuego;

public class BloqueAcero extends Obstaculo {

	public BloqueAcero(Coordenada unacoordenada) {
		super(ConstantesJuego.resistencia_bloque_Acero,unacoordenada);
	}
	
	//se Podria hacer un doble Dispatch o algo para ver si es una tole tole o otra arma

}
