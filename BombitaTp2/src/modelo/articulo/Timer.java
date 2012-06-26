package modelo.articulo;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;

import vista.objeto.VistaObjeto;
import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.coordenadas.Coordenada;
import modelo.errores.ArmamentoNoInicializadoError;
import modelo.errores.TiempoInvalidoError;
import modelo.personaje.*;
public class Timer extends Articulo {
	
	public Timer(Coordenada unaCoordenada){
		super(unaCoordenada);
	}

	public void usar(Personaje unPersonaje){
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

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarTimer(this);
	}
	
	public Element guardar() {
		Element elemObstaculo = DocumentHelper.createElement("Timer");
		super.guardar(elemObstaculo);
		return elemObstaculo;
	}
	
	public Timer recuperar(Element elemArticulo ){
		Coordenada coordenada = Coordenada.recuperar(elemArticulo.element(new QName ("Coordenada")));
		Timer unTimer = new Timer(coordenada);
		return unTimer;
	}
}
