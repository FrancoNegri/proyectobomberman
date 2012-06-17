package modelo.ArmamentoFactory;

import modelo.armamento.Armamento;
import modelo.armamento.ToleTole;
import modelo.coordenadas.Coordenada;

public class ToleToleFactory extends ArmamentoFactory{
	private int time = 0;
	@Override
	public Armamento crear(Coordenada coord) {
		ToleTole tole = new ToleTole(coord,time);
		return tole;
	}

	@Override
	public void cambiarTime(int unTime) {
		time = unTime;
	}

	@Override
	public int obtenerTime() {
		return time;
	}
}
