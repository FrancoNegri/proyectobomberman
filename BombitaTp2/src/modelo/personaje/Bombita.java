package modelo.personaje;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;

import vista.objeto.VistaObjeto;

import modelo.ArmamentoFactory.*;
import modelo.Translacion.*;
import modelo.articulo.Articulable;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;

public class Bombita extends Personaje {

	
	Translacion TranslacionADar;
	private boolean actitudAtaque;
	

	
	public Bombita(Coordenada unaCoordenada,Mapa nuevoMapa) {
		super(unaCoordenada,nuevoMapa);
		this.velocidad = ConstantesJuego.velocidad_bombita;
		this.vida = ConstantesJuego.vida_bombita;
		this.CreadorDeBombas = new MolotovFactory();
        this.actitudAtaque = false;
	}
	
	private Bombita(){
	}

	public void tomarArticulo(Articulable unArticulo) {
		unArticulo.usar(this);
	}

	
	public void morir(){
		this.vida = 0;
	}
	
	public void chocar() {
		this.morir();
	}
	
	public void cambiarActitud(){
		if(this.actitudAtaque)
			this.actitudAtaque = false;
		else 
		   (this.actitudAtaque) = true;
	}

	
	public void Atacar(){
		if (this.actitudAtaque){
			CreadorDeBombas.crear(this);
		    this.cambiarActitud();
		}
	}
	

	@Override
	protected Translacion obtenerTranslacion() {
		Translacion TranslacionAux = TranslacionADar;
		TranslacionADar = null;
		return TranslacionAux;
	}

	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConBombita(this);
	}

	@Override
	public Element guardar() {
		Element elemPersonaje = DocumentHelper.createElement("Bombita");
		super.guardar(elemPersonaje);
		return elemPersonaje;
	}
	
	public void moverseAbajo() {
		TranslacionADar = new TranslacionArriba();
	}
	
	public void moverseArriba() {
		TranslacionADar = new TranslacionAbajo();
	}
	
	public void moverseIzquierda() {
		TranslacionADar = new TranslacionIzquierda();
	}
	
	public void moverseDerecha() {
		TranslacionADar = new TranslacionDerecha();
	}
	
	public static Personaje recuperar(Element elemCes,Mapa mapa) {
		Bombita nuevoPers = new Bombita();
		nuevoPers.vida = Integer.parseInt(elemCes.attributeValue((new QName("Vida"))));
		nuevoPers.coordenadaXY  = Coordenada.recuperar(elemCes.element(new QName("Coordenada")));
		nuevoPers.mapa = mapa;
		nuevoPers.CreadorDeBombas = new MolotovFactory();
		nuevoPers.velocidad = ConstantesJuego.velocidad_cecilio;
		nuevoPers.ultimaTranslacion = new TranslacionDerecha();
		return nuevoPers;
		}
}
