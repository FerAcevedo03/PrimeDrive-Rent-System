package pe.com.autorenta.logistica.application;

import pe.com.autorenta.logistica.domain.Cliente;
import pe.com.autorenta.logistica.domain.Vehiculo;
import pe.com.autorenta.logistica.infrastructure.structure.ArbolVehiculos;
import pe.com.autorenta.logistica.infrastructure.structure.ColaEspera;
import pe.com.autorenta.logistica.infrastructure.structure.ListaVehiculos;
import pe.com.autorenta.logistica.infrastructure.structure.PilaBajas;

public class GestorAlquiler implements java.io.Serializable {


    private ArbolVehiculos inventario;
    private ColaEspera colaAgencia;
    private PilaBajas historialAlquileres;
    
    private Cliente clienteEnVentanilla; 

    public GestorAlquiler() {
        this.inventario = new ArbolVehiculos();
        this.colaAgencia = new ColaEspera();
        this.historialAlquileres = new PilaBajas();
        this.clienteEnVentanilla = null; // Inicia vacío

        inventario.insertar(new Vehiculo("T3X-123", "Toyota", "Yaris 2016", 120.0));
        inventario.insertar(new Vehiculo("ABC-999", "Hyundai", "Accent 2020", 150.0));
        inventario.insertar(new Vehiculo("ZXV-555", "Audi", "A4 2023", 300.0));
        inventario.insertar(new Vehiculo("MNO-111", "Chevrolet", "Sail 2019", 100.0));
    }

    public ListaVehiculos obtenerCatalogoOrdenadoPorMarca() {
        ListaVehiculos lista = new ListaVehiculos();
        inventario.inOrdenHaciaLista(lista);
        lista.ordenarPorMarca();
        return lista;
    }

    public void registrarLlegadaCliente(String dni, String nombre) {
        colaAgencia.agregarACola(new Cliente(dni, nombre));
    }

    public Cliente llamarSiguienteCliente() {
        // Guarda al cliente en la variable global para que el botón "Rentar" sepa quién es
        this.clienteEnVentanilla = colaAgencia.atenderSiguiente();
        return this.clienteEnVentanilla;
    }

    // Método lógico original
    public boolean alquilarVehiculo(String placa, Cliente c) {
        Vehiculo v = inventario.buscar(placa);
        if (v != null && v.isEstadoLogico() && v.getClienteRentado() == null) {
            v.setClienteRentado(c);
            historialAlquileres.apilar(v); 
            return true;
        }
        return false;
    }

    // Deshacer el último alquiler original
    public boolean deshacerUltimoAlquiler() {
        Vehiculo v = historialAlquileres.desapilar();
        if (v != null) {
            v.setClienteRentado(null); 
            return true;
        }
        return false;
    }


    public boolean rentarVehiculo(String placa) {
        // Validamos que haya un cliente siendo atendido
        if (this.clienteEnVentanilla == null) {
            return false;
        }
        
        // Ejecuta el método de alquilar
        boolean exito = alquilarVehiculo(placa, this.clienteEnVentanilla);
        
        // Si logró rentar el auto, la ventanilla vuelve a quedar libre
        if (exito) {
            this.clienteEnVentanilla = null; 
        }
        return exito;
    }

    public boolean deshacerUltimaAccion() {
        // Llama a tu método original
        return deshacerUltimoAlquiler();
    }

    public Vehiculo buscarVehiculo(String placa) {
        // Usa el método de búsqueda de tu Árbol Binario
        return inventario.buscar(placa);
    }
    
    
   //añadir auto
    public void registrarNuevoVehiculo(String placa, String marca, String modelo, double precio) {
        inventario.insertar(new Vehiculo(placa, marca, modelo, precio));
    }
    public void ordenarVehiculosPorPrecio() {
        // Nota: Si vas a usar el ordenamiento por precio, necesitas tener un método 
        // "lista.ordenarPorPrecio()" en tu clase ListaVehiculos aplicando el Bubble Sort.
    }


    public pe.com.autorenta.logistica.infrastructure.structure.ColaEspera getColaEspera() {
        return this.colaAgencia; 
    }

    public pe.com.autorenta.logistica.infrastructure.structure.PilaBajas getPilaHistorial() {
        return this.historialAlquileres; 
    }
    
   public boolean eliminarVehiculo(String placa) {
        // Busca el vehículo en tu Árbol Binario (inventario)
        Vehiculo v = inventario.buscar(placa);
        
        if (v == null) {
            return false; 
        }
        
        // No se puede borrar si un cliente lo tiene alquilado
        if (v.getClienteRentado() != null) {
            return false; 
        }
        
        v.setEstadoLogico(false); 
        
        return true; 
    }
 }
       
