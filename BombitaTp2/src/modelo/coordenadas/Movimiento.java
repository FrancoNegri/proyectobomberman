package modelo.coordenadas;

public class Movimiento {
	
	private boolean MoverDerecha;
	private boolean MoverIzquierda;
	private boolean MoverArriba;
	private boolean MoverAbajo;
	
	public Movimiento(boolean D,boolean I,boolean Arr,boolean Ab)
	{
		MoverDerecha = D;
    	MoverIzquierda = I;
    	MoverArriba = Arr;
    	MoverAbajo = Ab;
	}
	public Coordenada accion(Coordenada cordenada){
		Coordenada nuevaCord = new Coordenada(cordenada.obtenerCoordenadaX(),cordenada.obtenerCoordenadaY());
		if(MoverDerecha){
			nuevaCord.cambiarCoordenadaX(cordenada.obtenerCoordenadaX()+1);
		}
		else{
			if(MoverIzquierda){
				nuevaCord.cambiarCoordenadaX(cordenada.obtenerCoordenadaX()-1);
        	}
		}
    	if(MoverArriba){
    		nuevaCord.cambiarCoordenadaY(cordenada.obtenerCoordenadaY()+1);
    	}else{
    		if(MoverAbajo){
    			nuevaCord.cambiarCoordenadaY(cordenada.obtenerCoordenadaY()-1);
            }
    	}
    	return nuevaCord;
	}
}
