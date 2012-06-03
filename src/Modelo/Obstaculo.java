package Modelo;
import Errores.*;

public abstract class Obstaculo {
	int vida;
	
	public Obstaculo(int vidaTotal){
		if(vidaTotal <= 0)
			throw new VidaInvalidaError();
		vida = vidaTotal;
	}
	
	public void QuitarVida(int da�o) {
		if((vida > 0)&&(da�o > 0))
		{
			vida = vida - da�o;
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
