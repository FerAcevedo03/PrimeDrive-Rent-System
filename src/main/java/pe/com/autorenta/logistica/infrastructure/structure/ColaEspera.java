package pe.com.autorenta.logistica.infrastructure.structure;

import pe.com.autorenta.logistica.domain.Cliente;

public class ColaEspera implements java.io.Serializable {

    public class NodoCliente implements java.io.Serializable {

        private Cliente cliente;
        private NodoCliente siguiente;

        public NodoCliente(Cliente cliente) {
            this.cliente = cliente;
            this.siguiente = null;
        }

        // Devuelve el cliente almacenado en el nodo
        public Cliente getCliente() {
            return cliente;
        }

        // Devuelve el siguiente nodo en la cola
        public NodoCliente getSiguiente() {
            return siguiente;
        }

        // Permite enlazar el siguiente nodo
        public void setSiguiente(NodoCliente siguiente) {
            this.siguiente = siguiente;
        }
    }

    private NodoCliente frente;
    private NodoCliente fin;

    // Agregar cliente a la cola
    public void agregarACola(Cliente c) {
        NodoCliente nuevo = new NodoCliente(c);
        if (frente == null) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    // Atender (quitar) al siguiente cliente de la cola
    public Cliente atenderSiguiente() {
        if (frente == null) {
            return null;
        }
        Cliente c = frente.getCliente();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        return c;
    }

    // Devuelve el primer nodo de la cola
    public NodoCliente getFrente() {
        return frente;
    }

    // Verifica si la cola está vacía
    public boolean estaVacia() {
        return frente == null;
    }
}