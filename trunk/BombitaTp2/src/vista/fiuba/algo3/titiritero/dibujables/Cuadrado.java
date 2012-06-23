package vista.fiuba.algo3.titiritero.dibujables;

import java.awt.Graphics;

import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import vista.fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class Cuadrado extends Figura {

	private int ancho;
	private int alto;
	
	public Cuadrado(int ancho, int alto, ObjetoPosicionable objetoPosicionable){
		super(objetoPosicionable);
		this.ancho = ancho;
		this.alto = alto;
	}

	
	@Override
	public void dibujar(SuperficieDeDibujo superfice) {
		Graphics grafico = ((SuperficiePanel)superfice).getBuffer();
		grafico.setColor(this.getColor());
		grafico.fillRect(getPosicionable().getX()*5 , getPosicionable().getY()*5, this.ancho, this.alto);
	}
}
