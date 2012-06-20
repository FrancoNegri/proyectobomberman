package modelo.personaje;

import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.ArmamentoFactory.MolotovFactory;
import modelo.Translacion.Translacion;
import modelo.articulo.Articulable;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;

public class Bombita extends Personaje {

	private int puntaje;
	
	public Bombita(Coordenada unaCoordenada) {
		super(unaCoordenada);
		this.velocidad = ConstantesJuego.velocidad_bombita;
		this.vida = ConstantesJuego.velocidad_bombita;
		this.CreadorDeBombas = new MolotovFactory();
		this.puntaje = 0;
	}
	
	public void tomarArticulo(Articulable unArticulo) {
		unArticulo.usar(this);
	}

	
	public void morir() {
		this.vida = 0;
	}
	
	public void chocar() {
		this.morir();
	}
	
	public void actualizarPuntaje(int unPuntaje){
		this.puntaje = puntaje + unPuntaje;
	}
	
	public int obtenerPuntaje() {
		return puntaje;
	}

	@Override
	protected void Atacar() {
	}

	@Override
	protected Translacion obtenerTranslacion() {
		return null;
	}

	/*public void caminar(char unaLetra) {
	 * Para obtener un movimiento desde el teclado
	 * if (unaLetraEsValida) {
		if (unaLetra = w) -> translacion arriba
		if (unaLetra = s) -> translacion abajo
		if (unaLetra = a) -> translacion izquierda
		if (unaLetra = d) -> translacion derecha
		}
	}*/
}
