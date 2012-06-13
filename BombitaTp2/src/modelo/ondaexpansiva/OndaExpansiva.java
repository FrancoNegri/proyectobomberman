package modelo.ondaexpansiva;
import modelo.obstaculos.Obstaculo; 
import modelo.personaje.Caminable;
import modelo.personaje.Personaje;

public class OndaExpansiva implements Caminable {
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
    
    public void Expandirse(int x,int y){//A partir de la posicion donde explota la bomba,camina como un objeto la zona afectada de acuerdo al radio
    	int j;
    	
    	 for(j=1;j<=this.radio;j++){
    			//Falta implementacion
    	 }
    }
    
    public void degradarBloque(Obstaculo unObstaculo){//Si encuentra un bloque lo degrada.
   	   	unObstaculo.QuitarVida(this.danio);    
    	
    }

	public void mover(Personaje unPersonaje){
		
	}
}