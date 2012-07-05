package modelo.ArmamentoFactory;

import org.dom4j.*;

import modelo.armamento.Armamento;
import modelo.personaje.Personaje;

public abstract class ArmamentoFactory {
	public abstract Armamento crear(Personaje pers);
	public abstract void  cambiarTime(int tiempo);
	public abstract int obtenerTime();
	public Element guardar() {
		Element ElemArmamFactory = DocumentHelper.createElement("ArmamentoFactory");
		return ElemArmamFactory;
	}
}
