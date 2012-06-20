package modelo.obstaculos;


import modelo.coordenadas.Coordenable;
import modelo.coordenadas.Coordenada;
import modelo.danio.*;

public abstract class Obstaculo implements Daniable,Coordenable{
	Coordenada cordenadaObsaculo;
	int vida;
	protected int puntaje;
	
	public Obstaculo(int vidaTotal,Coordenada unacoordenada){ 
		this.vida = vidaTotal;
		cordenadaObsaculo = unacoordenada;
	}
	
	public Coordenada obtenerCoordenadaXY(){
		return cordenadaObsaculo;
	}

	public void QuitarVida(int danio) {
		if((vida > 0)&&(danio > 0))
		{
			vida = vida - danio;
		}
	}
	
	public boolean Destruido() {
		return (vida <= 0);
	}

	public int vidaRestante() {
		return vida;
	}
	
	public void Daniar(int danio){
		
		if(!this.Destruido()){
			
			this.QuitarVida(danio);
		}
		
		
	}
	
	public int obtenerPuntaje() {
		if ( this.Destruido() ) {
			return puntaje;
		}
	}
}
