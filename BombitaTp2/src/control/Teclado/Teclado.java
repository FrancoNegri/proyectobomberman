package control.Teclado;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Teclado extends JFrame implements KeyListener{

	JTextField keycode = new JTextField("");

	public Teclado(){
		addKeyListener(this);
		add(keycode);
		setSize(300, 300);
		setVisible(true);
		setTitle("Key Listener Practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	

	public void keyPressed(KeyEvent e) {
		if(KeyEvent.VK_ESCAPE == e.getKeyCode() ){
			System.exit(0);	
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
