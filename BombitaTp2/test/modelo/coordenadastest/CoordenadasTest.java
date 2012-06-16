package modelo.coordenadastest;

import static org.junit.Assert.*;
import modelo.coordenadas.Coordenada;
import modelo.errores.coordenadaInvalida;

import org.junit.Test;


public class CoordenadasTest {
	
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
			coord.obtenerCoordenadaX();
		}catch(coordenadaInvalida e){
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}
	
	@Test
	public void testQuePruebaErrorAlModificarX(){
		try{
			Coordenada coord = new Coordenada(2,2);
			coord.cambiarCoordenadaX(-2);
		}catch(coordenadaInvalida e){
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}
	
	@Test
	public void testQuePruebaErrorAlModificarY(){
		try{
			Coordenada coord = new Coordenada(2,2);
			coord.cambiarCoordenadaY(-2);
		}catch(coordenadaInvalida e){
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}
}
