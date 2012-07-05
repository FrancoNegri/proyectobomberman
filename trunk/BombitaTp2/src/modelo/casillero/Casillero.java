package modelo.casillero;

import java.util.Iterator;

import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import vista.fiuba.algo3.titiritero.modelo.ObjetoVivo;
import vista.objeto.ObjetoVisible;
import java.util.LinkedList;
import vista.objeto.VistaObjeto;
import modelo.armamento.Armamento;
import modelo.articulo.Articulable;
import modelo.detectorcolision.Colisionador;
import modelo.fuegoDeExplocion.FuegoDeExplocion;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.*;
import modelo.salida.*;

public class Casillero {
	LinkedList<Personaje> personajes;
	Armamento unArmamento;
	Articulable unArticulo;
	Obstaculo unObstaculo;
	FuegoDeExplocion fuegoDeLaExplocion;
	int puntaje;
	Salida salidaJuego;

	public Casillero() {
		this.personajes = new LinkedList<Personaje>();
		this.unArmamento = null;
		this.unArticulo = null;
		this.unObstaculo = null;
		this.puntaje = 0;
		this.salidaJuego = null;

	}

	public void actualizarPuntaje(int unPuntaje) {
		this.puntaje = puntaje + unPuntaje;
	}

	public int obtenerPuntaje() {
		int puntajeRonda;
		puntajeRonda = this.puntaje;
		this.puntaje = 0;
		return puntajeRonda;
	}

	// Metodo Sobrecargado
	public void agregar(Personaje unPersonaje) {
			this.personajes.add(unPersonaje);
		}


	public void agregar(Armamento UnArmamento) {
		if (this.unArmamento == null) {
			this.unArmamento = UnArmamento;
		}
	}

	public void agregar(FuegoDeExplocion fuego) {
		if (this.fuegoDeLaExplocion == null) {
			this.fuegoDeLaExplocion = fuego;
		}
	}

	public void agregar(Articulable unArticulo) {
		this.unArticulo = unArticulo;
	}

	public void agregar(Obstaculo unObstaculo) {

		this.unObstaculo = unObstaculo;
	}
	
	public void agregar(Salida salidaJuego){
		
		this.salidaJuego = salidaJuego;
	}

	// fin Metodo Sobrecargado

	public LinkedList<Personaje> obtenerPersonajes() {
		return this.personajes;
	}

	public Armamento obtenerArmamento() {
		return this.unArmamento;
	}

	public Articulable obtenerArticulo() {
		return this.unArticulo;
	}

	public Obstaculo obtenerObstaculo() {
		return this.unObstaculo;
	}

	public FuegoDeExplocion obtenerFuegoDeExplocion() {
		return fuegoDeLaExplocion;
	}
	
	public Salida obtenerSalida(){
		
		return this.salidaJuego;
	}

	public boolean esCaminable() {
		if (this.unObstaculo == null) {
			return true;
		}
		return false;
	}
	

	public boolean esAtacable() {
		if ((this.unObstaculo == null) && (personajes.isEmpty())) {
			return false;
		}
		return true;
	}

	/*
	 * #verifica si un obstaculo fue destruido # chequea las colisiones. # si
	 * bombita esta en el casillero y si hay un articulo, lo utiliza.
	 */

	public /*synchronized*/ void actualizar() {
		this.actualizarArmamento();
		this.actualizarPersonajes();
		this.actualizarObstaculos();
		this.Colicionar();
		this.ActualizarArticulo();
		this.ActualizarFuegoExplocion();
	}

	private void ActualizarFuegoExplocion() {
		if (fuegoDeLaExplocion != null) {
			fuegoDeLaExplocion.vivir();
			if (fuegoDeLaExplocion.estaMuerto()) {
				this.fuegoDeLaExplocion = null;
			}
		}
	}

	private void ActualizarArticulo() {
		if (this.unArticulo != null){
			if (this.usarArticulo()) {
				this.actualizarPuntaje(unArticulo.obtenerPuntaje()); 
				this.unArticulo = null; // si se uso el articulo lo pongo en null
			}
		}
	}

	private void actualizarArmamento() {
		this.VivirArmamento();
		if (unArmamento != null) {
			if (unArmamento.estaMuerto()) {
				unArmamento = null;
			}
		}
	}

	private void actualizarPersonajes() {
		this.VivirPersonajes();
		this.eliminarPersonajesMuertos();
	}

	private void VivirPersonajes() {
		LinkedList<Personaje> lista =  (LinkedList<Personaje>) personajes.clone();
		Iterator<Personaje> IteradorPersonajes = lista.iterator();
		while (IteradorPersonajes.hasNext()) {
			Personaje personaje = IteradorPersonajes.next();
			personaje.vivir();
		}
	}

	public void actualizarObstaculos() {
		if (unObstaculo != null) {
			if (unObstaculo.Destruido()) {
				this.actualizarPuntaje(unObstaculo.obtenerPuntaje());
				unObstaculo = null;
			}
		}
	}

	private void Colicionar() {
		Colisionador coli = new Colisionador();
		coli.Colicionar(personajes);
	}

	private void VivirArmamento() {
		if (unArmamento != null) {
			unArmamento.vivir();
		}
	}

	private void eliminarPersonajesMuertos() {
		Iterator<Personaje> IteradorPersonajes = personajes.iterator();
		while (IteradorPersonajes.hasNext()) {
			Personaje personaje = IteradorPersonajes.next();
			if (personaje.estaMuerto()) {
				this.actualizarPuntaje(personaje.obtenerPuntaje());
				IteradorPersonajes.remove();
			}
		}
	}

	public void eliminar(Articulable Articulo) {
		if (Articulo == unArticulo) {
			unArticulo = null;
		}
	}

	public void eliminar(Armamento arma) {
		if (arma == unArmamento) {
			unArmamento = null;
		}
	}

	public void eliminar(Personaje pers) {
		personajes.remove(pers);
	}

	public void eliminar(Obstaculo obstaculo) {
		if (obstaculo == unObstaculo) {
			unObstaculo = null;
		}
	}

	// devuelve true si el articulo fue utilizado.
	private boolean usarArticulo() {
		boolean fueUtilizado = false;
		Articulable articulo = this.obtenerArticulo();
		if (articulo != null) {
			LinkedList<Personaje> Personajes = this.obtenerPersonajes();
			Iterator<Personaje> itPersonajes = Personajes.iterator();
			while (itPersonajes.hasNext()) {
				Personaje unPersonaje = itPersonajes.next();
				if(this.personajeEsBombita(unPersonaje)){
				unPersonaje.tomarArticulo(articulo);
				fueUtilizado = true;
				}
			}
		}
		return fueUtilizado;

	}
	

	// metodos para chequear la salida del nivel.

	public boolean salidaON() {

		// verifica si el casillero es un casillero de salida y si no tiene
		// ningun obstaculo que la cubra.
		if(this.salidaJuego !=null){
		return ((this.salidaJuego.activada()) && (this.unObstaculo == null));
		}
		else
		return false;
	}

	public boolean casilleroSinPersonajes() {

		return this.personajes.isEmpty();
	}

	public boolean estaBombita() {

		boolean bandera = false;
		Iterator<Personaje> itPers = this.personajes.iterator();
		while ((itPers.hasNext()) && (!bandera)) {

			Personaje PersonajeAux = itPers.next();
			bandera = (this.personajeEsBombita(PersonajeAux));
		}
		return bandera;

	}

	public boolean soloEstaBombita() {
		return ((this.estaBombita()) && (this.personajes.size() == 1));
	}

	public boolean casilleroEstaVacio() {
		if (!personajes.isEmpty()) {
			return false;
		}
		if (unArmamento != null) {
			return false;
		}
		if (unObstaculo != null) {
			return false;
		}
		if (unArticulo != null) {
			return false;
		}
		if (fuegoDeLaExplocion != null) {
			return false;
		}
		if(salidaJuego !=null){
			return false;
		}
		return true;
		
	}
	
	private boolean personajeEsBombita(Personaje unPersonaje){
		
		return (unPersonaje instanceof Bombita);
		
	}
	
	
	
	
	
	
	
}
