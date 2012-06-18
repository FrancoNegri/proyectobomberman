package modelo.ArmamentoFactory;

import modelo.armamento.Armamento;
import modelo.armamento.Proyectil;
import modelo.personaje.Personaje;

public class ProyectilFactory extends ArmamentoFactory{
	private int time = 0;
	@Override
	public Armamento crear(Personaje pers) {
		// nesesito pasarle alguna translacion para que se mueva de la manera correcta
		Proyectil proyectil = new Proyectil(pers.obtenerCoordenadaXY(),time);
		return proyectil;
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
