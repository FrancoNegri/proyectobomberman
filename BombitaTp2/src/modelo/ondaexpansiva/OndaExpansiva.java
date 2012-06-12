package modelo.ondaexpansiva;

import modelo.obstaculos.Obstaculo;

public class OndaExpansiva {
    private int radio;
    
    public OndaExpansiva(int r) {
   	 this.radio=r;
    }
    
    public int getRadio(){
   	 return radio;
    }
    
    public void caminarZona(int x,int y){/*A partir de la posicion donde explota la bomba,
                                            camina como un objeto la zona afectada de acuerdo
                                            al radio*/
   	 
    }
    
    public void degradarBloque(Obstaculo unObstaculo){//Si encuentra un bloque lo degrada.
   	 
    }
}
