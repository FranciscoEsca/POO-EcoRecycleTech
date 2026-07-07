package modelo;

public abstract class Residuo implements IResiduo {
    protected String id;
    protected double peso;
    protected String tipo;

    //CONSTRUCTOR PARA LOS RESIDUOS
    public Residuo(String id, double peso, String tipo) {
        this.id = id;
        this.peso = peso;
        this.tipo = tipo;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public double getPeso() {
        return this.peso;
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

    // METODO POLIMORFICO QUELAS CLASES HIJAS HAN DE RELLENAR OBLIGATORIAMENTE
    public abstract boolean esReciclable();

}