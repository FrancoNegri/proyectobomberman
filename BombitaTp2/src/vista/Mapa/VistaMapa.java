package vista.Mapa;

import vista.Casillero.VistaCasillero;
import vista.fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import vista.fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;

public class VistaMapa implements ObjetoDibujable {
	
	private Mapa mapaDibujable;
	public VistaMapa(Mapa mapa){
		mapaDibujable = mapa;
	}
	
	public void dibujar(SuperficieDeDibujo superficieDeDibujo) {
		for(int j =0 ;j < mapaDibujable.obtenerTamanio() ; j++){
			for(int k =0 ;k < mapaDibujable.obtenerTamanio(); k++){
				Coordenada coordenada = new Coordenada(j,k);
				Casillero casillero = mapaDibujable.obtenerCasillero(coordenada);
				VistaCasillero vistaDelCasillero = new VistaCasillero(casillero);
				vistaDelCasillero.dibujar(superficieDeDibujo);
			}
		}
	}
}
