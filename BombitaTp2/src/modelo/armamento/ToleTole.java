package modelo.armamento;

import modelo.ArmamentoFactory.ToleToleFactory;
import modelo.articulo.Articulable;
import modelo.coordenadas.Coordenada;
import modelo.personaje.Bombita;

public class ToleTole extends Armamento implements Articulable {

	public ToleTole(Coordenada coordenada) {
		super(coordenada);
		this.time = 5;
	}
	
	public void usar(Bombita unPersonaje){
		ToleToleFactory nuevaFactory = new ToleToleFactory();
		unPersonaje.cambiarArmamento(nuevaFactory);
	}
}
