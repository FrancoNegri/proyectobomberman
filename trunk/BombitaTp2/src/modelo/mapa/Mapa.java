package modelo.mapa;

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

	public void agregarCasillero(Coordenada coord, Casillero unCasillero) {

		this.TableroJuego.cambiarCasillero(coord, unCasillero);

	}

	public Casillero obtenerCasillero(Coordenada coord) {
		return this.TableroJuego.obtenerCasillero(coord);
	}

	public void agregarPersonaje(Personaje unPersonaje) {

		Coordenada coordenada = unPersonaje.obtenerCoordenadaXY();
		Casillero CasilleroAux = this.obtenerCasillero(coordenada);
		this.verificarCasillero(CasilleroAux);
		CasilleroAux.agregar(unPersonaje);
		this.agregarCasillero(coordenada, CasilleroAux);

	}

	public void agregarArticulo(Coordenada coord, Articulable unArticulo) {

		Casillero CasilleroAux = this.obtenerCasillero(coord);
		this.verificarCasillero(CasilleroAux);
		CasilleroAux.agregar(unArticulo);
		this.agregarCasillero(coord, CasilleroAux);

	}

	public void agregarBloque(Coordenada coord, Obstaculo unObstaculo) {

		Casillero CasilleroAux = this.obtenerCasillero(coord);
		this.verificarCasillero(CasilleroAux);
		CasilleroAux.agregar(unObstaculo);
		this.agregarCasillero(coord, CasilleroAux);

	}

	private void verificarCasillero(Casillero unCasillero) {
		if (unCasillero.esCaminable() == false) {
			throw new CasilleroOcupadoError();
		}
	}

	public void actualizarMapa() {
		// Aca deberia verificar si hay personajes muertos, si el juego esta
		// ganado o perdido y algo mas
	}

	public void eliminarPersonaje(Personaje unPersonaje) {
		// Eliminar un personaje cuando haya muerto
	}
}