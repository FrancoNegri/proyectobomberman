package modelo.armamento;

import vista.objeto.VistaObjeto;
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
	public void vivir(){
		if(distancia>0){
			coordenada = transladador.accion(coordenada);
			distancia =distancia-1;
		}else{
			muerto = true;
			this.explotar(coordenada.copiar(), mapaAutilizar);
		}
	}
	public void DeterminarObjeto(VistaObjeto vistaObjeto) {
		vistaObjeto.InteractuarConProyectil(this);
	}
}
