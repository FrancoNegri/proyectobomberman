		package modelo.ArmamentoFactory;

import modelo.armamento.*;
import modelo.coordenadas.Coordenada;

public class MolotovFactory extends ArmamentoFactory{

	private int time = 0;
	public Molotov crear(Coordenada coord) {
		Molotov molotov = new Molotov(coord,time);
		return molotov;
	}

	public void cambiarTime(int unTime) {
		time = unTime;
	}
	public int obtenerTime() {
		return time;
	}
}
