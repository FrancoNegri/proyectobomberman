package modelo.articulotest;

import modelo.Translacion.Translacion;
import modelo.Translacion.TranslacionArriba;
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
		Translacion trans = new TranslacionArriba();
		arma = new Proyectil(coord,mapa,trans);
		Casillero casillero = mapa.obtenerCasillero(coord);
		casillero.agregar(arma);
	}
	
	
	@Test
	public void testQueVerificaPonerUnProyectilEnUnMapaYloActualiza(){
		arma.actualizar();
	}
}
