package modelo.articulotest;

import modelo.articulo.*;
import modelo.armamento.*;
import modelo.errores.ArmamentoNoInicializadoError;
import modelo.errores.TiempoInvalidoError;
import modelo.personaje.*;
import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.*;

public class TestTimer {
	
	private Bombita rodriguez;
	private Armamento arma;
	private int resultadotiempo;
	private Timer unTimer;
	
	
	@Before
	public void setUp()
	{
		this.rodriguez=new Bombita();
		this.arma=new Armamento();
		this.resultadotiempo=0.995;//constante para comparar el tiempo de una molotov una vez que fue mejorada por el metodo usar.
	}
	
	@Test
	public void testUsar(){
		
		this.unTimer = new Timer();
		unTimer.usar(this.rodriguez);
		Armamento armamentoprueba = this.rodriguez.armamentoActual();
		assertTrue(armamentoprueba.obtenerTime()==resultadotiempo);
		
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
