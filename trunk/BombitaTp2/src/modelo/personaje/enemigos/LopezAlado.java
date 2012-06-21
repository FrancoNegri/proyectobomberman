package modelo.personaje.enemigos;

import modelo.ArmamentoFactory.MolotovFactory;
import modelo.constantesjuego.ConstantesJuego;
import modelo.coordenadas.Coordenada;
import modelo.personaje.*;

public class LopezAlado extends Enemigo {

	public LopezAlado(Coordenada unaCoordenada) {
		super(unaCoordenada);
		this.CreadorDeBombas = new MolotovFactory();
		this.vida = ConstantesJuego.vida_lopez_reggae_alado;
		this.velocidad = ConstantesJuego.velocidad_lopez_reggae_alado;
	}
}