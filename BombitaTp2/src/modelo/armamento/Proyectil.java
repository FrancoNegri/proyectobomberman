package modelo.armamento;

import org.dom4j.Element;

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
		this.radio = 4;
		transladador = trans;
	}
	
	@Override
	public void vivir() {
		if (distancia > 0) {
			Coordenada coordenadaPlaneada = transladador.accion(coordenada);
			if(coordenada.equals(coordenadaPlaneada) == false){
				try{
				Casillero casilleroAlQueMoverse = mapaAutilizar.obtenerCasillero(coordenadaPlaneada);
				if(casilleroAlQueMoverse.esAtacable() == false){
					Casillero casilleroAntiguo = mapaAutilizar.obtenerCasillero(coordenada);
					casilleroAntiguo.eliminar(this);
					coordenada = coordenadaPlaneada;
					mapaAutilizar.agregarAlMapa(this);
					distancia--;
					return;
				}
				}catch(Exception e){}
			}
		}
		this.explotar(coordenada, mapaAutilizar);
		exploto = true;
	}
	
	public boolean estaMuerto() {
		return exploto;
	}
	
	
	public Element guardar() {
		Element elemMolotov = super.guardar();
		elemMolotov.addAttribute("Tipo", "Proyectil");
		elemMolotov.addAttribute("DistanciaARecorrer", String.valueOf(distancia));
		elemMolotov.add(transladador.guardar());
		return elemMolotov;
	}
	
	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConProyectil(this);
	}
}
