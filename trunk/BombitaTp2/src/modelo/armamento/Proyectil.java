package modelo.armamento;

import vista.objeto.VistaObjeto;
import modelo.Translacion.Translacion;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.constantesjuego.ConstantesJuego;
import modelo.errores.TamanioMatrizInvalidoError;
import modelo.mapa.Mapa;

public class Proyectil extends Armamento {

	private Translacion transladador;
	private int distancia = ConstantesJuego.distancia_proyectil;

	public Proyectil(Coordenada coordenada, Mapa mapa, Translacion trans) {
		super(coordenada, mapa);
		this.danio = ConstantesJuego.danio_proyectil;
		this.time = 0;
		transladador = trans;
	}
	// REFACTORIZAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAARR!!!
	@Override
	public void vivir() {
		if (distancia > 0) {
			Casillero casilleroAlQueMoverse;
			Coordenada movimientoPlaneado = transladador.accion(coordenada);
			if(coordenada.equals(movimientoPlaneado)){
				muerto = true;
				this.explotar(coordenada.copiar(), mapaAutilizar);
				return;
			}
			try {
				casilleroAlQueMoverse = mapaAutilizar
						.obtenerCasillero(movimientoPlaneado);
			} catch (TamanioMatrizInvalidoError e) {
				muerto = true;
				this.explotar(coordenada.copiar(), mapaAutilizar);
				return;
			}
			if (!casilleroAlQueMoverse.esAtacable()) {
				Casillero casilleroAntiguo = mapaAutilizar
						.obtenerCasillero(coordenada);
				casilleroAntiguo.eliminar(this);
				coordenada = movimientoPlaneado;
				mapaAutilizar.agregarAlMapa(this);
			}else{
				muerto = true;
				this.explotar(coordenada.copiar(), mapaAutilizar);
			}
		} else {
			muerto = true;
			this.explotar(coordenada.copiar(), mapaAutilizar);
		}
	}

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConProyectil(this);
	}
}
