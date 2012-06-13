package modelo.articulotest;

import static org.junit.Assert.*;
import org.junit.*;
import modelo.articulo.*;
import modelo.personaje.*;
import modelo.errores.*;


public class TestHabano {

	private Bombita rodriguez;
	private Habano unHabano;
	private float VelocidadPrueba;
	
	@Before
	public void setUp(){
		
		this.rodriguez = new Bombita();
		this.unHabano = new Habano();
		this.VelocidadPrueba = 15;
		
	}
	
	public void testUsar(){
		
		this.unHabano.usar(rodriguez);
		float velocidad= this.rodriguez.getVelocidad();
		assertTrue(velocidad==this.VelocidadPrueba);
		
	}
	
	public void testUsarconBombitaNull(){
		
		this.rodriguez=null;
		try{
			
			this.unHabano.usar(this.rodriguez);
		}
		catch (PersonajeNoInicializadoError e){
			
			assert(true);
		}
	}
	
	public void testaumentarVelocidad(){
		
		this.unHabano.aumentarVelocidad(this.rodriguez);
		float velocidad=this.rodriguez.getVelocidad();
		assertTrue(velocidad==this.VelocidadPrueba);
		
	}
	
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
