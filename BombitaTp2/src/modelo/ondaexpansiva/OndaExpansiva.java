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
    
    public void Expandirse(int x, int y, Mapa mapa){
    	expandirseArriba(x,y,mapa);
    	expandirseAderecha(x,y,mapa);
    	expandirseAbajo(x,y,mapa);
    	expandirseAizquierda(x,y,mapa);	
    }
    
    public void expandirseArriba(int x,int y, Mapa mapa){//A partir de la posicion donde explota la bomba,camina como un objeto la zona afectada de acuerdo al radio
    	int j;
    	Casillero C;
    	
    	for(j=1;j<=this.radio;j++){
    		C = mapa.obtenerCasillero(x,y+j);
    		this.atacar(C);
    	}
    }
    
    public void expandirseAderecha(int x,int y, Mapa mapa){
    	int j;
    	Casillero C;
    	
    	for(j=1;j<=this.radio;j++){
    		C = mapa.obtenerCasillero(x+j,y);
    		this.atacar(C);
    	}
    }
    
    public void expandirseAbajo(int x,int y, Mapa mapa){
    	int j;
    	Casillero C;
    	
    	for(j=1;j<=this.radio;j++){
    		C = mapa.obtenerCasillero(x-j,y);
    		this.atacar(C);
    	}
    }			
    	 
    public void expandirseAizquierda(int x,int y, Mapa mapa){
    	int j;
    	Casillero C;
    	
    	for(j=1;j<=this.radio;j++){
    		C = mapa.obtenerCasillero(x,y-j);
    		this.atacar(C);
    	}
    }
    
    public void atacar(Casillero unCasillero){//Si encuentra un bloque lo degrada.
    	
    }
    

}