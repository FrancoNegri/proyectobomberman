package modelo.casillero;

import java.util.LinkedList;
//primera vercion de casillero, va a nesesitar ajustes.

public class casillero {
	
	LinkedList <Object> objetos;
	public casillero()
	{
		objetos = new LinkedList();
	}
	
	public void agregar(Object objeto)
	{
		objetos.add(objeto);
	}
	
}
