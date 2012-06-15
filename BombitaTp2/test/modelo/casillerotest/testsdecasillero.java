package modelo.casillerotest;
import modelo.armamento.Armamento;
import modelo.articulo.Articulable;
import modelo.casillero.Casillero;
import modelo.obstaculos.BloqueAcero;
import modelo.personaje.Personaje;
import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;

public class testsdecasillero {

	@Test
	public void testDondeSeAgregaCasillero(){
		BloqueAcero miBloque = mock(BloqueAcero.class);
		Casillero miCas = new Casillero();
		miCas.agregar(miBloque);
		assertTrue(miCas.obtenerObstaculo()==miBloque);	
	}
	@Test
	public void testDondeSeAgregaUnArmamento(){
		Armamento unArmamento = mock(Armamento.class);
		Casillero miCas = new Casillero();
		miCas.agregar(unArmamento);
		assertTrue(miCas.obtenerArmamento()==unArmamento);
	}
	@Test
	public void testDondeSeAgreganPersonajes(){
		Personaje pers = mock(Personaje.class);
		Casillero miCas = new Casillero();
		miCas.agregar(pers);
		assertTrue(miCas.obtenerPersonajes().getFirst()==pers);	
	}
	@Test
	public void testDondeSeAgregaArticulable(){
		Articulable unArticulo = mock(Articulable.class);
		Casillero miCas = new Casillero();
		miCas.agregar(unArticulo);
		assertTrue(miCas.obtenerArticulo()==unArticulo);
	}
}
