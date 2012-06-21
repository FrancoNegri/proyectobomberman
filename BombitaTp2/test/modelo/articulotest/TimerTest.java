package modelo.articulotest;

import modelo.ArmamentoFactory.ArmamentoFactory;
import modelo.articulo.*;
import modelo.coordenadas.Coordenada;
import modelo.errores.ArmamentoNoInicializadoError;
import modelo.errores.TiempoInvalidoError;
import modelo.personaje.*;
import static org.junit.Assert.*;

import org.junit.*;

import static org.mockito.Mockito.*;
public class TimerTest {
	
	private Bombita rodriguez;
	private ArmamentoFactory armaFactory;
	private Timer unTimer;
	
	
	@Before
	public void setUp()
	{
		this.rodriguez= mock (Bombita.class);
		Coordenada coordenada = mock (Coordenada.class);
		this.unTimer = new Timer(coordenada);
		this.armaFactory=  mock(ArmamentoFactory.class);
		when(rodriguez.tirarArmamento()).thenReturn(this.armaFactory);
		when(armaFactory.obtenerTime()).thenReturn(3);
	}
	
	@Test
	public void testUsar(){
		unTimer.usar(this.rodriguez);
		verify(armaFactory).cambiarTime(anyInt());
	}
	@Test
	public void testErrorAlUsar(){
		rodriguez = mock(Bombita.class);
		when(rodriguez.tirarArmamento()).thenReturn(null);
		try{
			unTimer.usar(this.rodriguez);
		}catch (ArmamentoNoInicializadoError e){
			assert(true);
			return;
		}
		assert(false);
	}
	
	@Test
	public void testUsarSinArmamento(){
		
		ArmamentoFactory armamentoprueba=null;
		this.rodriguez.cambiarArmamento(armamentoprueba);
		try{
			this.unTimer.usar(this.rodriguez);
		}
		catch (ArmamentoNoInicializadoError e){
			assert(true);
			return;
		}
		assert(false);
	}

	@Test
	public void testReducirTiempo(){
		this.unTimer.reducirTiempo(this.armaFactory);
		verify(armaFactory).cambiarTime(anyInt());
	}
	
	@Test
	public void testReducirArmamentoConTiempoCero(){
		when (armaFactory.obtenerTime()).thenReturn(0);
		try{
			this.unTimer.reducirTiempo(this.armaFactory);
		}
		catch (TiempoInvalidoError e){
			
			assertTrue(true);
			return;
		}
		assertTrue(false);
	}
	

}
