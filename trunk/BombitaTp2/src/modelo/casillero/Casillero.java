package modelo.casillero;

import java.util.LinkedList;
import modelo.armamento.Armamento;
import modelo.articulo.Articulable;
import modelo.detectorcolision.Colisionador;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Personaje;


//primera vercion de casillero, va a nesesitar ajustes.

public class Casillero {
	LinkedList <Personaje> personajes;
	Armamento unArmamento;
	Articulable unArticulo;
	Obstaculo unObstaculo;
	
	
	public Casillero()
	{
		this.personajes = new LinkedList<Personaje>() ;
		this.unArmamento = null;
		this.unArticulo = null;
		this.unObstaculo = null;
		
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
	
	public void actualizar(){
		if(unObstaculo.Destruido()){
			unObstaculo = null;
		}
		Colisionador coli = new Colisionador();
		coli.Colicionar(personajes);
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
}
	
