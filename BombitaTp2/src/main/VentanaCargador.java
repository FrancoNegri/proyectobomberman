package main;
import javax.swing.*;
import java.awt.*;


public class VentanaCargador extends JDialog {
    ImageIcon img;
    JPanel panel;
    JProgressBar progressBar;

    public VentanaCargador() {
        inicializarInterfazUsuario();
        getContentPane().add(panel);
        setUndecorated(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        new Thread() {
            public void run() {
                try {
                    int i = 0;
                    while(i < 100000){//la carga mas mentirosa
                        progressBar.setValue(i);
                        Thread.sleep(20);
                        i++;
                    }
                    //new VentanaPrincipal();
                    dispose();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
       
    }

    private void inicializarInterfazUsuario() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        progressBar = new JProgressBar();
        progressBar.setBackground(Color.RED);
        progressBar.setForeground(Color.BLACK);
        progressBar.setStringPainted(true);
        img = new ImageIcon(getClass().getResource("/vista/Imagenes/BombitaRodriguez1.png"));
        JLabel a = new JLabel(img);
        panel.add(a, BorderLayout.CENTER);
        panel.add(progressBar, BorderLayout.PAGE_END);
    }
}

