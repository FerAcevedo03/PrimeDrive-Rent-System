package pe.com.autorenta.logistica.domain;

public class Vehiculo implements java.io.Serializable{

    private String placa;
    private String marca;
    private String modelo;
    private double precio;
    private Cliente clienteRentado; 
    private boolean estadoLogico;

    public Vehiculo(String placa, String marca, String modelo, double precio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.clienteRentado = null;
        this.estadoLogico = true;
    }


    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public Cliente getClienteRentado() {
        return clienteRentado;
    }

    public void setClienteRentado(Cliente clienteRentado) {
        this.clienteRentado = clienteRentado;
    }

    public boolean isEstadoLogico() {
        return estadoLogico;
    }

    public void setEstadoLogico(boolean estadoLogico) {
        this.estadoLogico = estadoLogico;
    }

    public void darDeBaja() {
        this.estadoLogico = false;
    }
}
