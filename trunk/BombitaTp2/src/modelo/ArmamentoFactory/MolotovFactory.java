		package modelo.ArmamentoFactory;

import modelo.armamento.*;
import modelo.constantesjuego.ConstantesJuego;
import modelo.personaje.Personaje;

public class MolotovFactory extends ArmamentoFactory{

	private int time = ConstantesJuego.timer_molotov;
	
	public Molotov crear(Personaje pers) {
		Molotov molotov = new Molotov(pers.obtenerCoordenadaXY(),time);
		return molotov;
	}

	public void cambiarTime(int unTime) {
		this.time = unTime;
	}
	public int obtenerTime() {
		return time;
	}
}
