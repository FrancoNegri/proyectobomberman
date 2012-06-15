package modelo.coordenadas;

import modelo.errores.coordenadaInvalida;

public class Coordenada {
	
	private int x;
	private int y;
	
	public Coordenada(int X, int Y){
		this.ComprovarCoordenadaValida(X);
		this.ComprovarCoordenadaValida(Y);
		this.cambiarCoordenadaX(X);
		this.cambiarCoordenadaY(Y);
		
	}

	public int obtenerCoordenadaX() {
		return x;
	}

	public void cambiarCoordenadaX(int X) {
		this.ComprovarCoordenadaValida(X);
		this.x = X;
	}

	public int obtenerCoordenadaY() {
		return y;
	}

	public void cambiarCoordenadaY(int Y) {
		this.ComprovarCoordenadaValida(Y);
		this.y = Y;
	}
	
	private void ComprovarCoordenadaValida(int valor){
		if(valor < 0){
			throw new coordenadaInvalida();
		}
	}
}

