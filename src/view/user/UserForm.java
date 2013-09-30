package view.user;

import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class UserForm extends JFrame {
    
    private JTextField login;
    private JTextField email;
    private JButton cadastrar;

    public UserForm() throws HeadlessException {
        init();
        layoutComponents();
    }

    private void init() {
        login = new JTextField();
        email = new JTextField();
        cadastrar = new JButton();
    }

    private void layoutComponents() {
        String colunas = "pref, 5dlu, fill:pref:grow";
        String linhas = "pref, pref, pref";
        
        FormLayout layout = new FormLayout(colunas, linhas);
        
        PanelBuilder builder = new PanelBuilder(layout);
        
        builder.addLabel("Usuário", CC.xy(1, 1));
        builder.add(login, CC.xy(3, 1));
        
        builder.addLabel("Email", CC.xy(1, 2));
        builder.add(email, CC.xy(3, 2));
        
        builder.add(cadastrar, CC.xy(1, 3));
        
        add(builder.getPanel());
    }
    
}
