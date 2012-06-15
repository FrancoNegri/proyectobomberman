package modelo.casillero;

import java.util.Iterator;
import java.util.LinkedList;

import antlr.collections.List;
import modelo.personaje.*;
import modelo.obstaculos.*;
import modelo.articulo.*;
import modelo.armamento.*;


//primera vercion de casillero, va a nesesitar ajustes.

public class Casillero {
	LinkedList <Personaje> personajes;
	String identificador;
	Armamento unArmamento;
	Articulable unArticulo;
	Obstaculo unObstaculo;
	
	
	public Casillero()
	{
		this.identificador = "noName";
		this.personajes = new LinkedList<Personaje>() ;
		this.unArmamento = null;
		this.unArticulo = null;
		
	}
	
	public Casillero(String identificador){
		
		this.identificador = identificador;
		this.personajes = new LinkedList<Personaje>() ;
		this.unArmamento = null;
		this.unArticulo = null;
		
	}
	// Metodo Sobrecargado
	public void agregar(Personaje unPersonaje)
	{
		this.personajes.add(unPersonaje);
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
	
	public void cambiarIdentificador(String Identificador){
		this.identificador = Identificador;
	}
	
	public String obtenerIdentificador(){
		return this.identificador;
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
		if ((this.unObstaculo == null)&&(this.personajes==null)){
			return false;
		}
		return true;
	}
	
	public void actualizar(){
		Iterator<Personaje> lista;
		Personaje personaje;
		unArmamento.actualizar();
		if(unObstaculo.Destruido()){
			unObstaculo = null;
		}
		lista = personajes.iterator();
		while(lista.hasNext()){
			 personaje = lista.next();
			 if(personaje.estaMuerto()){
				 lista.remove();
			 }
		}
	}
}
	
