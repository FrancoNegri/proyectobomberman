package modelo.articulotest;

import modelo.articulo.*;
import modelo.armamento.*;
import modelo.errores.ArmamentoNoInicializadoError;
import modelo.errores.TiempoInvalidoError;
import modelo.personaje.*;
import static org.junit.Assert.*;
import org.junit.*;

public class TestTimer {
	
	private Bombita rodriguez;
	private Armamento arma;
	private double resultadotiempo;
	private Timer unTimer;
	
	
	@Before
	public void setUp()
	{
		this.rodriguez=new Bombita();
		this.unTimer = new Timer();
		this.arma=new Molotov();
		this.resultadotiempo=0.99;//constante para comparar el tiempo de una molotov una vez que fue mejorada por el metodo usar.
	}
	
	@Test
	public void testUsar(){
		
		unTimer.usar(this.rodriguez);
		Armamento armamentoprueba = this.rodriguez.armamentoActual();
		assertTrue(armamentoprueba.obtenerTime() == resultadotiempo);
		
	}
	
	@Test
	public void testUsarSinArmamento(){
		
		Armamento armamentoprueba=null;
		this.rodriguez.cambiarArmamento(armamentoprueba);
		try{
			this.unTimer.usar(this.rodriguez);
		}
		catch (ArmamentoNoInicializadoError e){
			
			assert(true);
		}
	
	}

	@Test
	public void testReducirTiempo(){
		
		float tiempo=1;
		this.arma.cambiarTime(tiempo);
		this.unTimer.reducirTiempo(this.arma);
		assertTrue(this.arma.obtenerTime()==this.resultadotiempo);
		
	}
	
	@Test
	public void testReducirArmamentoConTiempoCero(){
		
		float tiempo=0;
		this.arma.cambiarTime(0);
		try{
			this.unTimer.reducirTiempo(this.arma);
		}
		catch (TiempoInvalidoError e){
			
			assert(true);
		}
		
	}
}
