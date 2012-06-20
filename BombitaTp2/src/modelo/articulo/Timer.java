package modelo.articulo;

import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.coordenadas.Coordenada;
import modelo.errores.ArmamentoNoInicializadoError;
import modelo.errores.TiempoInvalidoError;
import modelo.personaje.*;
public class Timer extends Articulo {
	
	public Timer(Coordenada unaCoordenada){
		super(unaCoordenada);
	}

	public boolean usar(Personaje unPersonaje){
		ArmamentoFactory ArmaPersonaje = unPersonaje.tirarArmamento();
		boolean bandera = false;
		if (ArmaPersonaje==null){
			throw new ArmamentoNoInicializadoError();
		}
		
		if (this.esBombita(unPersonaje)){
			
			this.reducirTiempo(ArmaPersonaje);
			unPersonaje.cambiarArmamento(ArmaPersonaje);
			bandera = true;
		}
		
		return bandera;
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
