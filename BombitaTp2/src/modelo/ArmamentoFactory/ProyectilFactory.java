package modelo.ArmamentoFactory;

import modelo.armamento.Armamento;
import modelo.armamento.Proyectil;
import modelo.constantesjuego.ConstantesJuego;
import modelo.personaje.Personaje;

public class ProyectilFactory extends ArmamentoFactory{
	private int time = ConstantesJuego.timer_proyectil;
	@Override
	public Armamento crear(Personaje pers) {
		// nesesito pasarle alguna translacion para que se mueva de la manera correcta
		Proyectil proyectil = new Proyectil(pers.obtenerCoordenadaXY(),time);
		return proyectil;
	}

	@Override
	public void cambiarTime(int tiempo) {
		this.time = tiempo;
	}

	@Override
	public int obtenerTime() {
		return time;
	}
}
