package modelo.ondaexpansiva;

import modelo.casillero.Casillero; 
import modelo.mapa.Mapa;  

public class OndaExpansiva{
    private int radio;
    private int danio;
    
    public OndaExpansiva(int r,int d) {
   	 	this.radio=r;
   	 	this.danio=d;
    }
    
    public int getRadio(){
   	 	return radio;
    }
    
    public int getDanio(){
    	return danio;
    }
    
    public void Expandirse(int x,int y,Mapa mapa){
    	this.expandirseArriba(x,y,mapa);
    	this.expandirseAderecha(x,y,mapa);
    	this.expandirseAbajo(x,y,mapa);
    	this.expandirseAizquierda(x,y,mapa);	
    }
    
    public void expandirseArriba(int x,int y,Mapa mapa){
    	int j;
    	Casillero unCasillero;
    	boolean ataco = false;
    	
    	for(j=1; (j<=this.radio) && (!ataco); j++){
    		unCasillero = mapa.obtenerCasillero(x,y+j);
    		if (!unCasillero.estaVacio()){
    			this.atacar(unCasillero);
    		    ataco = true;
    		}
    	}
    }
    
    public void expandirseAderecha(int x,int y,Mapa mapa){
    	int j;
    	Casillero unCasillero;
    	boolean ataco = false;
    	
    	for(j=1; (j<=this.radio) && (!ataco); j++){
    		unCasillero = mapa.obtenerCasillero(x+j,y);
    		if (!unCasillero.estaVacio()){
    			this.atacar(unCasillero);
    		    ataco = true;
    		}
    	}
    }
    
    public void expandirseAbajo(int x,int y,Mapa mapa){
    	int j;
    	Casillero unCasillero;
    	boolean ataco = false;
    	
    	for(j=1; (j<=this.radio) && (!ataco); j++){
    		unCasillero = mapa.obtenerCasillero(x,y-j);
    		if (!unCasillero.estaVacio()){
    			this.atacar(unCasillero);
    		    ataco = true;
    		}
    	}
    }			
    	 
    public void expandirseAizquierda(int x,int y,Mapa mapa){
    	int j;
    	Casillero unCasillero;
    	boolean ataco = false;
    	
    	for(j=1; (j<=this.radio) && (!ataco); j++){
    		unCasillero = mapa.obtenerCasillero(x-j,y);
    		if (!unCasillero.estaVacio()){
    			this.atacar(unCasillero);
    		    ataco = true;
    		}
    	}
    }
    
    public void atacar(Casillero unCasillero){//Si encuentra un bloque lo degrada.
    	
    }
    

}