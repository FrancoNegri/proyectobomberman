package modelo.coordenadastest;

import static org.junit.Assert.*;
import modelo.coordenadas.Coordenada;
import modelo.errores.coordenadaInvalida;

import org.junit.Test;


public class testCoordenadas {
	
	@Test
	public void testQueVerificaSeteo(){
		Coordenada coord = new Coordenada(1,2);
		assertTrue(coord.obtenerCoordenadaX() == 1);
		assertTrue(coord.obtenerCoordenadaY() == 2);
	}
	
	@Test
	public void testQuePruebaErrorAlSetearMal(){
		try{
			Coordenada coord = new Coordenada(1,-1);
		}catch(coordenadaInvalida e){
			assertTrue(true);
		}
	}
	
	
	
	
	
}
