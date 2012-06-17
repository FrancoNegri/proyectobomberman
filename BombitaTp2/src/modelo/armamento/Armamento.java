package modelo.armamento;

import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.ondaexpansiva.OndaExpansiva;

public abstract class Armamento implements Armamentable {
	
	protected Coordenada coordenada;
	protected float time;
	protected int danio;
	protected int radio;
	
	public Armamento(Coordenada unaCoordenada){
		coordenada = unaCoordenada;
		time = 0;
		danio = 0;
		radio = 0;
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
