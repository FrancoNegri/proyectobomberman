package modelo.salida;

import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import vista.fiuba.algo3.titiritero.modelo.ObjetoVivo;
import vista.fiuba.algo3.titiritero.dibujables.*;

import vista.objeto.ObjetoVisible;
import vista.objeto.VistaObjeto;
import modelo.coordenadas.Coordenada;



public class Salida implements ObjetoVivo,ObjetoPosicionable,ObjetoVisible {
	 
	 private boolean Activada;
	 private Coordenada coordenada;
	 
	 public Salida(Coordenada coord){
		 
		 this.coordenada = coord;
		 this.Activada = true;
	 }
	 
	 public boolean activada(){
		 
		 return this.Activada;
		 
	 }
	 
	 
	 public void DeterminarObjeto(VistaObjeto vistaObjeto){
			vistaObjeto.InteractuarConSalida(this);
		}
		
		public int getX() {
			
			return this.coordenada.obtenerCoordenadaX();
			
			}

		public int getY() {
				
			return this.coordenada.obtenerCoordenadaY();
			}
		
		public void vivir(){
			
		}
	 
	 
	
	
	
}