package modelo.obstaculos;

import modelo.errores.VidaInvalidaError;
import modelo.coordenadas.Coordenada;
import modelo.danio.*;

public abstract class Obstaculo implements Daniable{
	Coordenada cordenadaObsaculo;
	int vida;
	public Obstaculo(int vidaTotal,Coordenada unacoordenada){
		if(vidaTotal <= 0)
			throw new VidaInvalidaError();
		this.vida = vidaTotal;
		cordenadaObsaculo = unacoordenada;
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
	
}
