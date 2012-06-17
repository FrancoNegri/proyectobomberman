package modelo.personaje;

import modelo.armamento.Armamento;
import modelo.armamento.Molotov;
import modelo.articulo.Articulable;
import modelo.coordenadas.Coordenada;

public class Bombita extends Personaje {

	
	public Bombita(Coordenada unaCoordenada) {
		super(unaCoordenada);//Llama Inisializador de personaje
		this.velocidad = 5;
		this.vida = 100;
		this.bomba = new Molotov();
	}
	
	public void tomarArticulo(Articulable unArticulo) {
		unArticulo.usar(this);
	}

	public void cambiarArmamento(Armamento unArmamento) {
		this.bomba = unArmamento;
	}
	
	public void morir() {
		this.vida = 0;
	}
	public void Chocar() {
		this.vida = this.vida -1;// O Cuanto saca?
	}
}
