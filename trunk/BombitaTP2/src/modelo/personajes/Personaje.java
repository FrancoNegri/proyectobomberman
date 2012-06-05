package modelo.personajes;
import modelo.bomba.Bomba;


public class Personaje implements Caminable {

	protected Bomba bomba;
	protected float velocidad;
	protected int vida;

	public Personaje() {

	}

	public void tirarBomba() {

	}

	public void caminar() {

	}

	public int getVida() {
		return vida;
	}

	public void restarVida(int danio) {
		this.vida = vida - danio;
	}
	
	public float getVelocidad() {
		return velocidad;
	}
	
	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}
	
	public boolean estaMuerto() {
		return (this.vida == 0);
	}
}
