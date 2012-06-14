package modelo.mapatest;

import modelo.mapa.*;
import modelo.errores.*;
import modelo.casillero.*;
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
		
		this.unCasillero = this.unMapa.obtenerCasillero(2,3);
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
		
		this.unCasillero.cambiarIdentificador("casilleroPrueba");
		this.unMapa.agregarCasillero(3, 1, unCasillero);
		Casillero CasilleroPrueba = this.unMapa.obtenerCasillero(3, 1);
		assertTrue(CasilleroPrueba.obtenerIdentificador() == "casilleroPrueba");	
	}
	
	@Test
	
	public void testagregarCasilleroTamanioNegativo(){
		
		try{
			
			this.unMapa.agregarCasillero(3 , -2, this.unCasillero);
		}
		catch(TamanioMatrizInvalidoError e){
			
		}			
		
	}
	
	@Test
	
	public void testagregarCasilleroTamanioFueraDeRango(){
		
		try{
			
			this.unMapa.agregarCasillero(3 , 9, this.unCasillero);
		}
		catch(TamanioMatrizInvalidoError e){
			
		}
		
		
	}
	
	@Test
	
	public void testObtenerCasillero(){
		
		Casillero casilleroPrueba = this.unMapa.obtenerCasillero(2, 4);
		assertTrue(casilleroPrueba.obtenerIdentificador() == "noName");
		
	}
	
	@Test
	
	public void testObtenerCasilleroTamanioNegativo(){
		
		try{
			
			this.unMapa.obtenerCasillero(-2, 3);
		}
		catch(TamanioMatrizInvalidoError e){
			
		}
		
	}
	
	@Test
	
	public void testObtenerCasilleroTamanioFueraDeRango(){
		
		try{
			
			this.unMapa.obtenerCasillero(7 , 2);
		}
		catch(TamanioMatrizInvalidoError e){
			
		}
		
	}


	
}
