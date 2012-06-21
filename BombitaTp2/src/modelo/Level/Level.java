package modelo.Level;

import java.util.Iterator;
import java.util.LinkedList;

import modelo.coordenadas.Coordenada;
import modelo.mapa.Mapa;
import modelo.obstaculos.BloqueAcero;
import modelo.obstaculos.BloqueLadrillo;
import modelo.obstaculos.Obstaculo;
import modelo.personaje.Bombita;
import modelo.personaje.Personaje;
import modelo.personaje.enemigos.Alado;
import modelo.personaje.enemigos.Comun;


//Crea un nivel y lo deja listo para arrancar a jugar.
public class Level implements Runnable
{
	Mapa mapa = new Mapa(10);
	LinkedList <Personaje> personajes = new LinkedList<Personaje>();
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
			Personaje pers = new Alado(coord);
			pers.setMapa(mapa);
			personajes.add(pers);
		}
		
		for(j=5; j<8;  j++){
			Coordenada coord = new Coordenada(j,j-3);
			Personaje pers = new Comun(coord);
			pers.setMapa(mapa);
			personajes.add(pers);
		}
	}

	public void run() {
		
		while(personajes.size() > 3){
		Iterator<Personaje> it = personajes.iterator();
		while(it.hasNext()){
			Personaje pers = it.next();
			pers.actualizar();
			if(pers.estaMuerto()){
				it.remove();
			}
		}
		mapa.actualizarMapa();
		}
	}
}
