package modelo.DetectorDeColisionesTest;

import static org.junit.Assert.*;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.detectorcolision.Colisionador;
import modelo.detectorcolision.DetectorColision;
import modelo.personaje.*;
import modelo.personaje.enemigos.Comun;

import org.junit.Test;

public class ColicionadorTest {

	@Test
	public void testQuePruebaUnaColicion(){
		Colisionador coli = new Colisionador();
		Casillero miCasi = new Casillero();
		Coordenada miCord = new Coordenada(1,1);
		Personaje enemigo = new Comun(miCord);
		Personaje bomb = new Bombita(miCord);
		miCasi.agregar(enemigo);
		miCasi.agregar(bomb);
		coli.Colicionar(miCasi.obtenerPersonajes());
		assertTrue(enemigo.obtenerVida() == 9);
		assertTrue(bomb.obtenerVida() == 0);
	}


	@Test
	public void testDetectarSiSeDebeColisionarEntreBombitaYenemigo(){
		DetectorColision Detector = new DetectorColision();
		Coordenada miCord = new Coordenada(1,1);
		Personaje enemigo = new Comun(miCord);
		Personaje bombita = new Bombita(miCord);
		assertTrue(Detector.ColicionProducida(enemigo,bombita) == true);
	}
	
	@Test
	public void testDetectarSiSeDebeColisionarEntreEnemigoYenemigo(){
		DetectorColision Detector = new DetectorColision();
		Coordenada miCord = new Coordenada(1,1);
		Personaje enemigo = new Comun(miCord);
		Personaje enemigo2 = new Comun(miCord);
		assertTrue(Detector.ColicionProducida(enemigo,enemigo2) == false);
	}
	
}
