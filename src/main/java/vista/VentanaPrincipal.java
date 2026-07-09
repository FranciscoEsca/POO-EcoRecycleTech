package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    //COMPONENTES CINTA TRANSPORTADORA
    private JLabel lblResiduoActual;
    private JButton btnSimularEntrada;
    private JButton btnProcesar;

    //COMPONENTES DE LOS CONTENEDORES
    private JProgressBar barraPlastico;
    private JProgressBar barraVidrio;
    private JProgressBar barraPapel;
    private JProgressBar barraElectronico;

    public VentanaPrincipal() {
        //CONF BASICA VENTANA
        setTitle("EcoRectcle Tech - Planta Automatizada");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //centra la ventana en la pantalla
        setLayout(new BorderLayout(10, 10));

        //CINTA TRANSPORTADORA Y BOTONES
        JPanel panelCinta = new JPanel(new FlowLayout());
        panelCinta.setBorder(BorderFactory.createTitledBorder("Cinta Transportadora"));

        btnSimularEntrada = new JButton("Simular entradda de residuo");
        btnProcesar = new JButton("Procesar residuo");
        lblResiduoActual = new JLabel("Esperando residuo...");
        lblResiduoActual.setFont(new Font("Arial", Font.BOLD, 14));

        panelCinta.add(btnSimularEntrada);
        panelCinta.add(lblResiduoActual);
        panelCinta.add(btnProcesar);

        add(panelCinta, BorderLayout.NORTH);

        //PANEL CENTRAL DE EESTADO DE LOS CONTENEDORES (4 FILAS Y 2 COLUMNAS)
        JPanel panelContenedores = new JPanel(new GridLayout(4, 2, 10, 10));
        panelContenedores.setBorder(BorderFactory.createTitledBorder("Estado de los contenedores"));

        panelContenedores.add(new JLabel("Deposito de plastico"));
        barraPlastico = new JProgressBar(0, 100);
        barraPlastico.setStringPainted(true); //MUESTRA EL  % EN LA BARRA
        panelContenedores.add(barraPlastico);

        panelContenedores.add(new JLabel("Deposito de Vidrio"));
        barraVidrio = new JProgressBar(0, 100);
        barraVidrio.setStringPainted(true); //MUESTRA EL  % EN LA BARRA
        panelContenedores.add(barraVidrio);

        panelContenedores.add(new JLabel("Deposito de papel/carton"));
        barraPapel = new JProgressBar(0, 100);
        barraPapel.setStringPainted(true); //MUESTRA EL  % EN LA BARRA
        panelContenedores.add(barraPapel);

        panelContenedores.add(new JLabel("Deposito Electronico"));
        barraElectronico = new JProgressBar(0, 100);
        barraElectronico.setStringPainted(true); //MUESTRA EL  % EN LA BARRA
        panelContenedores.add(barraElectronico);

        add(panelContenedores, BorderLayout.CENTER);

    }
    //GETTERS
    public JButton getBtnSimularEntrada() { return btnSimularEntrada; }
    public JButton getBtnProcesar() {return btnProcesar; }
    public JLabel getLblResiduoActual() { return lblResiduoActual;}
    public JProgressBar getBarraPlastico() { return barraPlastico;}
    public JProgressBar getBarraVidrio() {return barraVidrio;}
    public JProgressBar getBarraPapel() { return barraPapel;}

    public JProgressBar getBarraElectronico() { return barraElectronico;}
}
