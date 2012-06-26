package control.Teclado;



import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.coordenadas.Coordenada;
import modelo.personaje.Bombita;

public class Teclado extends JPanel implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField keycode = new JTextField("");
	private Bombita rodriguez;

	public Teclado(Bombita personaje){
		this.rodriguez = personaje;
		/*addKeyListener(this);
		add(keycode);
		setSize(300, 300);
		setVisible(true);
		setTitle("Key Listener Practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	}
	

	public void keyPressed(KeyEvent e) {
		{
			int pressedKey = e.getKeyCode();
			switch (pressedKey) {
			case KeyEvent.VK_DOWN:
			{	rodriguez.moverseAbajo();
				System.out.println("Abajo");
				break;
			}
			case KeyEvent.VK_LEFT:
			{	rodriguez.moverseIzquierda();
				break;
			}
			case KeyEvent.VK_RIGHT:
			{	rodriguez.moverseDerecha();
				break;
			}
			case KeyEvent.VK_UP:
			{	rodriguez.moverseArriba();
				break;
			}
			case KeyEvent.VK_A:
			{	rodriguez.Atacar();
				break;
			}
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
