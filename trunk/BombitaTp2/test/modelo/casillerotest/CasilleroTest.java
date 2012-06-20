package modelo.casillerotest;
import modelo.armamento.Armamento;
import modelo.articulo.Articulable;
import modelo.casillero.Casillero;
import modelo.obstaculos.BloqueAcero;
import modelo.personaje.Personaje;
import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;

public class CasilleroTest {

	@Test
	public void testDondeSeAgregaCasillero(){
		BloqueAcero miBloque = mock(BloqueAcero.class);
		Casillero miCas = new Casillero();
		miCas.agregar(miBloque);
		assertTrue(miCas.obtenerObstaculo()==miBloque);	
	}
	@Test
	public void testDondeSeEliminaCasillero(){
		BloqueAcero miBloque = mock(BloqueAcero.class);
		Casillero miCas = new Casillero();
		miCas.agregar(miBloque);
		miCas.eliminar(miBloque);
		assertTrue(miCas.obtenerObstaculo()==null);	
	}
	@Test
	public void testDondeSeAgregaUnArmamento(){
		Armamento unArmamento = mock(Armamento.class);
		Casillero miCas = new Casillero();
		miCas.agregar(unArmamento);
		assertTrue(miCas.obtenerArmamento()==unArmamento);
	}
	@Test
	public void testDondeSeEliminaUnArmamento(){
		Armamento unArmamento = mock(Armamento.class);
		Casillero miCas = new Casillero();
		miCas.agregar(unArmamento);
		miCas.eliminar(unArmamento);
		assertTrue(miCas.obtenerArmamento()==null);
	}
	@Test
	public void testDondeSeAgreganPersonajes(){
		Personaje pers = mock(Personaje.class);
		Casillero miCas = new Casillero();
		miCas.agregar(pers);
		assertTrue(miCas.obtenerPersonajes().getFirst()==pers);	
	}
	@Test
	public void testDondeSeEliminanPersonajes(){
		Personaje pers = mock(Personaje.class);
		Casillero miCas = new Casillero();
		miCas.agregar(pers);
		miCas.eliminar(pers);
		assertTrue(miCas.obtenerPersonajes().isEmpty());	
	}
	@Test
	public void testDondeSeAgregaArticulable(){
		Articulable unArticulo = mock(Articulable.class);
		Casillero miCas = new Casillero();
		miCas.agregar(unArticulo);
		assertTrue(miCas.obtenerArticulo()==unArticulo);
	}
	@Test
	public void testDondeSeEliminaArticulable(){
		Articulable unArticulo = mock(Articulable.class);
		Casillero miCas = new Casillero();
		miCas.agregar(unArticulo);
		miCas.eliminar(unArticulo);
		assertTrue(miCas.obtenerArticulo()==null);
	}
	@Test
	public void testDondeSeActualizaTodo(){
		Armamento unArmamento = mock(Armamento.class);
		Personaje pers = mock(Personaje.class);
		BloqueAcero miBloque = mock(BloqueAcero.class);
		when(miBloque.Destruido()).thenReturn(true);
		when(pers.estaMuerto()).thenReturn(true);
		
		Casillero casi = new Casillero();
		casi.agregar(pers);
		casi.agregar(miBloque);
		casi.agregar(unArmamento);
		casi.actualizar();
		verify(miBloque).Destruido();
	}
	@Test
	public void testQueCompruevaSiEsCaminable(){
		Casillero casi = new Casillero();
		assertTrue(casi.esCaminable()==true);
		BloqueAcero miBloque = mock(BloqueAcero.class);
		casi.agregar(miBloque);
		assertTrue(casi.esCaminable()==false);
	}
	@Test
	public void testQueCompruevaSiEsAtacable(){
		Casillero casi = new Casillero();
		assertTrue(casi.esAtacable()==false);
		BloqueAcero miBloque = mock(BloqueAcero.class);
		casi.agregar(miBloque);
		assertTrue(casi.esAtacable()==true);
		casi = new Casillero();
		Personaje pers = mock(Personaje.class);
		casi.agregar(pers);
		assertTrue(casi.esAtacable()==true);
	}
}
