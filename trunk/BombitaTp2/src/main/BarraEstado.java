package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BarraEstado implements Runnable {
	
	Container cont;
	ControlJuego control;
	private JLabel labelInfo, labelPts, labelVida, labelVel, labelNiv, labelImg, labelPnl;
	
	public BarraEstado(Container cont,ControlJuego control) {
		this.cont = cont;
		this.control = control;
		this.inicializarBarraEstado();
		Thread hilo = new Thread(this);
		hilo.start();
	}
	
	public void inicializarBarraEstado() {
		Font fuente = new Font(Font.SERIF,Font.BOLD,15);
		labelInfo = new JLabel("Informacion");
		labelInfo.setFont(fuente);
		labelInfo.setForeground(Color.white);
		labelInfo.setBounds(625, 15, 100, 50);
		labelPts = new JLabel("Puntos: "+ control.mapa.obtenerPuntajeTotal() );
		labelPts.setForeground(Color.white);
		labelPts.setBounds(610, 50, 100, 50);
		labelVida = new JLabel("Vida: "+ control.getBombita().obtenerVida() );
		labelVida.setForeground(Color.white);
		labelVida.setBounds(610, 90, 100, 50);
		labelVel = new JLabel("Velocidad: "+ control.getBombita().getVelocidad() + " km/h");
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
		
		cont.add(labelInfo);
		cont.add(labelPts);
		cont.add(labelVida);
		cont.add(labelVel);
		cont.add(labelNiv);
		cont.add(labelImg);
		cont.add(labelPnl);
	}
	
	public void actualizarBarraEstado() {
		labelPts.setText("Puntos: " + (control.getMapa()).obtenerPuntajeTotal());
		labelVida.setText("Vida: "+ control.getBombita().obtenerVida());
		labelVel.setText("Velocidad: "+ (control.getBombita().getVelocidad()) + " km/h");
		labelNiv.setText("Nivel: "+control.getNivel());
	}

	public void run() {
		while(true){
			actualizarBarraEstado();
		}
	}
	
	public BarraEstado obtenerBarra() {
		return this;
	}

}
