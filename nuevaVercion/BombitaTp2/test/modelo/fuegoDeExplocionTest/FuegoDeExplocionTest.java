package modelo.fuegoDeExplocionTest;

import modelo.coordenadas.Coordenada;
import modelo.fuegoDeExplocion.FuegoDeExplocion;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class FuegoDeExplocionTest {

	@Test
	public void FuegoDeExplocionVivir(){
		Coordenada coord = mock(Coordenada.class);
		when(coord.obtenerCoordenadaX()).thenReturn(2);
		when(coord.obtenerCoordenadaY()).thenReturn(2);
		
		int vida = 3;
		FuegoDeExplocion fuego = new FuegoDeExplocion(coord,vida);
		for(int j = 0; j<vida;j++){
			assertTrue(fuego.estaMuerto() != true);
			fuego.vivir();
		}
		assertTrue(fuego.estaMuerto());
		
	}
	
	@Test
	public void obtenerCoordenadaDelFuego() {
		Coordenada coord = new Coordenada(2,2);
		FuegoDeExplocion fuego = new FuegoDeExplocion(coord, 10);
		assertTrue(fuego.getX() == 2);
		assertTrue(fuego.getY() == 2);
	}
}
