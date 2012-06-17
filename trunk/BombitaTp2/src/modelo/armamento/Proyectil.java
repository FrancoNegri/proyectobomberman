package modelo.armamento;

import modelo.Translacion.Translacion;
import modelo.coordenadas.Coordenada;

public class Proyectil extends Armamento {
	private Translacion transladador;
	public Proyectil(Coordenada coordenada, Translacion trans) {
		super(coordenada);
		transladador = trans;
		this.danio = 10;
	}
}
