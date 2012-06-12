package modelo.mapa;

import modelo.casillero.*;

import modelo.articulo.*;

public class Mapa {
	
	private tablero TableroJuego;
	
	public void Mapa(int tamanio){
		
		this.TableroJuego = new tablero(tamanio);
		
	}
	
	private void agregarCasillero(int x, int y,  casillero unCasillero){
		
		this.TableroJuego.cambiarCasillero(x, y, unCasillero);
		
	}
	
	private casillero obtenerCasillero(int x, int y){
		
		return this.TableroJuego.obtenerCasillero(x, y);
		
	}
	
	public void agregarArticulo (int x, int y, Articulo Unarticulo){
		
		casillero casilleroauxiliar= this.obtenerCasillero(x, y);
		casilleroauxiliar.agregarArticulo(Unarticulo);
		this.agregarCasillero(x, y, casilleroauxiliar);
	
	}
	
}