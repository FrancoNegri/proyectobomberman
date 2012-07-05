package vista.fiuba.algo3.titiritero.dibujables;

import java.awt.Graphics;

import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import vista.fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;


public class Circulo extends Figura {

	private int radio;
	
	public Circulo(int radio, ObjetoPosicionable objetoPosicionable){
		super(objetoPosicionable);
		this.radio = radio;
	}

	public int getRadio() {
		return this.radio;
	}
	
	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
		Graphics grafico = ((SuperficiePanel)superfice).getBuffer();
		grafico.setColor(this.getColor());
		grafico.fillOval(getPosicionable().getX() *10 , getPosicionable().getY()*10, this.radio, this.radio);
	}
}
