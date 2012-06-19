package modelo.armamento;

import modelo.coordenadas.Coordenable;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.ondaexpansiva.OndaExpansiva;

public abstract class Armamento implements Armamentable , Coordenable {
	
	protected Coordenada coordenada;
	protected float time;
	protected int danio;
	protected int radio;
	
	public Armamento(Coordenada unaCoordenada){
		this.coordenada = unaCoordenada;
		this.time = 0;
		this.danio = 0;
		this.radio = 0;
	}
	
	public Coordenada obtenerCoordenadaXY(){
		return coordenada;
	}
	
	public float obtenerTime() {
		return time;
	}

	public void cambiarTime(float tiempo) {
		this.time = tiempo;
	}
	
	public void explotar(Coordenada coord,Mapa mapa){
		OndaExpansiva Onda = new OndaExpansiva(this.danio,this.radio);
		Onda.Expandirse(coord,mapa);
	}
	
	
	public void actualizar(){
		this.time = this.time-1;
	}
	public boolean exploto(){
		return (this.time <= 0);
	}
}
