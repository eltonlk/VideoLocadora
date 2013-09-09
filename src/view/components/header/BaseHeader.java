package view.components.header;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.components.toolbar.BaseToolBar;

public class BaseHeader extends JPanel {

    private String title;
    private ActionListener listener;
    private BaseToolBar toolbar;
    
    public BaseHeader() {
        this.setBackground(Color.white);
        this.setSize(960, 60);
    }
    
    public BaseHeader(String title, ActionListener listener) {
        this();
        
        this.title = title;
        this.listener = listener;
        
        loadDefaultElements();
    }

    public BaseToolBar getToolbar() {
        return toolbar;
    }
    
    private void loadDefaultElements() {
        this.add(buildTitleLabel());
        this.add(toolBar());
    }
    
    private BaseToolBar toolBar() {
        toolbar = new BaseToolBar(listener);
        toolbar.setRollover(true);
        toolbar.setBounds(getWidth() - 310, 5, 330, 50);
        toolbar.setBackground(Color.white);
        toolbar.setBorder(null);
                
        return toolbar;
    }
    
    private JLabel buildTitleLabel() {
        JLabel label = new JLabel();
        
        label.setText(title);
        label.setBounds(10, 10, 300, 40);
        label.setFont(new java.awt.Font("Droid Sans", 0, 24));
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/icons/32x32/user-4.png")));
                
        return label;
    }
    
}
