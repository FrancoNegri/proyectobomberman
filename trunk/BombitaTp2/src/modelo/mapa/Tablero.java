package modelo.mapa;

import modelo.casillero.Casillero;
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
	
	public Casillero obtenerCasillero(int x, int y){
		
		this.tamanioValido(x);
		this.tamanioValido(y);
		return this.casilleros[x][y];
		
	}
	
	public void cambiarCasillero(int x, int y, Casillero UnCasillero){
		
		this.tamanioValido(x);
		this.tamanioValido(y);
		this.casilleros[x][y] = UnCasillero;
		
	}
	
	private void tamanioValido(int tamanio){
		
		
		if((tamanio<=0)|| (tamanio>this.obtenerTamanio())){
			
			throw new TamanioMatrizInvalidoError();
		}
		
		
	}
	
	private void cargarMatriz(Casillero matriz[][], int tamanio){
		
			for(int i=1 ; i<=tamanio ; i++){
			
					for(int j=1; j<=tamanio ; j++){
				
					Casillero unCasillero = new Casillero();
					matriz[i][j] = unCasillero;
					
					}
			}
		
	}
	
	public int obtenerTamanio(){
		
		return this.tamanio;
		
	}
	

}
