package main;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.mapa.Mapa;
import modelo.personaje.Bombita;

public class BarraEstado extends JPanel implements Runnable {
	
	private int velocidad;
	private int puntaje;
	private int vida;
	private boolean estaEjecutando;
	private JLabel labelInfo, labelPts, labelVida, labelVel, labelNiv, labelImg, labelPnl;
	private Thread hilo;
	
	public BarraEstado() {
		this.velocidad = 0;
		this.puntaje = 0;
		this.vida = 0;
		this.inicializarBarraEstado();
	}
	
	public void inicializarBarraEstado() {
		Font fuente = new Font(Font.SERIF,Font.BOLD,15);
		labelInfo = new JLabel("Informacion");
		labelInfo.setFont(fuente);
		labelInfo.setForeground(Color.white);
		labelInfo.setBounds(625, 15, 100, 50);
		labelPts = new JLabel("Puntos: "+ puntaje );
		labelPts.setForeground(Color.white);
		labelPts.setBounds(610, 50, 100, 50);
		labelVida = new JLabel("Vida: "+ vida );
		labelVida.setForeground(Color.white);
		labelVida.setBounds(610, 90, 100, 50);
		labelVel = new JLabel("Velocidad: "+ velocidad + " km/h");
		labelVel.setForeground(Color.white);
		labelVel.setBounds(610, 130, 120, 50);
		labelNiv = new JLabel("Nivel: 1");
		labelNiv.setForeground(Color.white);
		labelNiv.setBounds(610, 165, 100, 50);
		labelImg = new JLabel();
		labelImg.setIcon(new ImageIcon(getClass().getResource("/vista/Imagenes/BombitaRodriguez1.png")));
		labelImg.setBounds(600,380,200,200);
		labelPnl = new JLabel();
		labelPnl.setIcon(new ImageIcon(getClass().getResource("/vista/Imagenes/Panel1.png")));
		labelPnl.setBounds(600,16,130,200);
		
		add(labelInfo);
		add(labelPts);
		add(labelVida);
		add(labelVel);
		add(labelNiv);
		add(labelImg);
		add(labelPnl);
	}
	
	public void actualizarBarraEstado(Bombita rodriguez, Mapa mapa) {
		labelPts.setText("Puntos: " + mapa.obtenerPuntajeTotal());
		labelVida.setText("Vida: "+ rodriguez.obtenerVida());
		labelVel.setText("Velocidad: "+ rodriguez.getVelocidad() + " km/h");
		labelNiv.setText("Nivel: 1");
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public BarraEstado obtenerBarra() {
		return this;
	}

}
