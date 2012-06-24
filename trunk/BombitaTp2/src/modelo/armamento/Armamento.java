package modelo.armamento;

import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import vista.fiuba.algo3.titiritero.modelo.ObjetoVivo;
import vista.objeto.ObjetoVisible;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.ondaexpansiva.OndaExpansiva;

public abstract class Armamento implements Armamentable,ObjetoVivo,ObjetoPosicionable,ObjetoVisible {
	
	protected Coordenada coordenada;
	protected float time;
	protected int danio;
	protected int radio;
	protected Mapa mapaAutilizar;
	boolean muerto;
	
	public Armamento(Coordenada unaCoordenada,Mapa mapa){
		this.coordenada = unaCoordenada.copiar();
		this.time = 0;
		this.danio = 100;
		this.radio = 0;
		mapaAutilizar = mapa;
		mapa.agregarAlMapa(this);
		muerto = false;
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
	
	
	public void vivir(){
		if((time>=0)&(!muerto)){
			this.time = this.time-1;
		}else{
			if(!muerto){
				this.explotar(coordenada, mapaAutilizar);
				muerto = true;
			}
		}
	}
	
	public int getX() {
		return this.coordenada.obtenerCoordenadaX();
		}

		public int getY() {
		return this.coordenada.obtenerCoordenadaY();
		}
		
		public boolean estaMuerto() {
			return muerto;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
}
