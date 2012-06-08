package modelo.ondaexpansiva;

import modelo.obstaculos.Obstaculo;

public class OndaExpansiva {
    int radio;
    
    public OndaExpansiva(int r) {
   	 this.radio=r;
    }
    
    public int getRadio(){
   	 return radio;
    }
    
    public void identificarZona(int x,int y){/*A partir de la posicion donde explota la bomba,
                                            identifica la zona afectada de acuerdo al radio*/
   	 
    }
    
    public void degradarBloque(Obstaculo unObstaculo){//Si encuentra un bloque lo degrada.
   	 
    }
}
