package Modelo;
import Errores.*;

public abstract class Obstaculo {
	int vida;
	
	public Obstaculo(int vidaTotal){
		if(vidaTotal <= 0)
			throw new VidaInvalidaError();
		vida = vidaTotal;
	}
	
	public void QuitarVida(int daño) {
		if((vida > 0)&&(daño > 0))
		{
			vida = vida - daño;
		}
	}
	
	public boolean Destruido() {
		if(vida<= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public int vidaRestante() {
		return vida;
	}
}
