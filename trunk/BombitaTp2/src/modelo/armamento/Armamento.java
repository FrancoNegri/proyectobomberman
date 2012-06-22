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
	protected Mapa mapaAutilizar;
	
	public Armamento(Coordenada unaCoordenada,Mapa mapa){
		this.coordenada = unaCoordenada.copiar();
		this.time = 0;
		this.danio = 100;
		this.radio = 0;
		mapaAutilizar = mapa;
		mapa.agregarAlMapa(this);
	}
	
	public Coordenada obtenerCoordenadaXY(){
		return coordenada.copiar();
	}
	
	public float obtenerTime() {
		return time;
	}

	public void cambiarTime(float tiempo) {
		this.time = tiempo;
	}
	
	public void explotar(Coordenada coord,Mapa mapa){
		OndaExpansiva Onda = new OndaExpansiva(radio,danio);
		Onda.Expandirse(coord.copiar(),mapa);
	}
	
	
	public void actualizar(){
		if(time>=0){
			this.time = this.time-1;
		}else{
			this.explotar(coordenada, mapaAutilizar);
		}
	}
}
