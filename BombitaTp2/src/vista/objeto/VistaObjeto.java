package vista.objeto;

import java.awt.Color;
import java.io.IOException;

import modelo.fuegoDeExplocion.FuegoDeExplocion;
import vista.fiuba.algo3.titiritero.dibujables.Circulo;
import vista.fiuba.algo3.titiritero.dibujables.Cuadrado;
import vista.fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import vista.fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import vista.fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class VistaObjeto implements ObjetoDibujable {

	// Esta clase Implementa un doble dispatch y command para resolver la vista
	
	ObjetoDibujable objetoDibujable;
	
	public VistaObjeto(ObjetoVisible objeto){
		objeto.DeterminarObjeto(this);
	}

	public void dibujar(SuperficieDeDibujo superficieDeDibujo) {
		objetoDibujable.dibujar(superficieDeDibujo);
	}
	
	public void InteractuarConMolotov(ObjetoPosicionable molotov) {
		objetoDibujable = new VistaMolotov(molotov);
	}

	public void InteractuarConProyectil(ObjetoPosicionable proyectil){
		objetoDibujable = new VistaProyectil(proyectil);
	}

	public void InteractuarConBombita(ObjetoPosicionable bombita) {
		try {
			objetoDibujable = new VistaBombita(bombita);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void InteractuarConToleTole(ObjetoPosicionable toleTole) {
		try {
			objetoDibujable = new VistaToleTole(toleTole);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void interactuarConCecilio(ObjetoPosicionable cecilio) {
		try {
			objetoDibujable = new VistaCesilio(cecilio);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void InteractuarConLopezAlado(ObjetoPosicionable lopezAlado) {
		try {
			objetoDibujable = new VistaLopezAlado(lopezAlado);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void InteractuarConLopezComun(ObjetoPosicionable lopezComun) {
		try {
			objetoDibujable = new VistaLopezComun(lopezComun);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void InteractuarConHabano(ObjetoPosicionable habano) {
		try {
			objetoDibujable = new VistaHabano(habano);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void InteractuarTimer(ObjetoPosicionable timer) {
		try {
			objetoDibujable = new VistaTimer(timer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void InteractuarConBloqueAcero(ObjetoPosicionable bloqueAcero) {
		try {
			objetoDibujable = new VistaBloqueAcero(bloqueAcero);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void InteractuarConBloqueCemento(ObjetoPosicionable bloqueCemento) {
		try {
			objetoDibujable = new VistaBloqueCemento(bloqueCemento);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void InteractuarConBloqueLadrillo(ObjetoPosicionable bloqueLadrillo) {
		try {
			objetoDibujable = new VistaBloqueLadrillo(bloqueLadrillo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void InteractuarConFuegoDeExplocion(ObjetoPosicionable objeto) {
		try {
			objetoDibujable = new VistaFuegoDeExplocion(objeto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private class VistaMolotov extends Circulo {
		public  VistaMolotov(ObjetoPosicionable modelo){
			super(10, modelo);
			this.setColor(Color.blue);
		}
	}
	
	
	private class VistaProyectil extends Circulo {
		public  VistaProyectil(ObjetoPosicionable modelo){
			super(10, modelo);
			this.setColor(Color.PINK);
		}
	}
	
	private class VistaToleTole extends Circulo {
		public  VistaToleTole(ObjetoPosicionable modelo) throws IOException {
			super(10, modelo);
			this.setColor(Color.DARK_GRAY);
		}
	}
	
	private class VistaBombita extends Cuadrado {
		public  VistaBombita(ObjetoPosicionable modelo) throws IOException {
			super(10,10, modelo);
			this.setColor(Color.DARK_GRAY);
		}
	}
	
	private class VistaCesilio extends Cuadrado {
		public  VistaCesilio(ObjetoPosicionable modelo) throws IOException {
			super(10,10, modelo);
			this.setColor(Color.DARK_GRAY);
		}
	}
	
	private class VistaLopezAlado extends Cuadrado {
		public  VistaLopezAlado(ObjetoPosicionable modelo) throws IOException {
			super(10,10, modelo);
			this.setColor(Color.DARK_GRAY);
		}
	}
	
	private class VistaLopezComun extends Cuadrado {
		public  VistaLopezComun(ObjetoPosicionable modelo) throws IOException {
			super(10,10, modelo);
			this.setColor(Color.BLUE);
		}
	}
	
	private class VistaHabano extends Cuadrado {
		public  VistaHabano(ObjetoPosicionable modelo) throws IOException {
			super(10,10, modelo);
			this.setColor(Color.BLUE);
		}
	}
	
	private class VistaTimer extends Cuadrado {
		public  VistaTimer(ObjetoPosicionable modelo) throws IOException {
			super(10,10, modelo);
			this.setColor(Color.BLUE);
		}
	}
	
	private class VistaBloqueAcero extends Cuadrado {
		public  VistaBloqueAcero(ObjetoPosicionable modelo) throws IOException {
			super(10,10, modelo);
			this.setColor(Color.MAGENTA);
		}
	}
	
	private class VistaBloqueCemento extends Cuadrado {
		public  VistaBloqueCemento(ObjetoPosicionable modelo) throws IOException {
			super(10,10, modelo);
			this.setColor(Color.BLUE);
		}
	}

	private class VistaBloqueLadrillo extends Cuadrado {
		public  VistaBloqueLadrillo(ObjetoPosicionable modelo) throws IOException {
			super(10,10, modelo);
			this.setColor(Color.BLUE);
		}
	}
	
	private class VistaFuegoDeExplocion extends Cuadrado {
		public  VistaFuegoDeExplocion(ObjetoPosicionable modelo) throws IOException {
			super(10,10, modelo);
			this.setColor(Color.ORANGE);
		}
	}
}
