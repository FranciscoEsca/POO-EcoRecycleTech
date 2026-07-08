package modelo;

import java.util.Random;
import java.util.UUID;

public class ResiduoFactory {

    private static final Random random = new Random();
    //GENERA UN RESIDUO ALEATORIO DEVOLVIENDO LA INTERFAZ DE IResiduo, ocultando implementacion concreta.
    public static IResiduo generarResiduoAleatorio() {
        //GENERAMOS UN ID USANDO LOS 6 PRIMEROS CARACTERES DE UUID
        String idRandom = UUID.randomUUID().toString().substring(0, 6).toUpperCase();

        //GENERAMOS PESO ALEATORIO ENTRE 0.5 Y 10 KG, REDONDEANDO A 2 DECIMALES
        double peso = 0.5 + (9.5 * random.nextDouble());
        peso = Math.round(peso * 100.0) / 100.0;

        //ELEGIR ALEATORIAMENTE EL RESIDUO
        int tipo = random.nextInt(4);

        switch (tipo){
            case 0:
                return new ResiduoPlastico("PLA-" + idRandom, peso);
            case 1:
                return new ResiduoVidrio("VID-" + idRandom, peso);
            case 2:
                return new ResiduoPapel("PAP-" + idRandom, peso);
            case 3:
                return new ResiduoElectronico("ELE-" + idRandom, peso);
            default:
                //DEVOLVEREMOS PLASTICO POR DEFECTO SI ALGO FALLARA
                return new ResiduoPlastico("PLA-" + idRandom, peso);
        }
    }
}
