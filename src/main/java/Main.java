import vista.VentanaPrincipal;

import controlador.Controlador;
import modelo.*;
import vista.VentanaPrincipal;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        // INSTANCIAMOS EL MODELO)
        ContenedorPlastico cp = new ContenedorPlastico();
        ContenedorVidrio cv = new ContenedorVidrio();
        ContenedorPapel cpa = new ContenedorPapel();
        ContenedorElectronico ce = new ContenedorElectronico();
        //CARGAMOS EL ESTADO ANTERIOR
        GestorArchivos.cargarEstado(cp, cv, cpa, ce);

        // INSTANCIAMOS LA VISTA)
        VentanaPrincipal vista = new VentanaPrincipal();

        // INSTANCIAMOS EL CONTROLADOR
        Controlador controlador = new Controlador(vista, cp, cv, cpa, ce);

        //GUARDAMOS EL ESTADO AL CERRAR
        vista.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                GestorArchivos.guardarEstado(cp, cv, cpa, ce);
            }
        });

        // INICIAMOS LA APP
        vista.setVisible(true);
    }
}
