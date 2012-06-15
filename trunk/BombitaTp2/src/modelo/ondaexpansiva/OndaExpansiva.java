package modelo.ondaexpansiva;

import modelo.casillero.Casillero; 
import modelo.coordenadas.Coordenada;
import modelo.coordenadas.Translacion;
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
    
    public void Expandirse(Coordenada cordenada,Mapa mapa){
    	Translacion movDerecha = new Translacion(true,false,false,false);//es feo pero no se me ocurre otra manera do hacerlo mas claro.
    	Translacion movIzquierda = new Translacion(false,true,false,false);
    	Translacion movAbajo = new Translacion(false,false,false,true);
    	Translacion movArriba = new Translacion(false,false,true,false);//creo movimientos
    	
    	this.expandirse(cordenada,mapa,movDerecha);//los uso
    	this.expandirse(cordenada,mapa,movIzquierda);
    	this.expandirse(cordenada,mapa,movAbajo);
    	this.expandirse(cordenada,mapa,movArriba);
    }
    private void expandirse(Coordenada cordenada,Mapa mapa,Translacion mov){
    	Coordenada nuevaCord = new Coordenada(cordenada.obtenerCoordenadaX(),cordenada.obtenerCoordenadaY());
    	nuevaCord.cambiarCoordenadaX(cordenada.obtenerCoordenadaX());
    	nuevaCord.cambiarCoordenadaY(cordenada.obtenerCoordenadaY());
    	int j;
    	Casillero unCasillero;
    	boolean ataco = false;
    	
    	for(j=1; (j<=this.radio) && (!ataco); j++){
    		nuevaCord = mov.accion(nuevaCord);
    		unCasillero = mapa.obtenerCasillero(nuevaCord);
    		if (!unCasillero.estaVacio()){
    			this.atacar(unCasillero);
    		    ataco = true;
    		}
    	}
    }
    
    private void atacar(Casillero unCasillero){//Si encuentra un bloque lo degrada.
    	
    }
}