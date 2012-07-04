package modelo.salida;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;

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
	
	public Coordenada obtenerCoordenadaXY(){
		
		return this.coordenada.copiar();
	}
	
	
	public static Salida recuperar(Element elemSal){
		Coordenada coord = Coordenada.recuperar(elemSal.element(new QName("Coordenada")));
		Salida Salidarecu = new Salida(coord);
		return Salidarecu;
	}
		
		
	
}