package pe.com.autorenta.logistica.presentation;

public class Main {

    public static void main(String[] args) {
        
        // Ejecutar la interfaz gráfica 
        java.awt.EventQueue.invokeLater(() -> {
            

            GUINlogin ventanaLogin = new GUINlogin();
  
            ventanaLogin.setVisible(true);
            
        });
        
    }
}