package vista.Articulo;

import java.awt.Color;

import vista.fiuba.algo3.titiritero.dibujables.Cuadrado;
import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaArticulo extends Cuadrado {

	public VistaArticulo(ObjetoPosicionable articuloADibujar){
			super(10,4,articuloADibujar);
			this.setColor(Color.ORANGE);
		}
}
