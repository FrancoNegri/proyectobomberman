package modelo.casillero;

import modelo.personaje.*;
import modelo.obstaculos.*;
import modelo.articulo.*;
import modelo.armamento.*;


//primera vercion de casillero, va a nesesitar ajustes.

public class Casillero {
	
	Personaje unPersonaje;
	String identificador;
	Armamento unArmamento;
	Articulable unArticulo;
	Obstaculo unObstaculo;
	
	
	public Casillero()
	{
		this.identificador = "noName";
		this.unPersonaje = null;
		this.unArmamento = null;
		this.unArticulo = null;
		
	}
	
	public Casillero(String identificador){
		
		this.identificador = identificador;
		this.unPersonaje = null;
		this.unArmamento = null;
		this.unArticulo = null;
		
	}
	
	public void agregarPersonaje(Personaje unPersonaje)
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
	
	public void cambiarArticulo(Articulable unArticulo){
		
		this.unArticulo = unArticulo;
		
	}
	
	public Articulable obtenerArticulo(){
		
		return this.unArticulo;
		
	}
	
	public void cambiarObstaculo(Obstaculo unObstaculo){
		
		this.unObstaculo = unObstaculo;
	}
	
	public Obstaculo obtenerObstaculo(){
		
		return this.unObstaculo;
	}
	
	public boolean estaVacio(){
	
		boolean bandera = false;
		if ((this.obtenerArmamento() == null) && (this.obtenerArticulo() == null) && (this.obtenerPersonaje() == null)){
			
			bandera = true;
		}
		
		return bandera;
		
	}
	
}

