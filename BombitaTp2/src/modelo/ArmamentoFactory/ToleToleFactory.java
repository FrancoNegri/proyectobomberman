package modelo.ArmamentoFactory;

import modelo.armamento.Armamento;
import modelo.armamento.ToleTole;
import modelo.personaje.Personaje;

public class ToleToleFactory extends ArmamentoFactory{
	private int time = 5;
	@Override
	public Armamento crear(Personaje pers) {
		ToleTole tole = new ToleTole(pers.obtenerCoordenadaXY(),time);
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
