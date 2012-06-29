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
		this.velocidadmaxima=0;
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
		/*como convencion aumenta la velocidad del personaje en 10 unidades.
		 * si se supera la velocidad maxima se arroja una excepcion.
		 */
		velocidad = velocidad - 1;
		if(velocidad >= this.velocidadmaxima){
			return;
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
