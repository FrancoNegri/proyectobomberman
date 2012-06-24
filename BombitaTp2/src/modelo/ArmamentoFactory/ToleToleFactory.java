package modelo.ArmamentoFactory;

import org.dom4j.Element;

import modelo.armamento.Armamento;
import modelo.armamento.ToleTole;
import modelo.constantesjuego.ConstantesJuego;
import modelo.personaje.Personaje;

public class ToleToleFactory extends ArmamentoFactory{
	private int time = ConstantesJuego.timer_toletole;
	
	@Override
	public Armamento crear(Personaje pers) {
		ToleTole tole = new ToleTole(pers.obtenerCoordenadaXY(),pers.getMapa(),time);
		return tole;
	}

	@Override
	public void cambiarTime(int unTime) {
		this.time = unTime;
	}

	@Override
	public int obtenerTime() {
		return time;
	}
	
	@Override
	public Element guardar() {
		Element ElemArmamFactory = super.guardar();
		ElemArmamFactory.addAttribute("Tipo", "ToleToleFactory");
		return ElemArmamFactory;
	}
	
}
