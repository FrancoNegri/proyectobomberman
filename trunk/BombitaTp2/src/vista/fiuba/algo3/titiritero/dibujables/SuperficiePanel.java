package vista.fiuba.algo3.titiritero.dibujables;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import vista.fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class SuperficiePanel extends JPanel implements SuperficieDeDibujo {

	private static final long serialVersionUID = 1L;
	private Image imagen;
	private Image fondo;

	
	// es llamado internamente por el metodo repaint() de la clase Frame
	public void update(Graphics g) {
		paint(g);
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
	
	public void paint(Graphics g) {
		System.out.println("repintando");
		g.drawImage(this.imagen, 0, 0, null);
		this.limpiar();
	}
	
	public void actualizar() {
		this.repaint();
	}

	private void limpiar() {
		if(this.imagen == null)
			this.imagen = this.createImage(getSize().width, getSize().height);
		Graphics superficieParaDibujar =  this.imagen.getGraphics();
		//superficieParaDibujar.drawImage(this.fondo, 0, 0, 20, 20, null);// Dibujar la imagen de fondo
		superficieParaDibujar.setColor(this.getBackground());
		superficieParaDibujar.fillRect(0, 0, this.getSize().width, this.getSize().height);
	}

	public Graphics getBuffer(){
		return this.imagen.getGraphics();
	}
}