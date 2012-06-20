package modelo.ArmamentoFactory;

import modelo.armamento.Armamento;
import modelo.armamento.Proyectil;
import modelo.constantesjuego.ConstantesJuego;
import modelo.personaje.Personaje;

public class ProyectilFactory extends ArmamentoFactory{
	private int time = ConstantesJuego.timer_proyectil;
	@Override
	public Armamento crear(Personaje pers) {
		// Creo una bomba y la pasa al mapa
		Proyectil proyectil = new Proyectil(pers.obtenerCoordenadaXY(),pers.getMapa(),pers.obtenerUltimaTranslacion());
		return proyectil;
	}

	@Override
	public void cambiarTime(int tiempo) {
		// no tiene mayor sentido solo para respetar el contrato
		this.time = tiempo;
	}

	@Override
	public int obtenerTime() {
		return time;
	}
}
