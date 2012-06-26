package modelo.ArmamentoFactory;

import org.dom4j.Element;

import modelo.armamento.*;
import modelo.constantesjuego.ConstantesJuego;
import modelo.personaje.Personaje;

public class MolotovFactory extends ArmamentoFactory{

	private int time = ConstantesJuego.timer_molotov;
	
	public Armamento crear(Personaje pers) {
		Molotov molotov = new Molotov(pers.obtenerCoordenadaXY(),pers.getMapa(),time);
		return molotov;
	}

	public void cambiarTime(int unTime) {
		this.time = unTime;
	}
	public int obtenerTime() {
		return time;
	}

	@Override
	public Element guardar() {
		Element ElemArmamFactory = super.guardar();
		ElemArmamFactory.addAttribute("Tipo", "ArmamentoFactory");
		return ElemArmamFactory;
	}
}
