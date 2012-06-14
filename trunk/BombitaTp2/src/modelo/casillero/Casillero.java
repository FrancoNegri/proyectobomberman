package modelo.casillero;

import java.util.LinkedList;
//primera vercion de casillero, va a nesesitar ajustes.

public class Casillero {
	
	LinkedList <Object> objetos;
	String identificador;
	
	
	public Casillero()
	{
		objetos = new LinkedList<Object>();
		this.identificador = "noName";
		
	}
	
	public void agregar(Object objeto)
	{
		objetos.add(objeto);
	}
	
	public void cambiarIdentificador(String Identificador){
		
		this.identificador = Identificador;
	}
	
	public String obtenerIdentificador(){
		
		return this.identificador;
	}
	
}
