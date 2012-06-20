package modelo.mapatest;

import modelo.mapa.*;
import modelo.errores.*;
import modelo.casillero.*;
import modelo.coordenadas.Coordenada;
import static org.junit.Assert.*;
import org.junit.*;

public class TableroTest {
	
	private int tamanio;
	@SuppressWarnings("unused")
	private Casillero unCasillero;
	private Tablero unTablero;
	@Before
	
	public void setUp(){
		
		this.tamanio=5;
		this.unCasillero= new Casillero();
		this.unTablero= new Tablero(this.tamanio);
	}
	
	@Test
	
	public void testConstructorconTamanioInvalido(){
		
		try{
			
			this.unTablero = new Tablero(-1);
			fail("el tablero permite un tamanio negativo");
		}
		catch(TamanioMatrizInvalidoError e){
			
			
		}
	}
	
	@Test
	
	public void testObtenercasillero(){
		Coordenada cord = new Coordenada(4,2);
		Casillero casilleroprueba = this.unTablero.obtenerCasillero(cord);
		assertTrue(casilleroprueba.getClass() == Casillero.class);
	}
	/*
	 * 
	 * Este Test ya no es nesesario, Del Chequeo Negativo se encarga la coordenada
	 * 
	@Test
	public void testObtenercasilleroTamanioNegativo(){
		
		try{
			Coordenada cord = new Coordenada(-1,2);
			this.unTablero.obtenerCasillero(cord);
			fail("acepta posiciones negativas");
			
		}
		catch (TamanioMatrizInvalidoError e){
			
		}
		
	}
	*/
	@Test
	
	public void testObtenercasilleroTamaniofueradeRango(){
		
		try{
			Coordenada cord = new Coordenada(7,1);
			this.unTablero.obtenerCasillero(cord);
			fail("acepta posiciones fuera de rango");
		}
		catch (TamanioMatrizInvalidoError e){
			
		}
	}
	/*
	 * 
	 * test no nesesario se encarga coordenada
	 * 
	@Test
	public void testCambiarcasilleroTamanioNegativo(){
		
		try{
			Coordenada cord =  new Coordenada(-3,1);
			Casillero unCasillero = new Casillero();
			unCasillero.cambiarIdentificador("casilleroPrueba");
			this.unTablero.cambiarCasillero(cord, unCasillero);
			fail("acepta posiciones negativas");
		}
		catch(TamanioMatrizInvalidoError e){
			
		}
		
	}
	*/
	@Test
	
	public void testCambiarcasilleroTamaniofueradeRango(){
		
		try{
			Coordenada cord =  new Coordenada(8,1);
			Casillero unCasillero = new Casillero();
			this.unTablero.cambiarCasillero(cord, unCasillero);
			fail("acepta posiciones fuera de rango");
		}
		catch(TamanioMatrizInvalidoError e){
			
		}
	}
	
	@Test
	
	public void testObtenerTamanio(){
		
		
		assertTrue(this.unTablero.obtenerTamanio()==5);
		
	}
	

}
