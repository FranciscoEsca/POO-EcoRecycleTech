package modelo;

public class ResiduoElectronico extends Residuo {

    public ResiduoElectronico(String id, double peso) {
        super(id, peso, "Electronico");
    }

    @Override
    public boolean esReciclable() {
        //LA CHATARRA ELECTRONICA SUELE REQUERIR DEMONTAJE POR LO QUE DIREMOS QUE REQUIERE REVISION SI PESA MAS DE 1KG
        return this.peso <= 1.0;
    }
}
