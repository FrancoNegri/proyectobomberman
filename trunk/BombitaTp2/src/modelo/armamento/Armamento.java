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
	protected int time;
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

	public void cambiarTime(int tiempo) {
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
			return exploto;
		}

		protected void guardar(Element elemArma) {
			elemArma.add(coordenada.guardar());
			elemArma.addAttribute("Danio", String.valueOf(danio));
			elemArma.addAttribute("Time", String.valueOf(time));
			elemArma.addAttribute("Radio", String.valueOf(radio));
			elemArma.addAttribute("Exploto", new Boolean(exploto).toString());
		}

		public abstract Element guardar();
}
