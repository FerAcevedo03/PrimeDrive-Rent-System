package pe.com.autorenta.logistica.infrastructure.structure;

import pe.com.autorenta.logistica.domain.Vehiculo;

public class ArbolVehiculos implements java.io.Serializable {

    private class NodoArbol implements java.io.Serializable {

        Vehiculo vehiculo;
        NodoArbol izquierdo, derecho;

        public NodoArbol(Vehiculo vehiculo) {
            this.vehiculo = vehiculo;
        }
    }

    private NodoArbol raiz;

    public void insertar(Vehiculo v) {
        raiz = insertarRecursivo(raiz, v);
    }

    private NodoArbol insertarRecursivo(NodoArbol nodo, Vehiculo v) {
        if (nodo == null) {
            return new NodoArbol(v);
        }

        // Estandarizamos a mayúsculas para evitar que el árbol se cruce
        String placaNueva = v.getPlaca().toUpperCase();
        String placaActual = nodo.vehiculo.getPlaca().toUpperCase();

        if (placaNueva.compareTo(placaActual) < 0) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, v);
        } else if (placaNueva.compareTo(placaActual) > 0) {
            nodo.derecho = insertarRecursivo(nodo.derecho, v);
        }
        return nodo;
    }

    public Vehiculo buscar(String placa) {
        // Obligamos a que la búsqueda sea en mayúsculas
        return buscarRecursivo(raiz, placa.toUpperCase());
    }

    private Vehiculo buscarRecursivo(NodoArbol nodo, String placaBuscada) {
        if (nodo == null || nodo.vehiculo.getPlaca().toUpperCase().equals(placaBuscada)) {
            return (nodo != null) ? nodo.vehiculo : null;
        }
        if (placaBuscada.compareTo(nodo.vehiculo.getPlaca().toUpperCase()) < 0) {
            return buscarRecursivo(nodo.izquierdo, placaBuscada);
        }
        return buscarRecursivo(nodo.derecho, placaBuscada);
    }

    public void inOrdenHaciaLista(ListaVehiculos lista) {
        inOrdenRecursivo(raiz, lista);
    }

    private void inOrdenRecursivo(NodoArbol nodo, ListaVehiculos lista) {
        if (nodo != null) {
            inOrdenRecursivo(nodo.izquierdo, lista);
            lista.registrar(nodo.vehiculo);
            inOrdenRecursivo(nodo.derecho, lista);
        }
    }
}