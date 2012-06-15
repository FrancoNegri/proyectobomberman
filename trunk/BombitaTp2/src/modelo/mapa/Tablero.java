package modelo.mapa;

import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.errores.*;

public class Tablero {
	
	private Casillero casilleros[][];
	
	private int tamanio;
	
	/*como dijimos el mapa va a ser cuadrado por lo tanto
	 * se le pasa al constructor una sola coordenada.
	 */
	public Tablero(int tamanio){
		
		this.tamanioValido(tamanio);
		this.tamanio=tamanio;
		this.casilleros= new Casillero[tamanio][tamanio];
		this.cargarMatriz(this.casilleros, this.obtenerTamanio());
		
	}
	
	public Casillero obtenerCasillero(Coordenada coord){
		
		this.verificarTamanio(coord.obtenerCoordenadaX());
		this.verificarTamanio(coord.obtenerCoordenadaY());
		return this.casilleros[coord.obtenerCoordenadaX()][coord.obtenerCoordenadaY()];
		
	}
	
	public void cambiarCasillero(Coordenada coord, Casillero UnCasillero){
		
		this.verificarTamanio(coord.obtenerCoordenadaX());
		this.verificarTamanio(coord.obtenerCoordenadaY());
		this.casilleros[coord.obtenerCoordenadaX()][coord.obtenerCoordenadaY()] = UnCasillero;
		
	}
	
	private void tamanioValido(int tamanio){
		
			if(tamanio<=0){
				throw new TamanioMatrizInvalidoError();
			}
		
	}
	
	private void verificarTamanio(int tamanio){
		
		this.tamanioValido(tamanio);
		if(tamanio>=this.tamanio){
			
			throw new TamanioMatrizInvalidoError();
		}
		
		
	}
	
	private void cargarMatriz(Casillero matriz[][], int tamanio){
		
			for(int i=0 ; i<tamanio ; i++){
			
					for(int j=0; j<tamanio ; j++){
				
					Casillero unCasillero = new Casillero();
					matriz[i][j] = unCasillero;
					
					}
			}
		
	}
	
	public int obtenerTamanio(){
		
		return this.tamanio;
		
	}
	

}
