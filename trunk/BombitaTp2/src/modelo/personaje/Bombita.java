package modelo.personaje;

import vista.objeto.VistaObjeto;
import modelo.ArmamentoFactory.*;
import modelo.Translacion.Translacion;
import modelo.articulo.Articulable;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;

public class Bombita extends Personaje {

	
	public Bombita(Coordenada unaCoordenada,Mapa nuevoMapa) {
		super(unaCoordenada,nuevoMapa);
		this.velocidad = ConstantesJuego.velocidad_bombita;
		this.vida = ConstantesJuego.velocidad_bombita;
		this.CreadorDeBombas = new MolotovFactory();
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

	@Override
	protected void Atacar() {
		//Aca iria la accion de plantar la bomba por parte del teclado
		//En este momento bombita no ataca
	}

	@Override
	protected Translacion obtenerTranslacion() {
		// TODO Auto-generated method stub
		return null;
	}

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConBombita(this);
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
