package modelo.coordenadas;

public class Coordenada {
	
	private int x;
	private int y;
	
	public Coordenada(int X, int Y){
		this.cambiarCoordenadaX(X);
		this.cambiarCoordenadaY(Y);
	}

	public int obtenerCoordenadaX() {
		return x;
	}

	public void cambiarCoordenadaX(int x) {
		this.x = x;
	}

	public int obtenerCoordenadaY() {
		return y;
	}

	public void cambiarCoordenadaY(int y) {
		this.y = y;
	}
}
