package modelo.mapatest;

import modelo.mapa.*;
import modelo.errores.*;
import modelo.casillero.*;
import static org.junit.Assert.*;
import org.junit.*;

public class testTablero {
	
	private int tamanio;
	
	private Casillero unCasillero;
	
	private Tablero unTablero;
	
	@Before
	
	public void setUp(){
		
		this.tamanio=5;
		this.unCasillero= new Casillero();
		this.unTablero= new Tablero(this.tamanio);
	}
	
	@Test
	
	public void testConstructor(){
		
		this.unCasillero = this.unTablero.obtenerCasillero(3, 2);
		assertTrue(unCasillero.obtenerIdentificador()=="noName");
	
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
		
		Casillero casilleroprueba = this.unTablero.obtenerCasillero(4, 2);
		assertTrue(casilleroprueba.obtenerIdentificador()=="noName");
		
	}
	
	@Test
	
	public void testObtenercasilleroTamanioNegativo(){
		
		try{
			
			this.unTablero.obtenerCasillero(-1, 2);
			fail("acepta posiciones negativas");
			
		}
		catch (TamanioMatrizInvalidoError e){
			
		}
		
	}
	
	@Test
	
	public void testObtenercasilleroTamaniofueradeRango(){
		
		try{
			
			this.unTablero.obtenerCasillero(7, 1);
			fail("acepta posiciones fuera de rango");
		}
		catch (TamanioMatrizInvalidoError e){
			
		}
	}
	
	@Test
	
    public void testCambiarcasillero(){
		
		Casillero unCasillero = new Casillero();
		unCasillero.cambiarIdentificador("casilleroPrueba");
		this.unTablero.cambiarCasillero(4, 1, unCasillero);
		Casillero casilleroPrueba = this.unTablero.obtenerCasillero(4, 1);
		assertTrue(casilleroPrueba.obtenerIdentificador()=="casilleroPrueba");
		
	}
	
	@Test
	
	public void testCambiarcasilleroTamanioNegativo(){
		
		try{
			
			Casillero unCasillero = new Casillero();
			unCasillero.cambiarIdentificador("casilleroPrueba");
			this.unTablero.cambiarCasillero(-3, 1, unCasillero);
			fail("acepta posiciones negativas");
		}
		catch(TamanioMatrizInvalidoError e){
			
		}
		
	}
	
	@Test
	
	public void testCambiarcasilleroTamaniofueradeRango(){
		
try{
			
			Casillero unCasillero = new Casillero();
			unCasillero.cambiarIdentificador("casilleroPrueba");
			this.unTablero.cambiarCasillero(8, 1, unCasillero);
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
