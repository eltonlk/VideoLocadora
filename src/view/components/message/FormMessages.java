package view.components.message;

import framework.BaseModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FormMessages {
    
    @SuppressWarnings("empty-statement")
    public static void show(JInternalFrame frame, BaseModel object) {
        String message = "Registro foi salvo.";
        String title = "Registro foi salvo.";
        int messageType = JOptionPane.INFORMATION_MESSAGE;
        
        if (!object.isValid()) {
            title = "Não foi possivel salvar o registro.";
            message = "<html><b>Não foi possivel salvar o registro. Verefique os erros abaixo:</b><br><br>";
           
            for (Object error : object.getFullErrorMessages()) {
                message += error.toString() + "<br>";
            }
            
            messageType = JOptionPane.ERROR_MESSAGE;
        }

        JLabel label = new JLabel(message + "</html>");
        
        JOptionPane.showMessageDialog(frame, message, title, messageType);
    }
    
}
