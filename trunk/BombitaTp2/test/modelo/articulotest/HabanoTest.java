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
	Coordenada coordenada;
	@Before
	public void setUp(){
		
		coordenada = new Coordenada(1,2);
		Mapa mapa = new Mapa(5);
		rodriguez = new Bombita(coordenada,mapa);
		unHabano = new Habano(coordenada);
		
	}
	@Test
	public void testUsar(){
		
		unHabano.usar(rodriguez);
		assertTrue(rodriguez.getVelocidad() == 14);
		
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
		
		unHabano.aumentarVelocidad(rodriguez);
		int velocidad = rodriguez.getVelocidad();
		assertTrue(velocidad == 14);
		
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

	@Test
	public void testAumentarVelocidadSuperandoVelocidadMaxima() {
		rodriguez.cambiarVelocidad(49);
		unHabano.aumentarVelocidad(rodriguez);
	}
	
	@Test
	public void testCambiarVelocidadBombitaDespuesDeFumarseUnHabano() {
		unHabano.aumentarVelocidad(rodriguez);
		assertTrue(rodriguez.getVelocidad() == 14);
	}
	
	@Test
	public void testVelocidadEnCeroBombitaYTomaArticulo() {
		rodriguez.cambiarVelocidad(0);
		unHabano.aumentarVelocidad(rodriguez);
	}
	
}
