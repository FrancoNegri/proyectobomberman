package modelo.mapa;



import modelo.articulo.Articulable;
import modelo.casillero.Casillero;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Personaje;

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
	
	public void modificarCasillero(int x, int y, Casillero unCasillero, Mapa unMapa ){
		if (unCasillero.estaVacio()) {
			unMapa.agregarCasillero(x, y, unCasillero);
		//Agregar excepcion para ver cuando el casillero no esta vacio
		}
	}
	
	public void agregarPersonaje(Personaje unPersonaje, Mapa unMapa ){
		
	}

	public void agregarArticulo(int x, int y, Articulable unArticulo, Mapa unMapa ){
		
	}
	
	public void agregarBloque(int x, int y, Obstaculo unObstaculo, Mapa unMapa){
		
	}
}