package modelo.articulotest;

import modelo.armamento.*;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;

import org.junit.Before;
import org.junit.Test;


public class ProyoctilTest {
	
	private Mapa mapa;
	private Armamento arma;
	private Coordenada coord;
	@Before
	public void SetUp(){
		coord = new Coordenada(1,1);
		mapa = new Mapa(3);
		arma = new Proyectil(coord,2);
		Casillero casillero = mapa.obtenerCasillero(coord);
		casillero.agregar(arma);
	}
	
	
	@Test
	public void testQueVerificaPonerUnProyectilEnUnMapaYloActualiza(){
		
		
		
		
		
		
		
	}
}
