package modelo.mapa;


import modelo.articulo.*;
import modelo.casillero.Casillero;

public class Mapa {
	
	private Tablero TableroJuego;
	
	public Mapa(int tamanio){
		
		this.TableroJuego = new Tablero(tamanio);
		
	}
	
	private void agregarCasillero(int x, int y,  Casillero unCasillero){
		
		this.TableroJuego.cambiarCasillero(x, y, unCasillero);
		
	}
	
	private Casillero obtenerCasillero(int x, int y){
		
		return this.TableroJuego.obtenerCasillero(x, y);
		
	}
	
	public void agregarArticulo (int x, int y, Articulo Unarticulo){
		
		Casillero casilleroauxiliar= this.obtenerCasillero(x, y);
		casilleroauxiliar.agregar(Unarticulo);
		this.agregarCasillero(x, y, casilleroauxiliar);
	
	}
	
}