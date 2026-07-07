package modelo;

public class ResiduoVidrio extends Residuo {

    public ResiduoVidrio(String id, double peso) {
        super(id, peso, "Vidrio");
    }

    @Override
    public boolean esReciclable() {
        // TODO EL VIDRIO LIMPIO ES RECICLABLE
        return true;
    }
}
