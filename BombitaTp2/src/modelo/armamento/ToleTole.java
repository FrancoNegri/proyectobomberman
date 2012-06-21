package modelo.armamento;

import modelo.ArmamentoFactory.ToleToleFactory;
import modelo.articulo.Articulable;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.*;

public class ToleTole extends Armamento implements Articulable {

	private int puntaje;
	
	public ToleTole(Coordenada coordenada,Mapa mapa ,int unTime) {
		super(coordenada,mapa);
		this.time = unTime;
		this.radio = ConstantesJuego.radio_toletole;
		this.puntaje = ConstantesJuego.puntaje_articulos;
	}
	
	public boolean usar(Personaje unPersonaje){
		
		boolean bandera = false;
		if(this.esBombita(unPersonaje)){
			
			ToleToleFactory nuevaFactory = new ToleToleFactory();
			unPersonaje.cambiarArmamento(nuevaFactory);
			bandera = true;
		}
		return bandera;
	}
	
	public boolean esBombita(Personaje unPersonaje){
		
		boolean esBombita = false;
		if ( unPersonaje instanceof Bombita)
			esBombita = true;
		return esBombita;
	}
	
	public int obtenerPuntaje() {
		return puntaje;
	}
}
