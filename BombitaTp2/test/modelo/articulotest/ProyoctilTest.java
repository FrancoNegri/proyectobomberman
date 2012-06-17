package modelo.articulotest;

import modelo.Translacion.*;
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
		Translacion trans = new TranslacionArriba();
		coord = new Coordenada(1,1);
		mapa = new Mapa(3);
		arma = new Proyectil(coord,trans);
		Casillero casillero = mapa.obtenerCasillero(coord);
		casillero.agregar(arma);
	}
	
	
	@Test
	public void testQueVerificaPonerUnProyectilEnUnMapaYloActualiza(){
		
		
		
		
		
		
		
	}
}
