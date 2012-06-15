package modelo.casillero;

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
	
	public boolean estaVacio(){
	
		boolean bandera = false;
		if ((this.obtenerArmamento() == null) && (this.obtenerArticulo() == null) && (this.personajes.isEmpty())){
			
			bandera = true;
		}
		return bandera;
		
	}
}

