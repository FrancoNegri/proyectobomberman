package modelo.armamento;

import modelo.Translacion.Translacion;
import modelo.coordenadas.Coordenada;

public class Proyectil extends Armamento {
	
	private Translacion transladador;//para que lado se va a mover.
	
	public Proyectil(Coordenada coordenada, Translacion trans) {
		super(coordenada);
		this.transladador = trans;
		this.danio = 10;
	}
	
	//Como se mueve el proyectil? Deberia tener un metodo mover? Fede.
}
