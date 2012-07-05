package vista.Mapa;

import vista.Casillero.VistaCasillero;
import vista.fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import vista.fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;

public class VistaMapa implements ObjetoDibujable {

	private Mapa mapaDibujable;

	public VistaMapa(Mapa mapa) {
		mapaDibujable = mapa;
	}

	public void dibujar(SuperficieDeDibujo superficieDeDibujo) {
		for (int j = 0; j < mapaDibujable.obtenerTamanio(); j++) {
			for (int k = 0; k < mapaDibujable.obtenerTamanio(); k++) {
				Coordenada coordenada = new Coordenada(j, k);
				Casillero casillero = mapaDibujable
						.obtenerCasillero(coordenada);
				actualizadorDeVistaCasillero Actualizador = new actualizadorDeVistaCasillero(casillero,superficieDeDibujo);
				Thread hilo = new Thread(Actualizador);
				hilo.run();
			}
		}
	}

	private class actualizadorDeVistaCasillero implements Runnable {
		private Casillero casillero;
		SuperficieDeDibujo unaSuperficieDeDibujo;

		public actualizadorDeVistaCasillero(Casillero cas,
				SuperficieDeDibujo superficieDeDibujo) {
			casillero = cas;
			unaSuperficieDeDibujo = superficieDeDibujo;
		}

		public void run() {
			if (!casillero.casilleroEstaVacio()) {
				if (!casillero.casilleroEstaVacio()) {
					VistaCasillero vistaDelCasillero = new VistaCasillero(
							casillero);
					vistaDelCasillero.dibujar(unaSuperficieDeDibujo);

				}
			}
		}
	}

}
