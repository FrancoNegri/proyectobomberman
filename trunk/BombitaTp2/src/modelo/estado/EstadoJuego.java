package modelo.estado;

import java.util.*;


public class EstadoJuego {

	//estados validos
	

	private String EstadoJuego;
	
	public EstadoJuego(){
		
		this.EstadoJuego = "JUGANDO";
	}
	
	public void juego_ganado(){
		
		this.EstadoJuego = "GANADO";
	}
	
	public void juego_perdido(){
		
		this.EstadoJuego = "PERDIDO";
		
	}
	
	public boolean gano(){
		
		return (this.EstadoJuego == "GANADO");
	}
	
	public boolean perdio(){
		
		return (this.EstadoJuego == "PERDIDO");
		
	}
	
	
}
