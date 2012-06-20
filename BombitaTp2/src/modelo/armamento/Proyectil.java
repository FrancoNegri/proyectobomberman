package modelo.armamento;

import modelo.Translacion.Translacion;
import modelo.coordenadas.Coordenada;
import modelo.constantesjuego.ConstantesJuego;
import modelo.mapa.Mapa;

public class Proyectil extends Armamento {
	
	private Translacion transladador;
	private int distancia = ConstantesJuego.distancia_proyectil;
	
	public Proyectil(Coordenada coordenada,Mapa mapa,Translacion trans) {
		super(coordenada,mapa);
		this.danio = ConstantesJuego.danio_proyectil;
		this.time = 0;
		transladador = trans;
	}
	@Override
	public void actualizar(){
		if(distancia<0){
			transladador.accion(coordenada);
		}else{
			this.explotar(coordenada, mapaAutilizar);
		}
	}
}
