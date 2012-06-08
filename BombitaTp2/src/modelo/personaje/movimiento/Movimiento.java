package modelo.personaje.movimiento;

import java.util.*;

import modelo.personaje.Caminable;
import modelo.personaje.Personaje;

public abstract class Movimiento implements Caminable {
	
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
	
	public int obtenerNumeroRandom(){
		//Devuelve un numero entre 0 y 9
		int numero = (int) Math.round((Math.random()*1000)); 
		return ( (numero % 4) + 1);
	}
	

	public abstract void mover(Personaje unPersonaje);

}
