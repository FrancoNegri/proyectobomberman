		package modelo.ArmamentoFactory;

import modelo.armamento.*;
import modelo.personaje.Personaje;

public class MolotovFactory extends ArmamentoFactory{

	private int time = 1;
	public Molotov crear(Personaje pers) {
		Molotov molotov = new Molotov(pers.obtenerCoordenadaXY(),time);
		return molotov;
	}

	public void cambiarTime(int unTime) {
		time = unTime;
	}
	public int obtenerTime() {
		return time;
	}
}
