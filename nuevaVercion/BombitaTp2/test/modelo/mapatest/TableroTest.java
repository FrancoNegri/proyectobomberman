package modelo.mapatest;

import java.util.LinkedList;

import modelo.mapa.*;
import modelo.obstaculos.BloqueLadrillo;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Bombita;
import modelo.personaje.Personaje;
import modelo.errores.*;
import modelo.armamento.Armamento;
import modelo.armamento.Molotov;
import modelo.articulo.Articulable;
import modelo.articulo.Articulo;
import modelo.articulo.Habano;
import modelo.casillero.*;
import modelo.coordenadas.Coordenada;
import static org.junit.Assert.*;
import org.junit.*;

public class TableroTest {

	private int tamanio;
	@SuppressWarnings("unused")
	private Casillero unCasillero;
	private Tablero unTablero;
	private Bombita rodriguez;
	private Coordenada coor;
	private Mapa mapa;
	private Armamento molotov;
	private Obstaculo obstaculo;
	private Articulable art;

	@Before
	public void setUp() {

		this.tamanio = 5;
		this.mapa = new Mapa(tamanio);
		this.coor = new Coordenada(2,2);
		this.unCasillero = new Casillero();
		this.unTablero = new Tablero(this.tamanio);
		this.rodriguez = new Bombita(coor,mapa);
		this.molotov = new Molotov(coor,mapa,10);
		this.obstaculo = new BloqueLadrillo(coor);
		this.art = new Habano(coor);
	}

	@Test
	public void testConstructorconTamanioInvalido() {

		try {

			this.unTablero = new Tablero(-1);
			fail("el tablero permite un tamanio negativo");
		} catch (TamanioMatrizInvalidoError e) {

		}
	}

	@Test
	public void testObtenercasillero() {
		Coordenada cord = new Coordenada(4, 2);
		Casillero casilleroprueba = this.unTablero.obtenerCasillero(cord);
		assertTrue(casilleroprueba.getClass() == Casillero.class);
	}

	@Test
	public void testObtenercasilleroTamaniofueradeRango() {

		try {
			Coordenada cord = new Coordenada(7, 1);
			this.unTablero.obtenerCasillero(cord);
			fail("acepta posiciones fuera de rango");
		} catch (TamanioMatrizInvalidoError e) {

		}
	}

	@Test
	public void testCambiarcasilleroTamaniofueradeRango() {

		try {
			Coordenada cord = new Coordenada(8, 1);
			Casillero unCasillero = new Casillero();
			this.unTablero.cambiarCasillero(cord, unCasillero);
			fail("acepta posiciones fuera de rango");
		} catch (TamanioMatrizInvalidoError e) {

		}
	}

	@Test
	public void testObtenerTamanio() {

		assertTrue(this.unTablero.obtenerTamanio() == 5);

	}

	@Test
	public void testObtenerPersonajes() {
		mapa.agregarAlMapa(rodriguez);
		LinkedList<Personaje> pers = mapa.ObtenerPersonaje(coor);
		assertTrue(pers.getFirst() == rodriguez);
	}
	
	@Test
	public void testObtenerArmamento() {
		mapa.agregarAlMapa(molotov);
		Armamento molotov = mapa.ObtenerArmamento(coor);
		assertTrue(molotov == molotov);
	}
	
	@Test
	public void testObtenerObstaculo() {
		mapa.agregarAlMapa(obstaculo);
		Obstaculo obs = mapa.ObtenerObstaculo(coor);
		assertTrue(obs == obstaculo);
	}
	
	@Test
	public void testObtenerArticulo() {
		mapa.agregarAlMapa(art);
		Articulable articulo = mapa.ObtenerArticulo(coor);
		assertTrue(articulo == art);
	}
}
