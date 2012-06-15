package modelo.mapatest;

import modelo.mapa.*;
import modelo.errores.*;
import modelo.casillero.*;
import modelo.coordenadas.Coordenada;
import static org.junit.Assert.*;
import org.junit.*;

public class testMapa {

	private Mapa unMapa;
	
	private Casillero unCasillero;
	
	private int Tamanio;
	
	@Before
	
	public void setUp(){
		
		this.Tamanio = 5;
		this.unMapa = new Mapa(this.Tamanio);
		this.unCasillero = new Casillero();
		
	}
	
	@Test
	
	public void testConstructor(){
		Coordenada cord = new Coordenada(2,3);
		this.unCasillero = this.unMapa.obtenerCasillero(cord);
		assertTrue(this.unCasillero.obtenerIdentificador() == "noName");
	}
	
	@Test
	
	public void testConstructorTamanioInvalido(){
		
		try{
		
			this.unMapa = new Mapa(-3);
		}
		catch(TamanioMatrizInvalidoError e){
			
		}
		
	}
	
	@Test
	
	public void testagregarCasillero(){
		Coordenada cord = new Coordenada(3,1);
		this.unCasillero.cambiarIdentificador("casilleroPrueba");
		this.unMapa.agregarCasillero(cord, unCasillero);
		Casillero CasilleroPrueba = this.unMapa.obtenerCasillero(cord);
		assertTrue(CasilleroPrueba.obtenerIdentificador() == "casilleroPrueba");	
	}
	
	@Test
	
	public void testagregarCasilleroTamanioNegativo(){
		Coordenada cord = new Coordenada(3,-2);
		try{
			
			this.unMapa.agregarCasillero(cord, this.unCasillero);
		}
		catch(TamanioMatrizInvalidoError e){
			
		}			
		
	}
	
	@Test
	
	public void testagregarCasilleroTamanioFueraDeRango(){
		Coordenada cord = new Coordenada(3,9);
		try{
			
			this.unMapa.agregarCasillero(cord, this.unCasillero);
		}
		catch(TamanioMatrizInvalidoError e){
			
		}
		
		
	}
	
	@Test
	
	public void testObtenerCasillero(){
		Coordenada cord = new Coordenada(3,4);
		Casillero casilleroPrueba = this.unMapa.obtenerCasillero(cord);
		assertTrue(casilleroPrueba.obtenerIdentificador() == "noName");
		
	}
	
	@Test
	
	public void testObtenerCasilleroTamanioNegativo(){
		Coordenada cord = new Coordenada(3,-2);
		try{
			this.unMapa.obtenerCasillero(cord);
		}
		catch(TamanioMatrizInvalidoError e){
			
		}
		
	}
	
	@Test
	
	public void testObtenerCasilleroTamanioFueraDeRango(){
		Coordenada cord = new Coordenada(7,2);
		try{
			this.unMapa.obtenerCasillero(cord);
		}
		catch(TamanioMatrizInvalidoError e){
		}
	}
}
