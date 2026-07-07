package modelo;

public class ResiduoPapel extends Residuo {

    public ResiduoPapel(String id, double peso){
        super(id, peso, "Papel/Carton");
    }

    @Override
    public boolean esReciclable() {
        // COMO EN EL PLASTICO DISCRIMINAREMOS POR EL PESO
        return this.peso <= 2.5;
    }
}

