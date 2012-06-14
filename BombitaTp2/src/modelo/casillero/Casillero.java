package modelo.casillero;

import java.util.LinkedList;
import modelo.personaje.*;
import modelo.articulo.*;
import modelo.armamento.*;


//primera vercion de casillero, va a nesesitar ajustes.

public class Casillero {
	
	Personaje unPersonaje;
	String identificador;
	Armamento unArmamento;
	Articulo unArticulo;
	
	
	public void Casillero()
	{
		this.identificador = "noName";
		this.unPersonaje = null;
		this.unArmamento = null;
		this.unArticulo = null;
		
	}
	
	public void Casillero(String identificador){
		
		this.identificador = identificador;
		this.unPersonaje = null;
		this.unArmamento = null;
		this.unArticulo = null;
		
	}
	
	public void cambiarPersonaje(Personaje unPersonaje)
	{
		this.unPersonaje = unPersonaje;
	}
	
	public Personaje obtenerPersonaje(){
		
		return this.unPersonaje;
		
	}
	
	public void cambiarIdentificador(String Identificador){
		
		this.identificador = Identificador;
	}
	
	public String obtenerIdentificador(){
		
		return this.identificador;
	}
	
	public void cambiarArmamento(Armamento UnArmamento){
		
		this.unArmamento = UnArmamento;
		
	}
	
	public Armamento obtenerArmamento(){
		
		return this.unArmamento;
		
	}
	
	public void cambiarArticulo(Articulo unArticulo){
		
		this.unArticulo = unArticulo;
		
	}
	
	public Articulo obtenerArticulo(){
		
		return this.unArticulo;
		
	}
	
	public boolean estaVacio(){
	
		boolean bandera = false;
		if ((this.obtenerArmamento() == null) && (this.obtenerArticulo() == null) && (this.obtenerPersonaje() == null)){
			
			bandera = true;
		}
		
		return bandera;
		
	}
	
}

