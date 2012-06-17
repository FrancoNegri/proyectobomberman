package modelo.DetectorDeColisionesTest;

import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.detectorcoalision.Coalisionador;
import modelo.personaje.*;
import modelo.personaje.enemigos.Comun;

import org.junit.Test;

public class ColicionadorTest {

	@Test
	public void testQuePruevaUnaColicion(){
		Coalisionador coli = new Coalisionador();
		Casillero miCasi = new Casillero();
		Coordenada miCord = new Coordenada(1,1);
		Personaje enemigo = new Comun(miCord);
		Personaje bomb = new Bombita(miCord);
		miCasi.agregar(enemigo);
		miCasi.agregar(bomb);
		coli.Colicionar(miCasi.obtenerPersonajes());
	}
}
