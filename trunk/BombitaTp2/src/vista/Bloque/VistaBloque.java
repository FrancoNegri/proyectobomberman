package vista.Bloque;

import java.awt.Color;

import vista.fiuba.algo3.titiritero.dibujables.Cuadrado;
import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaBloque extends Cuadrado{

	
	public VistaBloque(ObjetoPosicionable obstaculoAMostrar){
		super(2,4,obstaculoAMostrar);
		this.setColor(Color.YELLOW);
	}
}
