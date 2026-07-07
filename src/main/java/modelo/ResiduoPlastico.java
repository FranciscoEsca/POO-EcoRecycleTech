package modelo;

public class ResiduoPlastico extends Residuo {

    public ResiduoPlastico(String id, double peso) {
        super(id, peso, "Plastico");
    }

    @Override
    public boolean esReciclable() {
        // logica simulada: si no excede los 5kg es reciclable
        return this.peso <= 5.0;
    }
}
