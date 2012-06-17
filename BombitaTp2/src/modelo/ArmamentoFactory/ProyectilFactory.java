package modelo.ArmamentoFactory;

import modelo.armamento.Armamento;
import modelo.armamento.Proyectil;
import modelo.coordenadas.Coordenada;

public class ProyectilFactory extends ArmamentoFactory {
	private int time = 0;
	@Override
	public Armamento crear(Coordenada coord) {
		Proyectil proyectil = new Proyectil(coord,null);//a solucionar
		return proyectil;
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
