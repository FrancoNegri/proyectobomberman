package modelo.articulotest;

import static org.junit.Assert.*;
import org.junit.*;
import modelo.articulo.*;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.personaje.*;
import modelo.errores.*;

public class HabanoTest {

	private Bombita rodriguez;
	private Habano unHabano;
	private float VelocidadPrueba;
	Coordenada coordenada;
	@Before
	public void setUp(){
		
		coordenada = new Coordenada(1,2);
		Mapa mapa = new Mapa(5);
		this.rodriguez = new Bombita(coordenada,mapa);
		this.unHabano = new Habano(coordenada);
		this.VelocidadPrueba = 20;
		
	}
	@Test
	public void testUsar(){
		
		this.unHabano.usar(rodriguez);
		float velocidad= this.rodriguez.getVelocidad();
		assertTrue(velocidad==this.VelocidadPrueba);
		
	}
	@Test
	public void testObtenerCoordenadas(){
		assertTrue(unHabano.obtenerCoordenadaXY().obtenerCoordenadaX()== coordenada.obtenerCoordenadaX());
		assertTrue(unHabano.obtenerCoordenadaXY().obtenerCoordenadaY()== coordenada.obtenerCoordenadaY());
	}
	@Test
	public void testUsarconBombitaNull(){
		
		this.rodriguez=null;
		try{
			
			this.unHabano.usar(this.rodriguez);
		}
		catch (PersonajeNoInicializadoError e){
			
			assert(true);
		}
	}
	@Test
	public void testaumentarVelocidad(){
		
		this.unHabano.aumentarVelocidad(this.rodriguez);
		float velocidad=this.rodriguez.getVelocidad();
		assertTrue(velocidad==this.VelocidadPrueba);
		
	}
	@Test
	public void testaumentarVelocidadsuperandoVelocidadMaxima(){
		this.rodriguez.cambiarVelocidad(30);
		try{
			this.unHabano.usar(this.rodriguez);
		}
		catch (VelocidadMaximaError e){
		
			assert(true);
		}	
	}

		
	
	
}
