package modelo.ArmamentoFactory;

import modelo.armamento.Armamento;
import modelo.personaje.Personaje;

public abstract class ArmamentoFactory {
	public abstract Armamento crear(Personaje pers);
	public abstract void  cambiarTime(int tiempo);
	public abstract int obtenerTime();
}
