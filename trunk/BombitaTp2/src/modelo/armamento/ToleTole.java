package modelo.armamento;

import modelo.ArmamentoFactory.ToleToleFactory;
import modelo.articulo.Articulable;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.*;

public class ToleTole extends Armamento implements Articulable {

	public ToleTole(Coordenada coordenada,Mapa mapa ,int unTime) {
		super(coordenada,mapa);
		time = unTime;
		radio = ConstantesJuego.radio_toletole;
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
}
