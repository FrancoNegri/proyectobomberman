package modelo.armamento;

import org.dom4j.*;

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
	protected boolean exploto;
	
	public Armamento(Coordenada unaCoordenada,Mapa mapa){
		this.coordenada = unaCoordenada.copiar();
		this.time = 0;
		this.danio = 100;
		this.radio = 0;
		mapaAutilizar = mapa;
		mapa.agregarAlMapa(this);
		exploto = false;
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
		if(exploto){
			return;
		}
		if(time>=0){
			this.time = this.time-1;
		}else{
			this.explotar(coordenada, mapaAutilizar);
			exploto = true;
		}
	}
	
	public int getX() {
		return this.coordenada.obtenerCoordenadaX();
		}

		public int getY() {
		return this.coordenada.obtenerCoordenadaY();
		}
		
		public boolean estaMuerto() {
			return (time<0);
		}

		public Element guardar() {
			Element elemPersonaje = DocumentHelper.createElement("Armamento");
			elemPersonaje.add(coordenada.guardar());
			elemPersonaje.addAttribute("Danio", String.valueOf(danio));
			elemPersonaje.addAttribute("Time", String.valueOf(time));
			elemPersonaje.addAttribute("Radio", String.valueOf(radio));
			elemPersonaje.addAttribute("Exploto", new Boolean(exploto).toString());
			return elemPersonaje;
		}
}
