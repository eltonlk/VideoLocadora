package view.components.header;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BaseHeader extends JPanel {

    private String title;
    
    public BaseHeader() {
        this.setBackground(Color.white);
        this.setSize(960, 60);
    }
    
    public BaseHeader(String title) {
        this();
        
        this.title = title;
        
        loadDefaultElements();
    }
    
    private void loadDefaultElements() {
        this.add(buildTitleLabel());
    }
    
    private JLabel buildTitleLabel() {
        JLabel label = new JLabel();
        
        label.setText(title);
        label.setBounds(10, 10, 500, 40);
        label.setFont(new java.awt.Font("Droid Sans", 0, 24));
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/32x32/user-4.png")));
                
        return label;
    }
    
}
