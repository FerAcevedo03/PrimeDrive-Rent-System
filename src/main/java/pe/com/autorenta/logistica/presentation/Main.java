package pe.com.autorenta.logistica.presentation;

public class Main {

    public static void main(String[] args) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName()) || "Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            // Si hay un error simplemente lo ignora 
        }

        // Ejecuta la interfaz gráfica 
        java.awt.EventQueue.invokeLater(() -> {
            
            GUINlogin ventanaLogin = new GUINlogin();
            
            // Centra la ventana exactamente en el medio de la pantalla
            ventanaLogin.setLocationRelativeTo(null); 
  
            ventanaLogin.setVisible(true);
            
        });
        
    }
}