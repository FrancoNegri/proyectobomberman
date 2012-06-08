package modelo.articulo;

import modelo.armamento.Armamento;
import modelo.personaje.Bombita;

public class Timer extends Articulo {
	
	public Timer(){
		
	}

	public void usar(Bombita unPersonaje){
		
		Armamento ArmaPersonaje = unPersonaje.armamentoActual();
		this.reducirTiempo(ArmaPersonaje);
		unPersonaje.cambiarArmamento(ArmaPersonaje);
		
	}
	
	public void reducirTiempo(Armamento unArmamento){
		
		float tiempo = unArmamento.obtenerTime();
		//formula de reduccion de tiempo
		float reduccion= (tiempo*15)/100;
		tiempo = tiempo - reduccion;
		unArmamento.cambiarTime(tiempo);
	}

}
