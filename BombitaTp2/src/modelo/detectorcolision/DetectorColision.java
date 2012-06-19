package modelo.detectorcolision;
import modelo.personaje.Bombita;


public class DetectorColision {

	public boolean ColicionProducida(Object primerPersonaje,Object segundoPersonaje){
			
		if ((primerPersonaje instanceof Bombita) || (segundoPersonaje instanceof Bombita))
			return true;
		else 
			return false;
	}
	
}
