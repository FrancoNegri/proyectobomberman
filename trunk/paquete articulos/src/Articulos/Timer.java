package Articulos;

import Personajes.Personaje;

import Armamentos.Armamento;

public class Timer implements Articulo {

	public void Usar(Personaje unPersonaje){
		
		Armamento ArmaPersonaje= unPersonaje.ArmamentoActual();
		this.reducirtiempo(ArmaPersonaje);
		unPersonaje.CambiarArmamento(ArmaPersonaje);
		
	}
	
	public void reducirtiempo(Armamento unArmamento){
		
		int tiempo=unArmamento.Time();
		//formula de reduccion de tiempo
		int reduccion= (tiempo*15)/100;
		tiempo=tiempo-reduccion;
		unArmamento.setTime(tiempo);
	}

}
