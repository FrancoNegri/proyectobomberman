package control.Teclado;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.personaje.Bombita;

public class Teclado extends KeyAdapter implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField keycode = new JTextField("");
	private Bombita rodriguez;

	public Teclado(Bombita personaje){
		super();
		this.rodriguez = personaje;
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
			{	rodriguez.cambiarActitud();
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
	
	public boolean isFocusable(){
		
		return true;
	}
	
}
