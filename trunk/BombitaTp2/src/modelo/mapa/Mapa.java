package modelo.mapa;

import modelo.articulo.Articulable;
import modelo.casillero.Casillero;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Personaje;
import modelo.errores.*;
import modelo.coordenadas.*;

public class Mapa {
	
	private Tablero TableroJuego;
	
	public Mapa(int tamanio){
		
		this.TableroJuego = new Tablero(tamanio);
		
	}
	
	public void agregarCasillero(int x, int y,  Casillero unCasillero){
		
		this.TableroJuego.cambiarCasillero(x, y, unCasillero);
		
	}
	
    public Casillero obtenerCasillero(int x, int y){
		
		return this.TableroJuego.obtenerCasillero(x, y);
		
	}
	
	public void agregarPersonaje(Personaje unPersonaje){
		
		Coordenada Coordenadas = unPersonaje.obtenerCoordenadaXY();
		Casillero CasilleroAux = this.obtenerCasillero(Coordenadas.obtenerCoordenadaX(), Coordenadas.obtenerCoordenadaY());
		this.verificarCasillero(CasilleroAux);		
		CasilleroAux.agregarPersonaje(unPersonaje);
		this.agregarCasillero(Coordenadas.obtenerCoordenadaX(), Coordenadas.obtenerCoordenadaY(), CasilleroAux);		
		
	}

	public void agregarArticulo(int x, int y, Articulable unArticulo){
		
		Casillero CasilleroAux = this.obtenerCasillero(x, y);
		this.verificarCasillero(CasilleroAux);
		CasilleroAux.cambiarArticulo(unArticulo);
		this.agregarCasillero(x, y, CasilleroAux);
		
	}
	
	public void agregarBloque(int x, int y, Obstaculo unObstaculo){
		
		Casillero CasilleroAux = this.obtenerCasillero(x, y);
		this.verificarCasillero(CasilleroAux);
		CasilleroAux.cambiarObstaculo(unObstaculo);
		this.agregarCasillero(x, y, CasilleroAux);
		
	}
	
	private void verificarCasillero(Casillero unCasillero){
		
		if(unCasillero.estaVacio() == false){
			
			throw new CasilleroOcupadoError(); 
			
		}
		
	}
}