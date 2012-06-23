package vista.Armamento;

import java.awt.Color;
import java.io.IOException;

import modelo.armamento.Armamento;
import modelo.armamento.Proyectil;
import vista.fiuba.algo3.titiritero.dibujables.Circulo;
import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaArmamento extends Circulo {
		public  VistaArmamento(Armamento modelo) throws IOException {
			super(10, modelo);
			this.setColor(Color.blue);
		}
		//no funciona el polinorfismo hay que usar double dispatch
		public  VistaArmamento(Proyectil modelo) throws IOException {
			super(10, modelo);
			this.setColor(Color.RED);
		}
}
