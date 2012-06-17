package modelo.articulo;

import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.errores.ArmamentoNoInicializadoError;
import modelo.errores.TiempoInvalidoError;
import modelo.personaje.Bombita;
public class Timer extends Articulo {
	
	public Timer(){
		
	}

	public void usar(Bombita unPersonaje){
		ArmamentoFactory ArmaPersonaje = unPersonaje.tirarArmamento();
		
		if (ArmaPersonaje==null){
			throw new ArmamentoNoInicializadoError();
		}
		else{
			this.reducirTiempo(ArmaPersonaje);
			unPersonaje.cambiarArmamento(ArmaPersonaje);
		}
	}
	
	public void reducirTiempo(ArmamentoFactory unArmamento){
		
		int tiempo = unArmamento.obtenerTime();//Tiempo en milisegundos para no tener que estar manejando floats
		//formula de reduccion de tiempo
		if (tiempo<=0){
			
			throw new TiempoInvalidoError();
		}
		int reduccion = (int) ((tiempo*15)/100);
		tiempo = tiempo - reduccion;
		unArmamento.cambiarTime(tiempo);
	}

}