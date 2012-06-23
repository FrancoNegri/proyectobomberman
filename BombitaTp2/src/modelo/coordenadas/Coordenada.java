package modelo.coordenadas;

import modelo.errores.coordenadaInvalida;

public class Coordenada {
	
	private int x;
	private int y;
	
	public Coordenada(int X, int Y){
		this.ComprobarCoordenadaValida(X);
		this.ComprobarCoordenadaValida(Y);
		this.cambiarCoordenadaX(X);
		this.cambiarCoordenadaY(Y);
		
	}

	public Coordenada copiar(){
		Coordenada nuevaCoordenada = new Coordenada(x,y);
		return nuevaCoordenada;
	}
	
	public int obtenerCoordenadaX() {
		return x;
	}

	public void cambiarCoordenadaX(int X) {
		this.ComprobarCoordenadaValida(X);
		this.x = X;
	}

	public int obtenerCoordenadaY() {
		return y;
	}

	public void cambiarCoordenadaY(int Y) {
		this.ComprobarCoordenadaValida(Y);
		this.y = Y;
	}
	
	private void ComprobarCoordenadaValida(int valor){
		if(valor < 0){
			throw new coordenadaInvalida();
		}
	}
	public boolean equals(Coordenada otraCoord){
		if((otraCoord.obtenerCoordenadaX()==this.x)&&(otraCoord.obtenerCoordenadaY()==this.y)){
			return true;
		}
		return false;
	}
}

