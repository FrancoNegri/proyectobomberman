package modelo.articulotest;

import static org.junit.Assert.*;
import org.junit.*;
import modelo.articulo.*;
import modelo.coordenadas.Coordenada;
import modelo.personaje.*;
import modelo.errores.*;
import static org.mockito.Mockito.*;

public class HabanoTest {

	private Bombita rodriguez;
	private Habano unHabano;
	private float VelocidadPrueba;
	Coordenada coordenada;
	@Before
	public void setUp(){
		
		this.rodriguez = new Bombita(coordenada);
		coordenada = new Coordenada(1,2);
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
		
		float velocidadnueva=30;
		this.rodriguez.cambiarVelocidad(velocidadnueva);
		try{
			this.unHabano.usar(this.rodriguez);
		}
		catch (VelocidadMaximaError e){
		
			assert(true);
		}	
	}
}
