package modelo.personaje;


import org.dom4j.Element;
import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import vista.fiuba.algo3.titiritero.modelo.ObjetoVivo;
import vista.objeto.ObjetoVisible;
import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.Translacion.Translacion;
import modelo.Translacion.TranslacionDerecha;
import modelo.articulo.Articulable;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.danio.*;



public abstract class Personaje implements ObjetoVisible, Daniable,ObjetoPosicionable , ObjetoVivo {
	protected Translacion ultimaTranslacion;
	protected ArmamentoFactory CreadorDeBombas;
	protected float velocidad;
	protected int vida;
	protected Coordenada coordenadaXY;
	protected Mapa mapa;


	public Personaje(Coordenada unaCoordenada,Mapa nuevoMapa) {
		this.coordenadaXY = unaCoordenada.copiar();
		this.ultimaTranslacion = new TranslacionDerecha();
		this.mapa = nuevoMapa;
		this.mapa.agregarAlMapa(this);
	}
	
	protected Personaje() {
	}

	protected abstract Translacion obtenerTranslacion();

	public abstract void chocar();

	protected abstract void Atacar();
	
	public abstract void tomarArticulo(Articulable unArticulo);

	public Coordenada obtenerCoordenadaXY() {
		return coordenadaXY.copiar();
	}

	public void cambiarCoordenadaXY(Coordenada unaCoordenada) {
		this.coordenadaXY = unaCoordenada;
	}

	public Translacion obtenerUltimaTranslacion() {
		return ultimaTranslacion;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public int obtenerVida() {
		return vida;
	}

	public void restarVida(int danio) {
		this.vida = vida - danio;
	}

	public float getVelocidad() {
		return velocidad;
	}

	public void cambiarVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}

	public ArmamentoFactory tirarArmamento() {
		return CreadorDeBombas;
	}
	
	public void cambiarArmamento(ArmamentoFactory nuevoCreador) {
		this.CreadorDeBombas = nuevoCreador;
	}

	public boolean estaMuerto() {
		return (this.vida <= 0);
	}

	public void Daniar(int danio) {
		if (!this.estaMuerto()) {
			this.restarVida(danio);
		}

	}

	protected abstract void caminar();

	
	public void vivir() {
		if(!this.estaMuerto()){
			this.caminar();
			this.Atacar();
		}
	}
	

	public int getX() {
	return this.coordenadaXY.obtenerCoordenadaX();
	}

	public int getY() {
	return this.coordenadaXY.obtenerCoordenadaY();
	}

	protected void guardar(Element elemPersonaje) {
		elemPersonaje.addAttribute("Vida", String.valueOf(vida));
		elemPersonaje.addAttribute("Velocidad", String.valueOf(velocidad));
		elemPersonaje.add(coordenadaXY.guardar());
	}

	public abstract Element guardar();
	
}


