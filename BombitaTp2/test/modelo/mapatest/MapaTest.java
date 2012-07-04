package modelo.mapatest;

import java.util.LinkedList;
import modelo.mapa.*;
import modelo.obstaculos.BloqueCemento;
import modelo.obstaculos.BloqueLadrillo;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Personaje;
import modelo.personaje.Bombita;
import modelo.errores.*;
import modelo.armamento.Armamento;
import modelo.articulo.Articulo;
import modelo.casillero.*;
import modelo.coordenadas.Coordenada;
import static org.junit.Assert.*;
import modelo.salida.*;
import org.junit.*;
import static org.mockito.Mockito.*;
public class MapaTest {

	private Mapa unMapa;
	
	@SuppressWarnings("unused")
	private Casillero unCasillero;
	
	private int Tamanio;
	
	@Before
	public void setUp(){
		
		this.Tamanio = 5;
		this.unMapa = new Mapa(this.Tamanio);
		this.unCasillero = new Casillero();
		
	}
	
	@Test
	
	public void testConstructor(){
		Coordenada cord = new Coordenada(2,3);
		this.unCasillero = this.unMapa.obtenerCasillero(cord);
	}
	
	@Test
	public void testTamanio(){
		assertTrue(5 == unMapa.obtenerTamanio());
	}
	
	
	@Test
	
	public void testConstructorTamanioInvalido(){
		
		try{
		
			this.unMapa = new Mapa(-3);
		}
		catch(TamanioMatrizInvalidoError e){
			
		}
		
	}
	
@Test
	
	public void testErrorCasilleroInvalido(){
		
		
			Coordenada coord = new Coordenada(1,1);
			Obstaculo obs = mock(BloqueCemento.class);
			when(obs.obtenerCoordenadaXY()).thenReturn(coord);
			Personaje pers = mock(Personaje.class);
			when(pers.obtenerCoordenadaXY()).thenReturn(coord);
			this.unMapa = new Mapa(3);
			unMapa.agregarAlMapa(obs);
		try{
			unMapa.agregarAlMapa(pers);
		}
		catch(CasilleroOcupadoError e){
			
		}
		
	}
	
	@Test
	
	public void testObtenerCasillero(){
		Coordenada cord = new Coordenada(3,4);
		Casillero casilleroPrueba = this.unMapa.obtenerCasillero(cord);
		assertTrue(casilleroPrueba.getClass() == Casillero.class);
		
	}
	@Test
	
	public void testObtenerCasilleroTamanioFueraDeRango(){
		Coordenada cord = new Coordenada(7,2);
		try{
			this.unMapa.obtenerCasillero(cord);
		}
		catch(TamanioMatrizInvalidoError e){
		}
	}
	@Test
	public void testObtenerPersonajeDelMapa(){
		Coordenada cord = new Coordenada(3,4);
		Personaje pers = mock(Personaje.class);
		when(pers.obtenerCoordenadaXY()).thenReturn(cord);
		unMapa.agregarAlMapa(pers);
		LinkedList<Personaje> lista = unMapa.obtenerCasillero(cord).obtenerPersonajes();
		assertTrue(lista.contains(pers));
	}
	@Test
	public void testObtenerObstaculoDelMapa(){
		Coordenada coord = new Coordenada(3,4);
		BloqueLadrillo bloque = mock(BloqueLadrillo.class);
		when(bloque.obtenerCoordenadaXY()).thenReturn(coord);
		unMapa.agregarAlMapa(bloque);
		assertTrue(unMapa.obtenerCasillero(coord).obtenerObstaculo() == bloque);
	}
	@Test
	public void testObtenerArmamentoDelMapa(){
		Coordenada coord = new Coordenada(3,4);
		Armamento arma = mock(Armamento.class);
		when(arma.obtenerCoordenadaXY()).thenReturn(coord);
		unMapa.agregarAlMapa(arma);
		assertTrue(unMapa.obtenerCasillero(coord).obtenerArmamento() == arma);
	}
	@Test
	public void testObtenerArticuloDelMapa(){
		Coordenada coord = new Coordenada(3,4);
		Articulo articulo = mock(Articulo.class);
		when(articulo.obtenerCoordenadaXY()).thenReturn(coord);
		unMapa.agregarAlMapa(articulo);
		assertTrue(unMapa.obtenerCasillero(coord).obtenerArticulo() == articulo);
	}
	
	@Test
	public void testTerminoNivel(){
		Coordenada cord = new Coordenada(3,4);
		Bombita pers = mock(Bombita.class);
		when(pers.obtenerCoordenadaXY()).thenReturn(cord);
		this.unMapa.agregarAlMapa(pers);
		Salida unaSalida = new Salida(cord);
		this.unMapa.agregarAlMapa(unaSalida);
		assertTrue(this.unMapa.terminoNivel());
	}
	
	@Test
	public void testTerminoNivelsinBombitaenSalida(){
		Coordenada cord = new Coordenada(3,4);
		Coordenada cordsalida = new Coordenada(2,2);
		Personaje pers = mock(Personaje.class);
		when(pers.obtenerCoordenadaXY()).thenReturn(cord);
		this.unMapa.agregarAlMapa(pers);
		Salida unaSalida = new Salida(cordsalida);
		this.unMapa.agregarAlMapa(unaSalida);
		assertFalse(this.unMapa.terminoNivel());
	}
	
	@Test
	public void testTerminoNivelConBombitaenSalidayPersonajes(){
		Coordenada cord = new Coordenada(3,4);
		Coordenada cordotropers = new Coordenada(1,1);
		Coordenada cordsalida = new Coordenada(2,2);
		Personaje pers = mock(Personaje.class);
		Personaje otropers = mock (Personaje.class);
		Bombita rodriguez = mock(Bombita.class);
		when(pers.obtenerCoordenadaXY()).thenReturn(cord);
		when(otropers.obtenerCoordenadaXY()).thenReturn(cordotropers);
		when(rodriguez.obtenerCoordenadaXY()).thenReturn(cordsalida);
		this.unMapa.agregarAlMapa(pers);
		this.unMapa.agregarAlMapa(otropers);
		this.unMapa.agregarAlMapa(rodriguez);
		Salida unaSalida = new Salida(cordsalida);
		this.unMapa.agregarAlMapa(unaSalida);
		assertFalse(this.unMapa.terminoNivel());
		
	}
	
	@Test
	public void testTerminoNivelconPersonajeEnSalida(){
		Coordenada cordsalida = new Coordenada(2,2);
		Personaje pers = mock(Personaje.class);
		when(pers.obtenerCoordenadaXY()).thenReturn(cordsalida);
		this.unMapa.agregarAlMapa(pers);
		Salida unaSalida = new Salida(cordsalida);
		this.unMapa.agregarAlMapa(unaSalida);
		assertFalse(this.unMapa.terminoNivel());
	}
}
