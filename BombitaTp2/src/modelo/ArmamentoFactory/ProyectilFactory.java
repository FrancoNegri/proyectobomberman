package modelo.ArmamentoFactory;

import modelo.Translacion.Translacion;
import modelo.armamento.Armamento;
import modelo.armamento.Proyectil;
import modelo.coordenadas.Coordenada;

public class ProyectilFactory extends ArmamentoFactory{
	private int time = 0;
	//tendria que ser algo asi
	public Armamento crear(Coordenada coord,Translacion trans) {
		Proyectil proyectil = new Proyectil(coord,trans);
		return proyectil;
	}

	@Override
	public Armamento crear(Coordenada coord) {
		return null;
	}

	@Override
	public void cambiarTime(int tiempo) {
		time = tiempo;
	}

	@Override
	public int obtenerTime() {
		return time;
	}
}
