package pe.com.autorenta.logistica.infrastructure.structure;

import pe.com.autorenta.logistica.domain.Vehiculo;

public class ListaVehiculos implements java.io.Serializable{

    private NodoVehiculo cabeza;

    public ListaVehiculos() {
        this.cabeza = null;
    }

    public void registrar(Vehiculo v) {
        NodoVehiculo nuevo = new NodoVehiculo(v);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoVehiculo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
    }

    public void ordenarPorMarca() {
        if (cabeza == null || cabeza.getSiguiente() == null) {
            return;
        }

        boolean intercambiado;
        do {
            intercambiado = false;
            NodoVehiculo actual = cabeza;

            while (actual.getSiguiente() != null) {
                NodoVehiculo siguiente = actual.getSiguiente();

                
                if (actual.getVehiculo().getMarca().compareToIgnoreCase(siguiente.getVehiculo().getMarca()) > 0) {
                    Vehiculo temp = actual.getVehiculo();
                    actual.setVehiculo(siguiente.getVehiculo());
                    siguiente.setVehiculo(temp);
                    intercambiado = true;
                }
                actual = actual.getSiguiente();
            }
        } while (intercambiado);
    }

    public NodoVehiculo getCabeza() {
        return cabeza;
    }
}
