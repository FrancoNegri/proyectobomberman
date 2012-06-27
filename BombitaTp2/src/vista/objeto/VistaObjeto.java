package vista.objeto;

import java.awt.Color;
import java.io.IOException;
import vista.fiuba.algo3.titiritero.dibujables.Cuadrado;
import vista.fiuba.algo3.titiritero.dibujables.Imagen;
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
		try {
			objetoDibujable = new VistaMolotov(molotov);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void InteractuarConProyectil(ObjetoPosicionable proyectil){
		try {
			objetoDibujable = new VistaProyectil(proyectil);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	private class VistaMolotov extends Imagen {
		public  VistaMolotov(ObjetoPosicionable modelo) throws IOException{
			super(VistaBloqueAcero.class.getResource("/vista/Imagenes/BombaMolotov.png"), modelo);
		}
	}
	
	
	private class VistaProyectil extends Imagen  {
		public  VistaProyectil(ObjetoPosicionable modelo) throws IOException{
			super(VistaBloqueAcero.class.getResource("/vista/Imagenes/Proyectil.png"), modelo);
		}
	}
	
	private class VistaToleTole extends Imagen {
		public  VistaToleTole(ObjetoPosicionable modelo) throws IOException {
			super(VistaBloqueAcero.class.getResource("/vista/Imagenes/BombaToleTole.png"), modelo);
		}
	}
	
	private class VistaBombita extends Imagen {
		public  VistaBombita(ObjetoPosicionable modelo) throws IOException {
			super(VistaBombita.class.getResource("/vista/Imagenes/Parado.png"), modelo);
		}
	}
	
	private class VistaCesilio extends Imagen {
		public  VistaCesilio(ObjetoPosicionable modelo) throws IOException {
			super(VistaBloqueAcero.class.getResource("/vista/Imagenes/Cecilio.png"), modelo);
		}
	}
	
	private class VistaLopezAlado extends Imagen {
		public  VistaLopezAlado(ObjetoPosicionable modelo) throws IOException {
			super( VistaLopezComun.class.getResource("/vista/Imagenes/LopezAlado.png"), modelo);
		}
	}
	
	private class VistaLopezComun extends Imagen {
		public  VistaLopezComun(ObjetoPosicionable modelo) throws IOException {
			super( VistaLopezComun.class.getResource("/vista/Imagenes/LopezComun.png"), modelo);
		}
	}
	
	private class VistaHabano extends Imagen {
		public  VistaHabano(ObjetoPosicionable modelo) throws IOException {
			super(VistaBloqueAcero.class.getResource("/vista/Imagenes/Habano.png"), modelo);
		}
	}
	
	private class VistaTimer extends Imagen {
		public  VistaTimer(ObjetoPosicionable modelo) throws IOException {
			super(VistaBloqueAcero.class.getResource("/vista/Imagenes/Timer.png"), modelo);
		}
	}
	
	private class VistaBloqueAcero extends Imagen {
		public  VistaBloqueAcero(ObjetoPosicionable modelo) throws IOException {
			super(VistaBloqueAcero.class.getResource("/vista/Imagenes/BloqueAcero1.png"), modelo);
		}
	}
	
	private class VistaBloqueCemento extends Imagen {
		public  VistaBloqueCemento(ObjetoPosicionable modelo) throws IOException {
			super(VistaBloqueCemento.class.getResource("/vista/Imagenes/BloqueCemento1.png"), modelo);
		}
	}

	private class VistaBloqueLadrillo extends Imagen {
		public  VistaBloqueLadrillo(ObjetoPosicionable modelo) throws IOException {
			super(VistaBloqueLadrillo.class.getResource("/vista/Imagenes/BloqueLadrillo1.png"), modelo);
		}
	}
	
	private class VistaFuegoDeExplocion extends Imagen {
		public  VistaFuegoDeExplocion(ObjetoPosicionable modelo) throws IOException {
			super(VistaBloqueLadrillo.class.getResource("/vista/Imagenes/Fuego.png"), modelo);
		}
	}
	
}
