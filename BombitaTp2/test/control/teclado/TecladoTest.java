package control.teclado;

import java.awt.event.KeyEvent;

import modelo.personaje.Bombita;
import static org.mockito.Mockito.*;
import org.junit.Test;

import control.Teclado.Teclado;


public class TecladoTest {
	
	
	
	@Test
	public void testPruebaTeclaAbajo(){
		Bombita bomb = mock(Bombita.class);
		Teclado miTeclado = new Teclado(bomb);
		KeyEvent e = mock(KeyEvent.class);
		when(e.getKeyCode()).thenReturn(KeyEvent.VK_DOWN);
		miTeclado.keyPressed(e);
		verify(bomb).moverseAbajo();
	}
	
	@Test
	public void testPruebaTeclaArriba(){
		Bombita bomb = mock(Bombita.class);
		Teclado miTeclado = new Teclado(bomb);
		KeyEvent e = mock(KeyEvent.class);
		when(e.getKeyCode()).thenReturn(KeyEvent.VK_UP);
		miTeclado.keyPressed(e);
		verify(bomb).moverseArriba();
	}
	
	@Test
	public void testPruebaTeclaDerecha(){
		Bombita bomb = mock(Bombita.class);
		Teclado miTeclado = new Teclado(bomb);
		KeyEvent e = mock(KeyEvent.class);
		when(e.getKeyCode()).thenReturn(KeyEvent.VK_RIGHT);
		miTeclado.keyPressed(e);
		verify(bomb).moverseDerecha();
	}
	
	@Test
	public void testPruebaTeclaIzquierda(){
		Bombita bomb = mock(Bombita.class);
		Teclado miTeclado = new Teclado(bomb);
		KeyEvent e = mock(KeyEvent.class);
		when(e.getKeyCode()).thenReturn(KeyEvent.VK_LEFT);
		miTeclado.keyPressed(e);
		verify(bomb).moverseIzquierda();
	}
	
	@Test
	public void testPruebaTeclaAtacar(){
		Bombita bomb = mock(Bombita.class);
		Teclado miTeclado = new Teclado(bomb);
		KeyEvent e = mock(KeyEvent.class);
		when(e.getKeyCode()).thenReturn(KeyEvent.VK_A);
		miTeclado.keyPressed(e);
		verify(bomb).Atacar();
	}
	
	
	
	
}
