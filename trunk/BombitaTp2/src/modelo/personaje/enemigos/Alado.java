package modelo.personaje.enemigos;

import modelo.ArmamentoFactory.MolotovFactory;
import modelo.coordenadas.Coordenada;
import modelo.personaje.*;

public class Alado extends Enemigo {

	public Alado(Coordenada unaCoordenada) {
		super(unaCoordenada);
		this.CreadorDeBombas = new MolotovFactory();
	}
}
