package modelo.articulo;

import modelo.personaje.Bombita;
import modelo.errores.*;

public class Habano extends Articulo{
	
	private float velocidadmaxima;
	
	public Habano(){
		
		this.velocidadmaxima=35;
	}
	
	public void usar(Bombita unPersonaje){
		
		if(unPersonaje==null){
			
			throw new PersonajeNoInicializadoError();
		}
		else{
			
			this.aumentarVelocidad(unPersonaje);
		}
		
	}
	
	public void aumentarVelocidad(Bombita unPersonaje){
		
		float velocidad = unPersonaje.getVelocidad();
		/*como convencion aumenta la velocidad del personaje en 10 unidades.
		 * si se supera la velocidad maxima se arroja una excepcion.
		 */
		velocidad+=10;
		if(velocidad >= this.velocidadmaxima){
			
			throw new VelocidadMaximaError();
		}
		
		else {
			
			unPersonaje.cambiarVelocidad(velocidad);
		}
		
	}

}
