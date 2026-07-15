package pe.com.autorenta.logistica.infrastructure.structure;

import pe.com.autorenta.logistica.domain.Vehiculo;

public class PilaBajas implements java.io.Serializable{

    private NodoVehiculo tope;

    public void apilar(Vehiculo v) {
        NodoVehiculo nuevo = new NodoVehiculo(v);
        nuevo.setSiguiente(tope);
        tope = nuevo;
    }

    public Vehiculo desapilar() {
        if (tope == null) {
            return null;
        }
        Vehiculo v = tope.getVehiculo();
        tope = tope.getSiguiente();
        return v;
    }

    public NodoVehiculo getCima() {
        return this.tope;
    }
}