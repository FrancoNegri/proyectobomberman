package vista.Casillero;

import java.util.Iterator;
import java.util.LinkedList;

import modelo.armamento.Armamento;
import modelo.articulo.Articulable;
import modelo.casillero.Casillero;
import modelo.fuegoDeExplocion.FuegoDeExplocion;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Personaje;
import modelo.salida.*;
import vista.fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import vista.fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;
import vista.objeto.VistaObjeto;

public class VistaCasillero implements ObjetoDibujable {

	Casillero CasilleroADibujar;

	public VistaCasillero(Casillero CasilleroDibujable) {
		CasilleroADibujar = CasilleroDibujable;
	}

	public void dibujar(SuperficieDeDibujo superficieDeDibujo) {
		this.dibujarSalida(superficieDeDibujo);
		this.dibujarArmamento(superficieDeDibujo);
		this.dibujarArticulo(superficieDeDibujo);
		this.dibujarBloque(superficieDeDibujo);
		this.dibujarPersonajes(superficieDeDibujo);
		this.dibujarFuegoDeExplocion(superficieDeDibujo);
	}

	private void dibujarFuegoDeExplocion(SuperficieDeDibujo superficieDeDibujo) {
		FuegoDeExplocion fuegoDeLaExplocion = CasilleroADibujar.obtenerFuegoDeExplocion();
		if (fuegoDeLaExplocion != null) {
			VistaObjeto vistaFuego = new VistaObjeto(fuegoDeLaExplocion);
			dibujar(vistaFuego,superficieDeDibujo );
		}
	}

	private void dibujarBloque(SuperficieDeDibujo superficieDeDibujo) {
		Obstaculo ObstaculoAmostrar = CasilleroADibujar.obtenerObstaculo();
		if (ObstaculoAmostrar != null) {
			VistaObjeto vistaBloque = new VistaObjeto(ObstaculoAmostrar);
			dibujar(vistaBloque,superficieDeDibujo );
		}
	}

	private void dibujarArticulo(SuperficieDeDibujo superficieDeDibujo) {
		Articulable articuloADibujar = CasilleroADibujar.obtenerArticulo();
		if (articuloADibujar != null) {
			VistaObjeto vistaArma = new VistaObjeto(articuloADibujar);
			dibujar(vistaArma,superficieDeDibujo );
		}
	}

	private void dibujarArmamento(SuperficieDeDibujo superficieDeDibujo) {
		Armamento arma = CasilleroADibujar.obtenerArmamento();
		if (arma != null) {
			VistaObjeto vistaArma = new VistaObjeto(arma);
			dibujar(vistaArma,superficieDeDibujo );
		}
	}

	private synchronized void  dibujarPersonajes(SuperficieDeDibujo superficieDeDibujo) {
		LinkedList<Personaje> personajes = CasilleroADibujar
				.obtenerPersonajes();
		Iterator<Personaje> iteradorDePersonajes = personajes.iterator();
		while (iteradorDePersonajes.hasNext()) {
				VistaObjeto vistaDelPersonaje = new VistaObjeto(
						iteradorDePersonajes.next());
				dibujar(vistaDelPersonaje,superficieDeDibujo );
		}
	}
	
	private void dibujarSalida(SuperficieDeDibujo superficieDeDibujo){
		Salida salidaJuego = CasilleroADibujar.obtenerSalida();
		if(salidaJuego != null){
			VistaObjeto vistaSalida = new VistaObjeto(salidaJuego);
			dibujar(vistaSalida,superficieDeDibujo );
		}
	}
	
	private void dibujar(VistaObjeto objeto,SuperficieDeDibujo superficieDeDibujo){
		Dibujador dibujador = new Dibujador(objeto,superficieDeDibujo);
		Thread hilo = new Thread(dibujador);
		hilo.run();
		
	}
	
	private class Dibujador implements Runnable{
		VistaObjeto objetoADibujar;
		SuperficieDeDibujo superficieDeDibujo;
		public Dibujador(VistaObjeto objeto,SuperficieDeDibujo superficieDeDibujo){
			objetoADibujar = objeto;
			this.superficieDeDibujo = superficieDeDibujo;
		}
		public void run(){
			objetoADibujar.dibujar(superficieDeDibujo);
		}
	}
}
