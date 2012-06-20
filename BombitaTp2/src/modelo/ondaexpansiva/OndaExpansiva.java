package modelo.ondaexpansiva;

import modelo.Translacion.*;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import java.util.*;
import modelo.personaje.*;
import modelo.obstaculos.*;


public class OndaExpansiva{
    private int radio;
    private int danio;
    
    public OndaExpansiva(int radioExplocion,int danioExplocion) {
   	 	this.radio=radioExplocion;
   	 	this.danio=danioExplocion;	
    }
    
    public int getRadio(){																						
   	 	return radio;
    }
    
    public int getDanio(){
    	return danio;
    }
    
    public void Expandirse(Coordenada cordenada,Mapa mapa){
    	Translacion movDerecha = new TranslacionDerecha();
    	Translacion movIzquierda = new TranslacionIzquierda();
    	Translacion movAbajo = new TranslacionArriba();
    	Translacion movArriba = new TranslacionAbajo();//creo movimientos
    	
    	this.expandirse(cordenada,mapa,movDerecha);//los uso
    	this.expandirse(cordenada,mapa,movIzquierda);
    	this.expandirse(cordenada,mapa,movAbajo);
    	this.expandirse(cordenada,mapa,movArriba);
    }
    private void expandirse(Coordenada cordenada,Mapa mapa,Translacion mov){
    	Coordenada nuevaCord = new Coordenada(cordenada.obtenerCoordenadaX(),cordenada.obtenerCoordenadaY());
    	int j;
    	Casillero unCasillero;
    	boolean ataco = false;
    	for(j=1; (j<=this.radio) && (!ataco); j++){
    		try{
    			//A Tener En Cuenta: el ciclo no esta comprobando si se llega al final del mapa
    			//Por eso puse el try catch ver si se puede hacer mejor. Franco
    			nuevaCord = mov.accion(nuevaCord);
        		unCasillero = mapa.obtenerCasillero(nuevaCord);
        		if (unCasillero.esAtacable()){
        			this.atacar(unCasillero);
        		    ataco = true;
        		}
    		}catch(Exception e){
    			return;
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
    		unPersonaje.Daniar(this.getDanio());
    		int indicePersonaje = Personajes.indexOf(unPersonaje);
    		Personajes.set(indicePersonaje, unPersonaje);	
    	}	
    }
    
    private void atacarObstaculo(Casillero unCasillero){
    	
    	Obstaculo unObstaculo = unCasillero.obtenerObstaculo();
    	if (unObstaculo != null ){
    		
    		unObstaculo.Daniar(this.getDanio());
    		unCasillero.agregar(unObstaculo);
    	}
    	
    }
    
}