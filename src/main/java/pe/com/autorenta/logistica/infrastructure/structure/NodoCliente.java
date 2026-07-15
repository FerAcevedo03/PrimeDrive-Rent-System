package pe.com.autorenta.logistica.infrastructure.structure;

import pe.com.autorenta.logistica.domain.Cliente;

public class NodoCliente implements java.io.Serializable{

    private Cliente cliente;
     NodoCliente siguiente;

    public NodoCliente(Cliente cliente) {
        this.cliente = cliente;
        this.siguiente = null;
    }

    public pe.com.autorenta.logistica.domain.Cliente getCliente() {
        return cliente;
    }

    public NodoCliente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCliente siguiente) {
        this.siguiente = siguiente;
    }
}