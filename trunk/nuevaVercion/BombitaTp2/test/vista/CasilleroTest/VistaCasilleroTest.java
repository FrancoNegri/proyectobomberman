package vista.CasilleroTest;

import static org.mockito.Mockito.*;
import java.awt.Graphics;
import java.util.LinkedList;

import modelo.Translacion.Translacion;
import modelo.Translacion.TranslacionDerecha;
import modelo.armamento.Armamento;
import modelo.armamento.Molotov;
import modelo.armamento.Proyectil;
import modelo.armamento.ToleTole;
import modelo.articulo.Articulable;
import modelo.articulo.Articulo;
import modelo.articulo.Habano;
import modelo.articulo.Timer;
import modelo.casillero.Casillero;
import modelo.coordenadas.Coordenada;
import modelo.fuegoDeExplocion.FuegoDeExplocion;
import modelo.mapa.Mapa;
import modelo.obstaculos.BloqueAcero;
import modelo.obstaculos.BloqueCemento;
import modelo.obstaculos.BloqueLadrillo;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Bombita;
import modelo.personaje.Personaje;
import modelo.personaje.enemigos.Cecilio;
import modelo.personaje.enemigos.LopezAlado;
import modelo.personaje.enemigos.LopezComun;
import modelo.salida.Salida;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import vista.Casillero.VistaCasillero;
import vista.fiuba.algo3.titiritero.dibujables.SuperficiePanel;

public class VistaCasilleroTest {
	Graphics graphics = Mockito.mock(Graphics.class);
	Mapa mapa = new Mapa(10);
	Translacion trans = new TranslacionDerecha();
	SuperficiePanel unaSuperficie = Mockito.mock(SuperficiePanel.class);
	Casillero casillero = mock(Casillero.class);
	Armamento arma = new ToleTole(new Coordenada(1,1),mock(Mapa.class),4);
	Personaje pers = new Cecilio(new Coordenada(1,1),mock(Mapa.class));
	BloqueAcero bloque = new BloqueAcero(new Coordenada(1,1));
	Articulo articulo = new Habano(new Coordenada(1,1));
	Articulo timer = new Timer(new Coordenada(2,2));
	Armamento tole = new ToleTole(new Coordenada(2,2),mapa,3);
	Armamento proyectil = new Proyectil(new Coordenada(2,2),mapa,trans);
	Armamento molotov = new Molotov(new Coordenada(2,2),mapa,4);
	FuegoDeExplocion fuego = new FuegoDeExplocion(new Coordenada(2,2), 4);
	Obstaculo bloqueC = new BloqueCemento(new Coordenada(2,2));
	Obstaculo bloqueL = new BloqueLadrillo(new Coordenada(2,2));
	Bombita rodriguez = new Bombita(new Coordenada(2,2),mapa);
	LopezAlado alado = new LopezAlado(new Coordenada(2,2),mapa);
	LopezComun comun = new LopezComun(new Coordenada(2,2),mapa);
	Salida salida = new Salida(new Coordenada(2,2));

	@Before
	public void SetUp(){
		Mockito.when(unaSuperficie.getBuffer()).thenReturn(graphics);
		
		arma = spy(arma);
		pers = spy(pers);
		bloque = spy(bloque);
		articulo = spy(articulo);
		timer = spy(timer);
		tole = spy(tole);
		proyectil = spy(proyectil);
		molotov = spy(molotov);
		fuego = spy(fuego);
		bloqueC = spy(bloqueC);
		bloqueL = spy(bloqueL);
		rodriguez = spy(rodriguez);	
		alado = spy(alado);
		comun = spy(comun);
		salida = spy(salida);
	}
	
	@Test
	public void testVistaMapaDibujarConHabano(){
		LinkedList<Personaje> personajes = new LinkedList<Personaje>();
		personajes.add(pers);
		when(casillero.obtenerPersonajes()).thenReturn(personajes);
		when(casillero.obtenerArmamento()).thenReturn(arma);
		when(casillero.obtenerObstaculo()).thenReturn(bloque);
		when(casillero.obtenerArticulo()).thenReturn(articulo);
		VistaCasillero vistaDelCasillero = new VistaCasillero(casillero);
		vistaDelCasillero.dibujar(unaSuperficie);
		verify(arma).getX();
		verify(arma).getY();
		verify(pers).getX();
		verify(pers).getY();
		verify(bloque).getX();
		verify(bloque).getY();
		verify(articulo).getX();
		verify(articulo).getY();
	}
	
	@Test
	public void testVistaMapaDibujarConTimer(){
		LinkedList<Personaje> personajes = new LinkedList<Personaje>();
		personajes.add(pers);
		when(casillero.obtenerPersonajes()).thenReturn(personajes);
		when(casillero.obtenerArmamento()).thenReturn(arma);
		when(casillero.obtenerObstaculo()).thenReturn(bloque);
		when(casillero.obtenerArticulo()).thenReturn(timer);
		VistaCasillero vistaDelCasillero = new VistaCasillero(casillero);
		vistaDelCasillero.dibujar(unaSuperficie);
		verify(arma).getX();
		verify(arma).getY();
		verify(pers).getX();
		verify(pers).getY();
		verify(bloque).getX();
		verify(bloque).getY();
		verify(timer).getX();
		verify(timer).getY();
	}
	
	@Test
	public void testVistaMapaDibujarConToleTole(){
		LinkedList<Personaje> personajes = new LinkedList<Personaje>();
		personajes.add(pers);
		when(casillero.obtenerPersonajes()).thenReturn(personajes);
		when(casillero.obtenerArmamento()).thenReturn(tole);
		when(casillero.obtenerObstaculo()).thenReturn(bloque);
		when(casillero.obtenerArticulo()).thenReturn(timer);
		VistaCasillero vistaDelCasillero = new VistaCasillero(casillero);
		vistaDelCasillero.dibujar(unaSuperficie);
		verify(tole).getX();
		verify(tole).getY();
		verify(pers).getX();
		verify(pers).getY();
		verify(bloque).getX();
		verify(bloque).getY();
		verify(timer).getX();
		verify(timer).getY();
	}
	
	@Test
	public void testVistaMapaDibujarConProyectil(){
		LinkedList<Personaje> personajes = new LinkedList<Personaje>();
		personajes.add(pers);
		when(casillero.obtenerPersonajes()).thenReturn(personajes);
		when(casillero.obtenerArmamento()).thenReturn(proyectil);
		when(casillero.obtenerObstaculo()).thenReturn(bloque);
		when(casillero.obtenerArticulo()).thenReturn(timer);
		VistaCasillero vistaDelCasillero = new VistaCasillero(casillero);
		vistaDelCasillero.dibujar(unaSuperficie);
		verify(proyectil).getX();
		verify(proyectil).getY();
		verify(pers).getX();
		verify(pers).getY();
		verify(bloque).getX();
		verify(bloque).getY();
		verify(timer).getX();
		verify(timer).getY();
	}
	
	@Test
	public void testVistaMapaDibujarConMolotov(){
		LinkedList<Personaje> personajes = new LinkedList<Personaje>();
		personajes.add(pers);
		when(casillero.obtenerPersonajes()).thenReturn(personajes);
		when(casillero.obtenerArmamento()).thenReturn(molotov);
		when(casillero.obtenerObstaculo()).thenReturn(bloque);
		when(casillero.obtenerArticulo()).thenReturn(timer);
		VistaCasillero vistaDelCasillero = new VistaCasillero(casillero);
		vistaDelCasillero.dibujar(unaSuperficie);
		verify(molotov).getX();
		verify(molotov).getY();
		verify(pers).getX();
		verify(pers).getY();
		verify(bloque).getX();
		verify(bloque).getY();
		verify(timer).getX();
		verify(timer).getY();
	}
	
	@Test
	public void testVistaMapaDibujarConFuego(){
		LinkedList<Personaje> personajes = new LinkedList<Personaje>();
		personajes.add(pers);
		when(casillero.obtenerPersonajes()).thenReturn(personajes);
		when(casillero.obtenerArmamento()).thenReturn(molotov);
		when(casillero.obtenerObstaculo()).thenReturn(bloque);
		when(casillero.obtenerArticulo()).thenReturn(timer);
		when(casillero.obtenerFuegoDeExplocion()).thenReturn(fuego);
		VistaCasillero vistaDelCasillero = new VistaCasillero(casillero);
		vistaDelCasillero.dibujar(unaSuperficie);
		verify(molotov).getX();
		verify(molotov).getY();
		verify(pers).getX();
		verify(pers).getY();
		verify(bloque).getX();
		verify(bloque).getY();
		verify(timer).getX();
		verify(timer).getY();
		verify(fuego).getX();
		verify(fuego).getY();
	}
	
	@Test
	public void testVistaMapaDibujarConBloqueCemento(){
		LinkedList<Personaje> personajes = new LinkedList<Personaje>();
		personajes.add(pers);
		when(casillero.obtenerPersonajes()).thenReturn(personajes);
		when(casillero.obtenerArmamento()).thenReturn(molotov);
		when(casillero.obtenerObstaculo()).thenReturn(bloqueC);
		when(casillero.obtenerArticulo()).thenReturn(timer);
		VistaCasillero vistaDelCasillero = new VistaCasillero(casillero);
		vistaDelCasillero.dibujar(unaSuperficie);
		verify(molotov).getX();
		verify(molotov).getY();
		verify(pers).getX();
		verify(pers).getY();
		verify(bloqueC).getX();
		verify(bloqueC).getY();
		verify(timer).getX();
		verify(timer).getY();
	}
	
	@Test
	public void testVistaMapaDibujarConBloqueLadrillo(){
		LinkedList<Personaje> personajes = new LinkedList<Personaje>();
		personajes.add(pers);
		when(casillero.obtenerPersonajes()).thenReturn(personajes);
		when(casillero.obtenerArmamento()).thenReturn(molotov);
		when(casillero.obtenerObstaculo()).thenReturn(bloqueL);
		when(casillero.obtenerArticulo()).thenReturn(timer);
		VistaCasillero vistaDelCasillero = new VistaCasillero(casillero);
		vistaDelCasillero.dibujar(unaSuperficie);
		verify(molotov).getX();
		verify(molotov).getY();
		verify(pers).getX();
		verify(pers).getY();
		verify(bloqueL).getX();
		verify(bloqueL).getY();
		verify(timer).getX();
		verify(timer).getY();
	}
	
	@Test
	public void testVistaMapaDibujarConBombita(){
		LinkedList<Personaje> personajes = new LinkedList<Personaje>();
		personajes.add(rodriguez);
		when(casillero.obtenerPersonajes()).thenReturn(personajes);
		when(casillero.obtenerArmamento()).thenReturn(molotov);
		when(casillero.obtenerObstaculo()).thenReturn(bloqueL);
		when(casillero.obtenerArticulo()).thenReturn(timer);
		VistaCasillero vistaDelCasillero = new VistaCasillero(casillero);
		vistaDelCasillero.dibujar(unaSuperficie);
		verify(molotov).getX();
		verify(molotov).getY();
		verify(rodriguez).getX();
		verify(rodriguez).getY();
		verify(bloqueL).getX();
		verify(bloqueL).getY();
		verify(timer).getX();
		verify(timer).getY();
	}
	
	@Test
	public void testVistaMapaDibujarConAlado(){
		LinkedList<Personaje> personajes = new LinkedList<Personaje>();
		personajes.add(alado);
		when(casillero.obtenerPersonajes()).thenReturn(personajes);
		when(casillero.obtenerArmamento()).thenReturn(molotov);
		when(casillero.obtenerObstaculo()).thenReturn(bloqueL);
		when(casillero.obtenerArticulo()).thenReturn(timer);
		VistaCasillero vistaDelCasillero = new VistaCasillero(casillero);
		vistaDelCasillero.dibujar(unaSuperficie);
		verify(molotov).getX();
		verify(molotov).getY();
		verify(alado).getX();
		verify(alado).getY();
		verify(bloqueL).getX();
		verify(bloqueL).getY();
		verify(timer).getX();
		verify(timer).getY();
	}
	
	@Test
	public void testVistaMapaDibujarConComun(){
		LinkedList<Personaje> personajes = new LinkedList<Personaje>();
		personajes.add(comun);
		when(casillero.obtenerPersonajes()).thenReturn(personajes);
		when(casillero.obtenerArmamento()).thenReturn(molotov);
		when(casillero.obtenerObstaculo()).thenReturn(bloqueL);
		when(casillero.obtenerArticulo()).thenReturn(timer);
		VistaCasillero vistaDelCasillero = new VistaCasillero(casillero);
		vistaDelCasillero.dibujar(unaSuperficie);
		verify(molotov).getX();
		verify(molotov).getY();
		verify(comun).getX();
		verify(comun).getY();
		verify(bloqueL).getX();
		verify(bloqueL).getY();
		verify(timer).getX();
		verify(timer).getY();
	}
	
	@Test
	public void testVistaMapaDibujarConSalida(){
		LinkedList<Personaje> personajes = new LinkedList<Personaje>();
		personajes.add(comun);
		when(casillero.obtenerSalida()).thenReturn(salida);
		salida.vivir();
		when(casillero.obtenerPersonajes()).thenReturn(personajes);
		when(casillero.obtenerArmamento()).thenReturn(molotov);
		when(casillero.obtenerObstaculo()).thenReturn(bloqueL);
		when(casillero.obtenerArticulo()).thenReturn(timer);
		VistaCasillero vistaDelCasillero = new VistaCasillero(casillero);
		vistaDelCasillero.dibujar(unaSuperficie);
		verify(molotov).getX();
		verify(molotov).getY();
		verify(comun).getX();
		verify(comun).getY();
		verify(bloqueL).getX();
		verify(bloqueL).getY();
		verify(timer).getX();
		verify(timer).getY();
		verify(salida).getX();
		verify(salida).getY();
	}
}
