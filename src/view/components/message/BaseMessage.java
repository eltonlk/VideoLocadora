package view.components.message;

import framework.BaseModel;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BaseMessage {
    
    public static void form(JInternalFrame frame, BaseModel object) {
        String message = "Registro foi salvo.";
        String title = "Registro foi salvo.";
        int messageType = JOptionPane.INFORMATION_MESSAGE;
        
        if (!object.isValid()) {
            title = "Não foi possivel salvar o registro.";
            message = "<html><b>Não foi possivel salvar o registro. Verefique os erros abaixo:</b><br><br>";
            
            Iterator iterator = object.getErrors().entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) iterator.next();
                
                message += mapEntry.getValue() + "<br>";
            }            
            
            messageType = JOptionPane.ERROR_MESSAGE;
        }

        JLabel label = new JLabel(message + "</html>");
        
        JOptionPane.showMessageDialog(frame, message, title, messageType);
    }
    
    public static boolean confirmDestroy() {
        String message = "Deseja excluir esse registro?";
        
        int result = JOptionPane.showConfirmDialog(null, message, message, JOptionPane.YES_NO_OPTION);
        
        return result == 0;
    }
    
    public static void destroyInfo() {
        JOptionPane.showMessageDialog(null, "Registro foi excluído.");
    }
    
}
