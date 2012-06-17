package modelo.ArmamentoFactory;

import modelo.armamento.Armamento;
import modelo.coordenadas.Coordenada;

public abstract class ArmamentoFactory {
	public abstract Armamento crear(Coordenada coord);
	public abstract void  cambiarTime(int tiempo);
	public abstract int obtenerTime();
}
