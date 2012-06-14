package modelo.mapa;



import modelo.casillero.Casillero;

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
	
	
}