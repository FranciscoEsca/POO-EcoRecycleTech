package controlador;

import modelo.*;
import vista.VentanaPrincipal;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {
    private VentanaPrincipal vista;
    private IResiduo residuoActual; //AQUI GUARDAMOS EL RESIDUO QUE ESTA EN LA CINTA

    //DECLARAMOS LOS CONTENEDORES
    private ContenedorPlastico contPlastico;
    private ContenedorVidrio contVidrio;
    private ContenedorPapel contPapel;
    private ContenedorElectronico contElectronico;

    public Controlador(VentanaPrincipal vista, ContenedorPlastico cp, ContenedorVidrio cv, ContenedorPapel cpa, ContenedorElectronico ce){
        this.vista = vista;
        this.contPlastico = cp;
        this.contVidrio = cv;
        this.contPapel = cpa;
        this.contElectronico = ce;

        //INICIALIZAMOS LAS ACCIONES DE LOS BOTONES Y ACTUALIZAMOS LA VISTA
        iniciarEventos();
        actualizarBarras();
    }

    private void iniciarEventos() {
        //EVENTO PARA EL BOTON SIMULAR ENTRADA
        vista.getBtnSimularEntrada().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simularEntradaResiduo();
            }
        });

        //EVENTO PARA PROCESAR RESIDUO
        vista.getBtnProcesar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarResiduo();
            }
        });
    }

    private void simularEntradaResiduo() {
        residuoActual = ResiduoFactory.generarResiduoAleatorio();
        //ACTUALIZAMOS EL TEXTO EN LA INTERFAZ GRAFICA
        vista.getLblResiduoActual().setText("Residuo: " + residuoActual.getTipo() + " | Peso: "+ residuoActual.getPeso() + "kg");
    }

    private void procesarResiduo(){
        if (residuoActual == null){
            JOptionPane.showMessageDialog(vista, "No hay ningun residuo para procesar.", "Atencion", JOptionPane.WARNING_MESSAGE);
            return;
        }

        boolean agregado = false;
        String tipo = residuoActual.getTipo();

        //CLASIFICAMOS EL RESIDUO EN SU CONTENEDOR

        if (tipo.equals("Plastico")){
            agregado = contPlastico.agregarResiduo(residuoActual);
        }else if (tipo.equals("Vidrio")){
            agregado = contVidrio.agregarResiduo(residuoActual);
        } else if (tipo.equals("Papel/Carton")) {
            agregado = contPapel.agregarResiduo(residuoActual);
        } else if (tipo.equals("Elecctronico")) {
            agregado = contElectronico.agregarResiduo(residuoActual);

        }

        if (agregado){
            residuoActual = null; //VACIAMOS LA CINTA
            vista.getLblResiduoActual().setText("Esperando residuo...");
            actualizarBarras();
        } else {
            //Si el contenedor esta lleno
            JOptionPane.showMessageDialog(vista, "El contenedore de "+ tipo +" esta lleno", "Contenedor lleno", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarBarras() {
        vista.getBarraPlastico().setValue((int) contPlastico.getLlenadoActual());
        vista.getBarraVidrio().setValue((int) contVidrio.getLlenadoActual());
        vista.getBarraPapel().setValue((int) contPapel.getLlenadoActual());
        vista.getBarraElectronico().setValue((int) contElectronico.getLlenadoActual());
    }
}
