package modelo;

public abstract class Contenedor {
    protected double capacidadMaxima;
    protected double llenadoActual;
    protected String tipoAceptado;

    public Contenedor(double capacidadMaxima, String tipoAceptado){
        this.capacidadMaxima = capacidadMaxima;
        this.llenadoActual = 0.0;
        this.tipoAceptado = tipoAceptado;
    }

    //METODO QUE COMPRUEBA SI EL RESIDUO CABE Y SI ES DEL TIPO CORRECTO
    public boolean agregarResiduo(IResiduo residuo){
        if (residuo.getTipo().equals(this.tipoAceptado) && (llenadoActual + residuo.getPeso() <= capacidadMaxima)){
            llenadoActual += residuo.getPeso();
            return true;
        }
        return false;
    }

    //GETTERS PARA USAR EN LA INTERFAZ GRAFICA
    public double getLlenadoActual() { return llenadoActual; }
    public double getCapacidadMaxima() { return capacidadMaxima;}
    public String getTipoAceptado () {return getTipoAceptado();}

}
