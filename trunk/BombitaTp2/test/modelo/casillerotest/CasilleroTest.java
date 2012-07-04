package modelo.casillerotest;
import modelo.armamento.Armamento;
import modelo.armamento.Molotov;
import modelo.armamento.ToleTole;
import modelo.articulo.Articulable;
import modelo.casillero.Casillero;
import modelo.mapa.Mapa;
import modelo.obstaculos.BloqueAcero;
import modelo.obstaculos.BloqueLadrillo;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Personaje;
import modelo.personaje.Bombita;
import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;
import modelo.coordenadas.*;
import modelo.fuegoDeExplocion.FuegoDeExplocion;
import modelo.salida.*;


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
	
	@Test
	public void testSalidaOn(){
		
		Casillero cas = new Casillero();
		Coordenada coord = mock(Coordenada.class);
		Salida unasalida = new Salida(coord);
		cas.agregar(unasalida);
		assertTrue(cas.salidaON());
	}
	
	@Test
	
	public void testSalidaOff(){
		
		Casillero cas = new Casillero();
		assertFalse(cas.salidaON());
		
	}
	
	@Test
	
	public void testSalidaOffporObstaculo(){
		
		Casillero cas = new Casillero ();
		Coordenada coord = mock(Coordenada.class);
		Salida unasalida = new Salida(coord);
		BloqueAcero unObstaculo = mock(BloqueAcero.class);
		cas.agregar(unObstaculo);
		cas.agregar(unasalida);
		assertFalse(cas.salidaON());
	}
	
	@Test
	
	public void testcasilleroSinPersonajes(){
		
		Casillero cas = new Casillero();
		assertTrue(cas.casilleroSinPersonajes());
		}
	
	@Test
	
	public void testCasilleroSinPersonjesConPersonaje(){
		
		Casillero cas = new Casillero();
		Personaje personaje = mock(Personaje.class);
		cas.agregar(personaje);
		assertFalse(cas.casilleroSinPersonajes());
	}
	
	@Test
	
	public void testestaBombita(){
		Casillero cas = new Casillero();
		Bombita personaje = mock(Bombita.class);
		cas.agregar(personaje);
		assertTrue(cas.estaBombita());
	}
	
	@Test
	public void testestaBombitaSinPersonajes(){
		
		Casillero cas = new Casillero();
		assertFalse(cas.estaBombita());
	
	}
	
	@Test
	
	public void testestaBombitaConPesonajeCualquiera(){
		Casillero cas = new Casillero();
		Personaje personaje = mock(Personaje.class);
		cas.agregar(personaje);
		assertFalse(cas.estaBombita());
	}
	
	@Test
	public void testestaBombitaConVariosPersonajes(){
		Casillero cas = new Casillero();
		Bombita personaje = mock(Bombita.class);
		Personaje personajeaux = mock(Personaje.class);
		cas.agregar(personaje);
		cas.agregar(personajeaux);
		assertTrue(cas.estaBombita());
	}
	
	@Test
	
	public void testEstaSoloBombita(){
	
		Casillero cas = new Casillero();
		Bombita personaje = mock(Bombita.class);
		cas.agregar(personaje);
		assertTrue(cas.soloEstaBombita());
		
	}

	@Test
	
	public void testEstaSoloBombitaConPersonajeCualquiera(){
	
		Casillero cas = new Casillero();
		Personaje personaje = mock(Personaje.class);
		cas.agregar(personaje);
		assertFalse(cas.soloEstaBombita());
		
	}
	
	@Test
	
	public void testEstaSoloBombitaConVariosPersonajes(){
	
		Casillero cas = new Casillero();
		Bombita personaje = mock(Bombita.class);
		Personaje personajeaux = mock(Personaje.class);
		cas.agregar(personaje);
		cas.agregar(personajeaux);
		assertFalse(cas.soloEstaBombita());
		
	}
	
	@Test
	public void testObtenerFuego(){
		Casillero cas = new Casillero();
		Coordenada coordenada = new Coordenada(2,2);
		FuegoDeExplocion fuego = new FuegoDeExplocion(coordenada, 10);
		FuegoDeExplocion fueguito = cas.obtenerFuegoDeExplocion();
	}

	@Test
	public void testEliminarArticuloIgual() {
		Casillero cas = new Casillero();
		Coordenada coordenada = new Coordenada(2,2);
		Mapa mapa = new Mapa(10);
		Articulable tole = new ToleTole(coordenada,mapa,6);
		cas.eliminar(tole);
		Articulable art = cas.obtenerArticulo();
		assertTrue(art == null);
	}
	
	@Test
	public void testEliminarArmamentoIgual() {
		Casillero cas = new Casillero();
		Coordenada coordenada = new Coordenada(2,2);
		Mapa mapa = new Mapa(10);
		Armamento molotov = new Molotov(coordenada,mapa,6);
		cas.eliminar(molotov);
		Armamento art = cas.obtenerArmamento();
		assertTrue(art == null);
	}
	
	@Test
	public void testEliminarObstaculoIgual() {
		Casillero cas = new Casillero();
		Coordenada coordenada = new Coordenada(2,2);
		Obstaculo obs = new BloqueLadrillo(coordenada);
		cas.eliminar(obs);
		Obstaculo art = cas.obtenerObstaculo();
		assertTrue(art == null);
	}
	
	@Test
	public void testObtenerSalida() {
		Coordenada coordenada = new Coordenada(2,2);
		Salida salida = new Salida(coordenada);
		Casillero cas = new Casillero();
		cas.obtenerSalida();
	}
	
	@Test
	public void testVerificarCasilleroNoVacioAlAgregarleUnaSalida() {
		Coordenada coordenada = new Coordenada(2,2);
		Salida salida = new Salida(coordenada);
		Casillero cas = new Casillero();
		cas.agregar(salida);
		assertTrue(cas.casilleroEstaVacio() == false);
	}
	
	@Test
	public void testVerificarSalidaOn() {
		Coordenada coordenada = new Coordenada(2,2);
		Salida salida = new Salida(coordenada);
		Casillero cas = new Casillero();
		cas.agregar(salida);
		assertTrue(cas.salidaON() == true);
	}
	
	@Test
	public void testVerificarSalidaOnNoPosible() {
		Coordenada coordenada = new Coordenada(2,2);
		Salida salida = new Salida(coordenada);
		Obstaculo obs = new BloqueLadrillo(coordenada);
		Casillero cas = new Casillero();
		cas.agregar(obs);
		cas.agregar(salida);
		assertTrue(cas.salidaON() == false);
	}
	
}
