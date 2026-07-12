package modelo;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestorArchivos {
    private static final String ARCHIVO_LOG = "recycle.log";
    private static final String ARCHIVO_ESTADO = "estado_planta.txt";

    //ESCRIBE UNA LINEA EN EL HISTORIAL CADA VEZ QUE SE PROCESA UN RESIDUO
    public static void registrarLog(IResiduo residuo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_LOG, true))) {
            String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String linea = fechaHora + " | ID: " + residuo.getID() + " | Tipo: " + residuo.getTipo() + " | Peso: " + residuo.getPeso() + "kg\n";
            bw.write(linea);
        } catch (IOException e) {
            System.out.println("Error al escribir el log: " + e.getMessage());
        }
    }

   //GUARDA LOS NIVELES DE LOS CONTENEDORES
   public static void guardarEstado(ContenedorPlastico cp, ContenedorVidrio cv, ContenedorPapel cpa, ContenedorElectronico ce) {
       try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_ESTADO))) {
           bw.write(cp.getLlenadoActual() + "\n");
           bw.write(cv.getLlenadoActual() + "\n");
           bw.write(cpa.getLlenadoActual() + "\n");
           bw.write(ce.getLlenadoActual() + "\n");
       } catch (IOException e) {
           System.out.println("Error al guardar estado: " + e.getMessage());
       }
   }

   //LEE EL ARCHIVO ESTADO PARA RECUPERAR LOS NIVELES
   public static void cargarEstado(ContenedorPlastico cp, ContenedorVidrio cv, ContenedorPapel cpa, ContenedorElectronico ce) {
       File archivo = new File(ARCHIVO_ESTADO);
       if (archivo.exists()) {
           try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
               cp.setLlenadoActual(Double.parseDouble(br.readLine()));
               cv.setLlenadoActual(Double.parseDouble(br.readLine()));
               cpa.setLlenadoActual(Double.parseDouble(br.readLine()));
               ce.setLlenadoActual(Double.parseDouble(br.readLine()));
           } catch (Exception e) {
               System.out.println("Error al cargar estado o archivo vacío.");
           }
       }
   }

}
