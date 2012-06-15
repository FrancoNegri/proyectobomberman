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
	public void testDondeSeAgreganLosDiferentesObjetos(){
		Personaje pers = mock(Personaje.class);
		BloqueAcero miBloque = mock(BloqueAcero.class);
		Armamento unArmamento = mock(Armamento.class);
		Articulable unArticulo = mock(Articulable.class);
		Casillero MiCas = new Casillero();
		MiCas.agregar(pers);
		MiCas.agregar(miBloque);
		MiCas.agregar(unArmamento);
		MiCas.agregar(unArticulo);
	}
	
	
}
