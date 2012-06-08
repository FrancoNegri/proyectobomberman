package modelo.personaje.movimiento;

import java.util.*;

public abstract class Movimiento {
	
	private ArrayList<Movimiento> movimientos;
	
	public Movimiento(){
		this.movimientos = new ArrayList<Movimiento>();
		
		Derecha derecha = new Derecha();
		Izquierda izquierda = new Izquierda();
		Abajo abajo = new Abajo();
		Arriba arriba = new Arriba();
		
		//Inicializo la lista de objetos movimientos
		this.movimientos.add(derecha);
		this.movimientos.add(izquierda);
		this.movimientos.add(abajo);
		this.movimientos.add(arriba);
		
	}
	
	public int funcionRandom(){
		//Modificar esta parte para sacar uno al azar
		return movimientos.size();
	}
	

	public abstract void mover();

}
