package modelo.armamento;

import modelo.mapa.Mapa;
import modelo.ondaexpansiva.OndaExpansiva;

public abstract class Armamento implements Armamentable {

	protected float time;
	protected int danio;
	protected int radio;
	
	public Armamento(){
	}
	
	public float obtenerTime() {
		return time;
	}

	public void cambiarTime(float tiempo) {
		this.time = tiempo;
	}
	
	public void explotar(int x,int y,Mapa mapa){
		OndaExpansiva Onda;
		
		Onda = new OndaExpansiva(this.danio,this.radio);
		Onda.Expandirse(x,y,mapa);
	}

}
