package vista.Casillero;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import modelo.armamento.Armamento;
import modelo.articulo.Articulable;
import modelo.casillero.Casillero;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Personaje;
import vista.Armamento.VistaArmamento;
import vista.Articulo.VistaArticulo;
import vista.Bloque.VistaBloque;
import vista.Personaje.vistaPersonaje;
import vista.fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import vista.fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class VistaCasillero implements ObjetoDibujable {

	Casillero CasilleroADibujar;

	public VistaCasillero(Casillero CasilleroDibujable) {
		CasilleroADibujar = CasilleroDibujable;
	}

	public void dibujar(SuperficieDeDibujo superficieDeDibujo) {
		this.dibujarArmamento(superficieDeDibujo);
		this.dibujarArticulo(superficieDeDibujo);
		this.dibujarBloque(superficieDeDibujo);
		this.dibujarPersonajes(superficieDeDibujo);
	}

	private void dibujarBloque(SuperficieDeDibujo superficieDeDibujo) {
		Obstaculo ObstaculoAmostrar = CasilleroADibujar.obtenerObstaculo();
		if (ObstaculoAmostrar != null) {
			VistaBloque vistaBloque = new VistaBloque(ObstaculoAmostrar);
			vistaBloque.dibujar(superficieDeDibujo);
		}
	}

	private void dibujarArticulo(SuperficieDeDibujo superficieDeDibujo) {
		Articulable articuloADibujar = CasilleroADibujar.obtenerArticulo();
		if (articuloADibujar != null) {
			VistaArticulo vistaArma = new VistaArticulo(articuloADibujar);
			vistaArma.dibujar(superficieDeDibujo);
		}
	}

	private void dibujarArmamento(SuperficieDeDibujo superficieDeDibujo) {
		Armamento arma = CasilleroADibujar.obtenerArmamento();
		if (arma != null) {
			try {
				VistaArmamento vistaArma = new VistaArmamento(arma);
				vistaArma.dibujar(superficieDeDibujo);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void dibujarPersonajes(SuperficieDeDibujo superficieDeDibujo) {
		LinkedList<Personaje> personajes = CasilleroADibujar
				.obtenerPersonajes();
		Iterator<Personaje> iteradorDePersonajes = personajes.iterator();
		while (iteradorDePersonajes.hasNext()) {
			try {
				vistaPersonaje vistaDelPersonaje = new vistaPersonaje(
						iteradorDePersonajes.next());
				vistaDelPersonaje.dibujar(superficieDeDibujo);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
