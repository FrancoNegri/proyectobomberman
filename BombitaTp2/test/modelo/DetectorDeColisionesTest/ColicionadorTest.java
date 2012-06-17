package modelo.DetectorDeColisionesTest;

import static org.junit.Assert.*;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.detectorcolision.Colisionador;
import modelo.personaje.*;
import modelo.personaje.enemigos.Comun;

import org.junit.Test;

public class ColicionadorTest {

	@Test
	public void testQuePruevaUnaColicion(){
		Colisionador coli = new Colisionador();
		Casillero miCasi = new Casillero();
		Coordenada miCord = new Coordenada(1,1);
		Personaje enemigo = new Comun(miCord);
		Personaje bomb = new Bombita(miCord);
		miCasi.agregar(enemigo);
		miCasi.agregar(bomb);
		coli.Colicionar(miCasi.obtenerPersonajes());
		assertTrue(enemigo.obtenerVida() == 99);
		assertTrue(bomb.obtenerVida() == 0);
	}
}
