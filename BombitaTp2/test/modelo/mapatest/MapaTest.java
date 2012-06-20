package modelo.mapatest;

import java.util.LinkedList;
import modelo.mapa.*;
import modelo.obstaculos.BloqueLadrillo;
import modelo.personaje.Personaje;
import modelo.errores.*;
import modelo.armamento.Armamento;
import modelo.articulo.Articulo;
import modelo.casillero.*;
import modelo.coordenadas.Coordenada;
import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;
public class MapaTest {

	private Mapa unMapa;
	
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
	
	public void testConstructorTamanioInvalido(){
		
		try{
		
			this.unMapa = new Mapa(-3);
		}
		catch(TamanioMatrizInvalidoError e){
			
		}
		
	}
	
	
	
	/*Ya no es nesesario, nadie puede agregar casilleros.
	 * 
	 * @Test
	 * public void testagregarCasillero(){
		Coordenada cord = new Coordenada(3,1);
		this.unCasillero.cambiarIdentificador("casilleroPrueba");
		this.unMapa.agregarCasillero(cord, unCasillero);
		Casillero CasilleroPrueba = this.unMapa.obtenerCasillero(cord);
		assertTrue(CasilleroPrueba.obtenerIdentificador() == "casilleroPrueba");	
	}*/
	
	/*
	 * no es nesesario nadie puede agregar casilleros
	 * 
	 * @Test
	 * 
	public void testagregarCasilleroTamanioFueraDeRango(){
		Coordenada cord = new Coordenada(3,9);
		try{
			
			this.unMapa.agregarCasillero(cord, this.unCasillero);
		}
		catch(TamanioMatrizInvalidoError e){
			
		}
		
		
	}*/
	
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
}
