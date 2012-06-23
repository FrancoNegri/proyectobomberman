package modelo.ondaexpansiva;

import modelo.Translacion.*;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.fuegoDeExplocion.FuegoDeExplocion;
import modelo.mapa.Mapa;
import java.util.*;

import vista.objeto.ObjetoVisible;
import vista.objeto.VistaObjeto;
import modelo.personaje.*;
import modelo.obstaculos.*;


public class OndaExpansiva {
    private int radio;
    private int danio;
    
    public OndaExpansiva(int radioExplocion,int danioExplocion) {
   	 	this.radio=radioExplocion;
   	 	this.danio=danioExplocion;	
    }
    
    public void Expandirse(Coordenada cordenada,Mapa mapa){    	
    	this.expandirse(cordenada,mapa,new TranslacionDerecha());//los uso
    	this.expandirse(cordenada,mapa,new TranslacionIzquierda());
    	this.expandirse(cordenada,mapa,new TranslacionAbajo());
    	this.expandirse(cordenada,mapa,new TranslacionArriba());
    }
    private void expandirse(Coordenada cordenada,Mapa mapa,Translacion mov){
    	Coordenada nuevaCord = cordenada.copiar();
    	Casillero unCasillero;
    	boolean ataco = false;
    	for(int j=1; (j<=this.radio) && (!ataco); j++){
    		nuevaCord = mov.accion(nuevaCord);
    		try{
    		unCasillero = mapa.obtenerCasillero(nuevaCord);
    		}catch(Exception e){
    			return;
    		}
    		if(unCasillero.esAtacable()){
    			this.atacar(unCasillero);
    			return;
    		}else{
    			unCasillero.agregar(new FuegoDeExplocion(nuevaCord));
    		}
    	}
    }
    
    private void atacar(Casillero unCasillero){//Si encuentra un bloque lo degrada.
    	
    	this.atacarPersonajes(unCasillero);
    	this.atacarObstaculo(unCasillero);
    	
    }
    
    private void atacarPersonajes(Casillero unCasillero){
    	
    	LinkedList <Personaje> Personajes = unCasillero.obtenerPersonajes();
    	Iterator <Personaje> itPersonajes = Personajes.iterator();
    	while(itPersonajes.hasNext()){
    			
    		Personaje unPersonaje = itPersonajes.next();
    		unPersonaje.Daniar(danio);
    		int indicePersonaje = Personajes.indexOf(unPersonaje);
    		Personajes.set(indicePersonaje, unPersonaje);	
    	}	
    }
    
    private void atacarObstaculo(Casillero unCasillero){
    	
    	Obstaculo unObstaculo = unCasillero.obtenerObstaculo();
    	if (unObstaculo != null ){
    		
    		unObstaculo.Daniar(danio);
    		unCasillero.agregar(unObstaculo);
    	}
    }
    
}