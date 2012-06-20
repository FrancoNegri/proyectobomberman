package modelo.armamento;

import modelo.ArmamentoFactory.ToleToleFactory;
import modelo.articulo.Articulable;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.Bombita;

public class ToleTole extends Armamento implements Articulable {

	public ToleTole(Coordenada coordenada,Mapa mapa ,int unTime) {
		super(coordenada,mapa);
		this.time = unTime;
		this.radio = ConstantesJuego.radio_toletole;
	}
	
	public void usar(Bombita unPersonaje){
		ToleToleFactory nuevaFactory = new ToleToleFactory();
		unPersonaje.cambiarArmamento(nuevaFactory);
	}
}
