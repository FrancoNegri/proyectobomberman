package modelo.mapa;

import modelo.armamento.Armamento;
import modelo.articulo.Articulable;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.errores.CasilleroOcupadoError;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Personaje;

public class Mapa {
	private Tablero TableroJuego;
	
	public Mapa(int tamanio) {
		this.TableroJuego = new Tablero(tamanio);
	}
	
	private void agregarCasillero(Coordenada coord, Casillero unCasillero) {

		this.TableroJuego.cambiarCasillero(coord, unCasillero);

	}

	private void verificarCasillero(Casillero unCasillero) {
		if (unCasillero.esCaminable() == false) {
			throw new CasilleroOcupadoError();
		}
	}
	
	public Casillero obtenerCasillero(Coordenada coord) {
		return this.TableroJuego.obtenerCasillero(coord);
	}

	public void agregarAlMapa(Personaje unPersonaje) {
		
		Coordenada coordenada = unPersonaje.obtenerCoordenadaXY();
		Casillero CasilleroAux = this.obtenerCasillero(coordenada);
		this.verificarCasillero(CasilleroAux);
		CasilleroAux.agregar(unPersonaje);
		this.agregarCasillero(coordenada, CasilleroAux);
	}
	
	public void agregarAlMapa(Obstaculo obstaculo) {
		
		Coordenada coordenada = obstaculo.obtenerCoordenadaXY();
		Casillero CasilleroAux = this.obtenerCasillero(coordenada);
		this.verificarCasillero(CasilleroAux);
		CasilleroAux.agregar(obstaculo);
		this.agregarCasillero(coordenada, CasilleroAux);
	}
	
	public void agregarAlMapa(Armamento unArmamento) {
		
		Coordenada coordenada = unArmamento.obtenerCoordenadaXY();
		Casillero CasilleroAux = this.obtenerCasillero(coordenada);
		this.verificarCasillero(CasilleroAux);
		CasilleroAux.agregar(unArmamento);
		this.agregarCasillero(coordenada, CasilleroAux);
	}

	public void agregarAlMapa(Articulable unArticulo) {
		Coordenada coord = unArticulo.obtenerCoordenadaXY();
		Casillero CasilleroAux = this.obtenerCasillero(coord);
		CasilleroAux.agregar(unArticulo);
		this.agregarCasillero(coord, CasilleroAux);
	}

	public void actualizarMapa() {
		//Mientras Bombita este vivo,
		//Hacer un for y borrar todos los personajes muertos
	}

	public void eliminarPersonaje(Personaje unPersonaje) {
		// Eliminar un personaje cuando haya muerto
	}	
}