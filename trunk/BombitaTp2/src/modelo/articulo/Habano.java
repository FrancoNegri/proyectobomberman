package modelo.articulo;

import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.errores.PersonajeNoInicializadoError;
import modelo.errores.VelocidadMaximaError;
import modelo.personaje.*;

public class Habano extends Articulo{
	
	private float velocidadmaxima;
	
	public Habano(Coordenada unaCoordenada){
		super(unaCoordenada);
		this.velocidadmaxima=35;
	}
	
	public boolean usar(Personaje unPersonaje){
		
		boolean bandera = false;
		if(unPersonaje==null){
			
			throw new PersonajeNoInicializadoError();
		}
		
		if( this.esBombita(unPersonaje)){	
			this.aumentarVelocidad(unPersonaje);
			bandera = true;
		}
		return bandera;
	}
	
	public void aumentarVelocidad(Personaje unPersonaje){
		
		float velocidad = unPersonaje.getVelocidad();
		/*como convencion aumenta la velocidad del personaje en 10 unidades.
		 * si se supera la velocidad maxima se arroja una excepcion.
		 */
		velocidad = velocidad + ConstantesJuego.velocidad_aumento_habano;
		if(velocidad >= this.velocidadmaxima){
			
			throw new VelocidadMaximaError();
		}
		
		else {
			
			unPersonaje.cambiarVelocidad(velocidad);
		}
		
	}

}
