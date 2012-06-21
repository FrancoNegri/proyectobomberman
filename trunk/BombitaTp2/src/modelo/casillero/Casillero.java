package modelo.casillero;

import java.util.Iterator;
import java.util.LinkedList;
import modelo.armamento.Armamento;
import modelo.articulo.Articulable;
import modelo.detectorcolision.Colisionador;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.*;


public class Casillero {
	LinkedList <Personaje> personajes;
	Armamento unArmamento;
	Articulable unArticulo;
	Obstaculo unObstaculo;
	int puntaje;
	
	
	public Casillero() {
		this.personajes = new LinkedList<Personaje>() ;
		this.unArmamento = null;
		this.unArticulo = null;
		this.unObstaculo = null;
		this.puntaje = 0;
		
	}
	
	public void actualizarPuntaje(int unPuntaje){
		this.puntaje = puntaje + unPuntaje;
	}
	
	public int obtenerPuntaje() {
		return puntaje;
	}
	
	// Metodo Sobrecargado
	public void agregar(Personaje unPersonaje)
	{
		this.personajes.add(unPersonaje);
	}
	
	public void agregar(LinkedList <Personaje> Personajes){
		
		this.personajes = Personajes;
		
	}
	
	public void agregar(Armamento UnArmamento){
		this.unArmamento = UnArmamento;
	}
	
	public void agregar(Articulable unArticulo){
		this.unArticulo = unArticulo;
	}
	public void agregar(Obstaculo unObstaculo){
		
		this.unObstaculo = unObstaculo;
	}
	// fin Metodo Sobrecargado
	
	public LinkedList<Personaje> obtenerPersonajes(){
		return this.personajes;
	}
	
	public Armamento obtenerArmamento(){
		return this.unArmamento;
	}
	public Articulable obtenerArticulo(){
		return this.unArticulo;
	}
	
	public Obstaculo obtenerObstaculo(){
		return this.unObstaculo;
	}
	
	public boolean esCaminable(){
		if (this.unObstaculo == null){
			return true;
		}
		return false;
	}
	
	public boolean esAtacable(){
		if ((this.unObstaculo == null)&&(personajes.isEmpty())){
			return false;
		}
		return true;
	}
	
	/*
	 *  #verifica si un obstaculo fue destruido
	 *  # chequea las colisiones.
	 *  # si bombita esta en el casillero y si hay un articulo, lo utiliza.
	 */
	
	public void actualizar() {
		if(unObstaculo!=null){
			if(unObstaculo.Destruido()) {
				this.puntaje = puntaje + unObstaculo.obtenerPuntaje();
				unObstaculo = null;
			}
		}
		if(unArmamento!=null) {
			unArmamento.actualizar();
		}
		Colisionador coli = new Colisionador();
		coli.Colicionar(personajes);
		if (this.usarArticulo()) {
			this.puntaje = puntaje + unArticulo.obtenerPuntaje();
			this.unArticulo = null; //si se uso el articulo lo pongo en null.
		}
		
	}

	public void eliminar(Articulable Articulo) {
		if(Articulo == unArticulo){
			unArticulo = null;
		}
	}
	public void eliminar(Armamento arma) {
			if(arma == unArmamento){
				unArmamento = null;
			}
	}
	public void eliminar(Personaje pers) {
		personajes.remove(pers);
	}
	
	public void eliminar(Obstaculo obstaculo) {
		if(obstaculo == unObstaculo){
			unObstaculo = null;
		}
	}
	
	// devuelve true si el articulo fue utilizado.
	private boolean usarArticulo(){
		boolean fueUtilizado = false;
		Articulable articulo = this.obtenerArticulo();
		if (articulo != null) {
			LinkedList <Personaje> Personajes = this.obtenerPersonajes();
			Iterator <Personaje> itPersonajes = Personajes.iterator();
			while (itPersonajes.hasNext()) {
				Personaje unPersonaje = itPersonajes.next();
				unPersonaje.tomarArticulo(articulo);
				fueUtilizado = true;
				}
			}
		return fueUtilizado;	
	
	}
}
	
