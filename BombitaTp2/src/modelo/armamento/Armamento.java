package modelo.armamento;

public abstract class Armamento implements Armamentable {

	protected float time;
	
	public Armamento(){
	}
	
	public float obtenerTime() {
		return time;
	}

	public void cambiarTime(float tiempo) {
		this.time = tiempo;
	}

}
