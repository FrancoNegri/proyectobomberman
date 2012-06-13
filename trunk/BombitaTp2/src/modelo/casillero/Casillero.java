package modelo.casillero;

import java.util.LinkedList;
//primera vercion de casillero, va a nesesitar ajustes.

public class Casillero {
	
	LinkedList <Object> objetos;
	
	
	public Casillero()
	{
		objetos = new LinkedList<Object>();
	}
	
	public void agregar(Object objeto)
	{
		objetos.add(objeto);
	}
	
}
