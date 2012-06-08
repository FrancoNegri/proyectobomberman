package modelo.articulo;

import modelo.armamento.Armamento;
import modelo.personaje.Bombita;
import modelo.errores.*;

public class Timer extends Articulo {
	
	public Timer(){
		
	}

	public void usar(Bombita unPersonaje){
		
		Armamento ArmaPersonaje = unPersonaje.armamentoActual();
		
		if (ArmaPersonaje==null){
			
			throw new ArmamentoNoInicializadoError();
		}
		else{
			
			this.reducirTiempo(ArmaPersonaje);
			unPersonaje.cambiarArmamento(ArmaPersonaje);
		}
	}
	
	public void reducirTiempo(Armamento unArmamento){
		
		float tiempo = unArmamento.obtenerTime();
		//formula de reduccion de tiempo
		
		if (tiempo<=0){
			
			throw new TiempoInvalidoError();
		}
		float reduccion= (tiempo*15)/100;
		tiempo = tiempo - reduccion;
		unArmamento.cambiarTime(tiempo);
	}

}
