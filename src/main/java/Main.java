import vista.VentanaPrincipal;

import controlador.Controlador;
import modelo.*;
import vista.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        // INSTANCIAMOS EL MODELO)
        ContenedorPlastico cp = new ContenedorPlastico();
        ContenedorVidrio cv = new ContenedorVidrio();
        ContenedorPapel cpa = new ContenedorPapel();
        ContenedorElectronico ce = new ContenedorElectronico();

        // INSTANCIAMOS LA VISTA)
        VentanaPrincipal vista = new VentanaPrincipal();

        // INSTANCIAMOS EL CONTROLADOR
        Controlador controlador = new Controlador(vista, cp, cv, cpa, ce);

        // INICIAMOS LA APP
        vista.setVisible(true);
    }
}
