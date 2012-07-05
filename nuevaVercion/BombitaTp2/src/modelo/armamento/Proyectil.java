package modelo.armamento;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;

import vista.objeto.VistaObjeto;
import modelo.Translacion.Translacion;
import modelo.Translacion.TranslacionAbajo;
import modelo.Translacion.TranslacionArriba;
import modelo.Translacion.TranslacionDerecha;
import modelo.Translacion.TranslacionIzquierda;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.constantesjuego.ConstantesJuego;
import modelo.mapa.Mapa;

public class Proyectil extends Armamento {

	private Translacion transladador;
	private int distancia = ConstantesJuego.distancia_proyectil;
	private int tiempoQueLeTomaPasarUnCasillero = 4;
	private int tiempoParaCambiarDeCasillero = 0;

	public Proyectil(Coordenada coordenada, Mapa mapa, Translacion trans) {
		super(coordenada, mapa);
		this.danio = ConstantesJuego.danio_proyectil;
		this.time = 0;
		this.radio = 4;
		transladador = trans;
	}

	@Override
	public void vivir() {
		if (tiempoParaCambiarDeCasillero > 0) {
			tiempoParaCambiarDeCasillero--;
			this.comprobarCasilleroEnQueSeEncuentra();
		} else {
			if (distancia > 0) {
				Coordenada coordenadaPlaneada = transladador.accion(coordenada);
				if (coordenada.equals(coordenadaPlaneada) == false) {
					try {
						Casillero casilleroAlQueMoverse = mapaAutilizar
								.obtenerCasillero(coordenadaPlaneada);
						if (casilleroAlQueMoverse.esAtacable() == false) {
							Casillero casilleroAntiguo = mapaAutilizar
									.obtenerCasillero(coordenada);
							casilleroAntiguo.eliminar(this);
							coordenada = coordenadaPlaneada;
							mapaAutilizar.agregarAlMapa(this);
							distancia--;
							return;
						}
						tiempoParaCambiarDeCasillero = tiempoQueLeTomaPasarUnCasillero;
						
					} catch (Exception e) {
					}
				}
			}
			this.explotar(coordenada, mapaAutilizar);
		}
	}

	private void comprobarCasilleroEnQueSeEncuentra() {
		Casillero casilleroAntiguo = mapaAutilizar.obtenerCasillero(coordenada);
		if (casilleroAntiguo.esAtacable()) {
			this.explotar(coordenada, mapaAutilizar);
		}
	}

	public boolean estaMuerto() {
		return exploto;
	}

	public Element guardar() {
		Element elemMolotov = DocumentHelper.createElement("Proyectil");
		super.guardar(elemMolotov);
		elemMolotov.addAttribute("DistanciaARecorrer",
				String.valueOf(distancia));
		elemMolotov.add(transladador.guardar());
		return elemMolotov;
	}

	public static Proyectil recuperar(Element elemArmamento, Mapa mapa) {

		Coordenada posicionBomba = Coordenada.recuperar(elemArmamento
				.element(new QName("Coordenada")));
		Translacion transProyectil = Translacion.recuperar(elemArmamento
				.element(new QName("Translacion")));
		Proyectil bombaRecuperada = new Proyectil(posicionBomba, mapa,
				transProyectil);
		bombaRecuperada.distancia = Integer.parseInt(elemArmamento
				.attributeValue(new QName("DistanciaARecorrer")));
		bombaRecuperada.danio = Integer.parseInt(elemArmamento
				.attributeValue(new QName("Danio")));
		bombaRecuperada.radio = Integer.parseInt(elemArmamento
				.attributeValue(new QName("Radio")));
		bombaRecuperada.exploto = Boolean.parseBoolean(elemArmamento
				.attributeValue(new QName("Exploto")));
		if (elemArmamento.element("TranslacionIzquierda") != null) {
			bombaRecuperada.transladador = new TranslacionIzquierda();
		}
		if (elemArmamento.element("TranslacionDerecha") != null) {
			bombaRecuperada.transladador = new TranslacionDerecha();
		}
		if (elemArmamento.element("TranslacionArriba") != null) {
			bombaRecuperada.transladador = new TranslacionArriba();
		}
		if (elemArmamento.element("TranslacionAbajo") != null) {
			bombaRecuperada.transladador = new TranslacionAbajo();
		}
		return bombaRecuperada;
	}

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConProyectil(this);
	}
}
