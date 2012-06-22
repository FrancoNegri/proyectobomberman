package vista.Personaje;

import java.awt.Color;
import java.io.IOException;

import vista.fiuba.algo3.titiritero.dibujables.Cuadrado;
import vista.fiuba.algo3.titiritero.dibujables.Imagen;
import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class vistaPersonaje extends Cuadrado {
	public vistaPersonaje(ObjetoPosicionable modelo) throws IOException {
		super(30, 10, modelo);
		this.setColor(Color.GREEN);
	}
}
