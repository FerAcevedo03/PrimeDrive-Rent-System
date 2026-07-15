/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.autorenta.logistica.infrastructure.structure;

import pe.com.autorenta.logistica.application.GestorAlquiler;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GestorPersistencia {
    
    private static final String RUTA_ARCHIVO = "memoria_agencia.dat";

    // Método para guardar toda memoria en el archivo
    public static void guardarDatos(GestorAlquiler gestor) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            out.writeObject(gestor);
            System.out.println("Datos guardados con éxito en " + RUTA_ARCHIVO);
        } catch (Exception e) {
            System.out.println("Error crítico al guardar los datos: " + e.getMessage());
        }
    }

    // Método para leer el archivo al abrir el sistema
    public static GestorAlquiler cargarDatos() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(RUTA_ARCHIVO))) {
            System.out.println("Memoria anterior cargada con éxito.");
            return (GestorAlquiler) in.readObject();
        } catch (Exception e) {
            System.out.println("No se encontró memoria previa. Iniciando sistema en blanco.");
            return new GestorAlquiler(); 
        }
    }
}