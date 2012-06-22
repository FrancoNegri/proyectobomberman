package modelo.DetectorDeColisionesTest;

import static org.junit.Assert.*;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.detectorcolision.Colisionador;
import modelo.mapa.Mapa;
import modelo.personaje.*;
import modelo.personaje.enemigos.LopezComun;
import org.junit.Test;
import static org.mockito.Mockito.*;
public class ColicionadorTest {

	@Test
	public void testQuePruebaUnaColicion(){
		Colisionador coli = new Colisionador();
		Casillero miCasi = new Casillero();
		Coordenada miCord = new Coordenada(1,1);
		Mapa mapa = mock(Mapa.class);
		Personaje enemigo = new LopezComun(miCord,mapa);
		Personaje bomb = new Bombita(miCord,mapa);
		miCasi.agregar(enemigo);
		miCasi.agregar(bomb);
		coli.Colicionar(miCasi.obtenerPersonajes());
		assertTrue(enemigo.obtenerVida() == 9);
		assertTrue(bomb.obtenerVida() == 0);
	}
}
