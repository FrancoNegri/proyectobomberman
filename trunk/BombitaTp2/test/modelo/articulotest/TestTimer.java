package modelo.articulotest;

import modelo.articulo.*;
import modelo.armamento.*;
import modelo.errores.ArmamentoNoInicializadoError;
import modelo.errores.TiempoInvalidoError;
import modelo.personaje.*;
import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;
public class TestTimer {
	
	private Bombita rodriguez;
	private Armamento arma;
	private double resultadotiempo;
	private Timer unTimer;
	
	
	@Before
	public void setUp()
	{
		float tiempo = 3;
		this.rodriguez= mock (Bombita.class);
		this.unTimer = new Timer();
		this.arma=  mock(Molotov.class);
		when(rodriguez.armamentoActual()).thenReturn(this.arma);
		when(arma.obtenerTime()).thenReturn(tiempo);
		this.resultadotiempo=0.99;//constante para comparar el tiempo de una molotov una vez que fue mejorada por el metodo usar.
	}
	
	@Test
	public void testUsar(){
		unTimer.usar(this.rodriguez);
		verify(arma).cambiarTime(anyInt());
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
		this.unTimer.reducirTiempo(this.arma);
		verify(arma).cambiarTime(anyInt());
	}
	
	@Test
	public void testReducirArmamentoConTiempoCero(){
		float tiempo = 0; 
		when (arma.obtenerTime()).thenReturn(tiempo);
		try{
			this.unTimer.reducirTiempo(this.arma);
		}
		catch (TiempoInvalidoError e){
			
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}
}
