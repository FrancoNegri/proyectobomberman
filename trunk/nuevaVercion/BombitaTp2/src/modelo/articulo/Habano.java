package modelo.articulo;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;

import vista.objeto.VistaObjeto;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.errores.PersonajeNoInicializadoError;
import modelo.errores.VelocidadMaximaError;
import modelo.personaje.*;

public class Habano extends Articulo{
	
	private int velocidadmaxima;
	
	public Habano(Coordenada unaCoordenada){
		super(unaCoordenada);
		this.velocidadmaxima = 20;
	}
	
	public void usar(Personaje unPersonaje){
		
		if(unPersonaje==null){
			
			throw new PersonajeNoInicializadoError();
		}
		
		else{	
			this.aumentarVelocidad(unPersonaje);
			
		}
		
	}
	
	public void aumentarVelocidad(Personaje unPersonaje){
		
		int velocidad = unPersonaje.getVelocidad();

		velocidad = velocidad + 10;
		if(velocidad > this.velocidadmaxima){
			unPersonaje.cambiarVelocidad(20);
		}
		else {
			unPersonaje.cambiarVelocidad(velocidad);
		}
		
	}

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConHabano(this);		
	}

	public Element guardar() {
		Element elemObstaculo = DocumentHelper.createElement("Habano");
		super.guardar(elemObstaculo);
		return elemObstaculo;
	}
	
	public static Habano recuperar(Element elemArticulo ){
		Coordenada coordenada = Coordenada.recuperar(elemArticulo.element(new QName ("Coordenada")));
		Habano unHabano = new Habano(coordenada);
		return unHabano;
		
		
	}

}
