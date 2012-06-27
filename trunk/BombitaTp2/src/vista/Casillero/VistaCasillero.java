package vista.Casillero;

import java.util.Iterator;
import java.util.LinkedList;

import modelo.armamento.Armamento;
import modelo.articulo.Articulable;
import modelo.casillero.Casillero;
import modelo.fuegoDeExplocion.FuegoDeExplocion;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Personaje;
import vista.fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import vista.fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import vista.objeto.VistaObjeto;

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
		this.dibujarFuegoDeExplocion(superficieDeDibujo);
		this.dibujarSalida(superficieDeDibujo);
		
	}

	private void dibujarFuegoDeExplocion(SuperficieDeDibujo superficieDeDibujo) {
		FuegoDeExplocion fuegoDeLaExplocion = CasilleroADibujar.obtenerFuegoDeExplocion();
		if (fuegoDeLaExplocion != null) {
			VistaObjeto vistaFuego = new VistaObjeto(fuegoDeLaExplocion);
			vistaFuego.dibujar(superficieDeDibujo);
		}
	}

	private void dibujarBloque(SuperficieDeDibujo superficieDeDibujo) {
		Obstaculo ObstaculoAmostrar = CasilleroADibujar.obtenerObstaculo();
		if (ObstaculoAmostrar != null) {
			VistaObjeto vistaBloque = new VistaObjeto(ObstaculoAmostrar);
			vistaBloque.dibujar(superficieDeDibujo);
		}
	}

	private void dibujarArticulo(SuperficieDeDibujo superficieDeDibujo) {
		Articulable articuloADibujar = CasilleroADibujar.obtenerArticulo();
		if (articuloADibujar != null) {
			VistaObjeto vistaArma = new VistaObjeto(articuloADibujar);
			vistaArma.dibujar(superficieDeDibujo);
		}
	}

	private void dibujarArmamento(SuperficieDeDibujo superficieDeDibujo) {
		Armamento arma = CasilleroADibujar.obtenerArmamento();
		if (arma != null) {
			VistaObjeto vistaArma = new VistaObjeto(arma);
			vistaArma.dibujar(superficieDeDibujo);
		}
	}

	private synchronized void  dibujarPersonajes(SuperficieDeDibujo superficieDeDibujo) {
		LinkedList<Personaje> personajes = CasilleroADibujar
				.obtenerPersonajes();
		Iterator<Personaje> iteradorDePersonajes = personajes.iterator();
		while (iteradorDePersonajes.hasNext()) {
				VistaObjeto vistaDelPersonaje = new VistaObjeto(
						iteradorDePersonajes.next());
				vistaDelPersonaje.dibujar(superficieDeDibujo);
		}
	}
	
	private void dibujarSalida(SuperficieDeDibujo superficieDeDibujo){
		
		if(this.CasilleroADibujar.salidaON()){
			VistaObjeto vistaSalida = new VistaObjeto(this.CasilleroADibujar);
			vistaSalida.dibujar(superficieDeDibujo);
		}
	}
}
