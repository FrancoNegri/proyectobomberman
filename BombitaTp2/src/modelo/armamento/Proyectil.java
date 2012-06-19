package modelo.armamento;

import modelo.Translacion.Translacion;
import modelo.coordenadas.Coordenada;
import modelo.constantesjuego.ConstantesJuego;

public class Proyectil extends Armamento {
	
	private Translacion transladador;//para que lado se va a mover??? tendria que consultarselo al personaje
	private int distancia = ConstantesJuego.distancia_proyectil;
	
	public Proyectil(Coordenada coordenada,int unTime) {
		super(coordenada);
		this.danio = ConstantesJuego.danio_proyectil;
		this.time = unTime;
		
	}
	public void actualizar(){
		
	}
	
	//Como se mueve el proyectil? Deberia tener un metodo mover? Fede.
	//yo habia pensado que podia moverse igual que la bomba
}
