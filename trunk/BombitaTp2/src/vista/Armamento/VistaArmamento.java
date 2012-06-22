package vista.Armamento;

import java.awt.Color;
import java.io.IOException;
import vista.fiuba.algo3.titiritero.dibujables.Circulo;
import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaArmamento extends Circulo {
		public  VistaArmamento(ObjetoPosicionable modelo) throws IOException {
			super(10, modelo);
			this.setColor(Color.blue);
		}
}
