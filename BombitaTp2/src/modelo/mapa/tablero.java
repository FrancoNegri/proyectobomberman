package modelo.mapa;

import modelo.casillero.casillero;
import modelo.casillerotest.*;
import modelo.errores.*;

public class tablero {
	
	private casillero casilleros[][];
	
	private int tamanio;
	
	/*como dijimos el mapa va a ser cuadrado por lo tanto
	 * se le pasa al constructor una sola coordenada.
	 */
	public void tablero(int tamanio){
		
		this.tamanioValido(tamanio);
		this.tamanio=tamanio;
		this.casilleros= new casillero[tamanio][tamanio];
		this.cargarMatriz(this.casilleros, this.tamanio);
		
	}
	
	public casillero obtenerCasillero(int x, int y){
		
		this.tamanioValido(x);
		this.tamanioValido(y);
		return this.casilleros[x][y];
		
	}
	
	public void cambiarCasillero(int x, int y, casillero UnCasillero){
		
		this.tamanioValido(x);
		this.tamanioValido(y);
		this.casilleros[x][y] = UnCasillero;
		
	}
	
	private void tamanioValido(int tamanio){
		
		
		if((tamanio<=0)|| (tamanio>this.tamanio)){
			
			throw new TamanioMatrizInvalidoError();
		}
		
		
	}
	
	private void cargarMatriz(casillero matriz[][], int tamanio){
		
			for(int i=1 ; i<=tamanio ; i++){
			
					for(int j=1; j<=tamanio ; j++){
				
					casillero unCasillero = new casillero();
					matriz[i][j] = unCasillero;
					
					}
			}
		
	}
	
	

}
