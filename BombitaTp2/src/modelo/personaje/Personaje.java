package modelo.personaje;


import org.dom4j.Element;
import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import vista.fiuba.algo3.titiritero.modelo.ObjetoVivo;
import vista.objeto.ObjetoVisible;
import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.Translacion.Translacion;
import modelo.Translacion.TranslacionDerecha;
import modelo.articulo.Articulable;
import modelo.casillero.Casillero;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.danio.*;
import modelo.errores.TamanioMatrizInvalidoError;



public abstract class Personaje implements ObjetoVisible, Daniable,ObjetoPosicionable , ObjetoVivo {
	protected Translacion ultimaTranslacion;
	protected ArmamentoFactory CreadorDeBombas;
	protected int velocidad;
	private int tiempoHastaMoverse;
	protected int vida;
	protected Coordenada coordenadaXY;
	protected Mapa mapa;
	protected int puntaje;


	public Personaje(Coordenada unaCoordenada,Mapa nuevoMapa) {
		this.coordenadaXY = unaCoordenada.copiar();
		this.ultimaTranslacion = new TranslacionDerecha();
		this.mapa = nuevoMapa;
		this.mapa.agregarAlMapa(this);
		this.vida = 10;
		this.puntaje = ConstantesJuego.puntaje_enemigo_muerto;
		this.tiempoHastaMoverse = 0;
	}
	
	protected Personaje() {
	}

	protected abstract Translacion obtenerTranslacion();

	public abstract void chocar();

	public abstract void Atacar();
		
	
	protected void caminar() {
		Casillero casilleroAlQueMoverse;
		ultimaTranslacion = this.obtenerTranslacion();
		if(ultimaTranslacion == null){return;}
		Coordenada movimientoPlaneado = ultimaTranslacion.accion(coordenadaXY);
		try{
		casilleroAlQueMoverse = mapa.obtenerCasillero(movimientoPlaneado);
		}catch(TamanioMatrizInvalidoError e){return;}//Caso que el Personaje intenta salirse del mapa
		if (casilleroAlQueMoverse.esCaminable()){
			Casillero casilleroAntiguo = mapa.obtenerCasillero(coordenadaXY);
			casilleroAntiguo.eliminar(this);
			coordenadaXY = movimientoPlaneado;
			mapa.agregarAlMapa(this);
		}
	}
	
	
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

	public int getVelocidad() {
		return velocidad;
	}

	public void cambiarVelocidad(int velocidad) {
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
	
	public void vivir() {
		if(!this.estaMuerto()){
			/*Aclaracion SobreVelocidad, Yo pense que la velocidad de un personaje
			 * es el tiempo en que tarda en moverse.Ejemplo: si tiene velocidad 3
			 * va a Tardar 3 "vivir()" en poder moverse un casillero 
			 */
			if(tiempoHastaMoverse <= 0){
				this.caminar();
				tiempoHastaMoverse = (20/(this.velocidad));
			}else{
				tiempoHastaMoverse--;
			}
			
			this.Atacar();
		}
	}
	

	public int getX() {
	return this.coordenadaXY.obtenerCoordenadaX();
	}

	public int getY() {
	return this.coordenadaXY.obtenerCoordenadaY();
	}
	
	public int obtenerPuntaje() {
		return this.puntaje;
	}

	protected void guardar(Element elemPersonaje) {
		elemPersonaje.addAttribute("Vida", String.valueOf(vida));
		elemPersonaje.addAttribute("Velocidad", String.valueOf(velocidad));
		elemPersonaje.add(coordenadaXY.guardar());
	}

	public abstract Element guardar();
	
}


