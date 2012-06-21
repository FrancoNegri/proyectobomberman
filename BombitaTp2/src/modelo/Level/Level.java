package modelo.Level;

import java.util.Iterator;
import java.util.LinkedList;

import modelo.articulo.Articulo;
import modelo.articulo.Habano;
import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.obstaculos.BloqueAcero;
import modelo.obstaculos.BloqueLadrillo;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Personaje;
import modelo.personaje.enemigos.LopezAlado;
import modelo.personaje.enemigos.LopezComun;


//Crea un nivel y lo deja listo para arrancar a jugar.
public class Level implements Runnable
{
	private Mapa mapa = new Mapa(10);
	private LinkedList <Personaje> personajes = new LinkedList<Personaje>();
	public void Crear(){
		
		int j = 0;
		for(j=1; j<10;  j++){
			Coordenada coord = new Coordenada(j,j);
			Obstaculo obst = new BloqueLadrillo(coord);
			mapa.agregarAlMapa(obst);
		}
		
		for(j=4; j<10;  j++){
			Coordenada coord = new Coordenada(j,3);
			Obstaculo obst = new BloqueAcero(coord);
			mapa.agregarAlMapa(obst);
		}
		
		for(j=1; j<3;  j++){
			Coordenada coord = new Coordenada(j*2,j+3);
			Personaje pers = new LopezAlado(coord);
			pers.setMapa(mapa);
			personajes.add(pers);
		}
		
		for(j=5; j<8;  j++){
			Coordenada coord = new Coordenada(j-3,j-1);
			Personaje pers = new LopezComun(coord);
			pers.setMapa(mapa);
			personajes.add(pers);
		}
		Coordenada coord = new Coordenada(4,6);
		Articulo articulo = new Habano(coord);
		mapa.agregarAlMapa(articulo);
	
		//Falta agregar la salida del juego hacia el proximo nivel
	}

	public void run() {
		System.out.println("Prueva Integracion");
		while(personajes.size() > 2){
		Iterator<Personaje> it = personajes.iterator();
		while(it.hasNext()){
			Personaje pers = it.next();
			pers.actualizar();
			if(pers.estaMuerto()){
				it.remove();
			}
			System.out.println("Puntaje :" + mapa.obtenerPuntajeTotal());
		}
		mapa.actualizarMapa();
		}
	}
}
