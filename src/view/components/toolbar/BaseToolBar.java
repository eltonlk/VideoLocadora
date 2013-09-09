package view.components.toolbar;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public final class BaseToolBar extends JToolBar {
    
    private Map<String, JButton> buttons;
    private ActionListener listener;
    
    public BaseToolBar() {
        this.buttons = new HashMap<>();
    }
    
    public BaseToolBar(ActionListener listener) {
        this();
        
        this.listener = listener;
        
        loadDefaultButtons();
    }

    public Map<String, JButton> getButtons() {
        return buttons;
    }
    
    public BaseToolBar addButton(String text, String actionCommand, String iconPath) {
        JButton button = buildButton(text, actionCommand, iconPath);
        
        buttons.put(text.toLowerCase(), button);
        
        add(button);
        
        return this;
    }
    
    protected JButton buildButton(String text, String actionCommand, String iconPath) {
        JButton button = new JButton();

        button.setText(text);
        button.setActionCommand(actionCommand);
        button.setIcon( new ImageIcon( getClass().getResource(iconPath) ) );
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.addActionListener(listener);
        
        return button;
    }
    
    protected void loadDefaultButtons() {
        this.addButton("Salvar"   , "save"  , "/assets/images/icons/super-mono/basic/green/button-check2.png")
            .addButton("Cancelar" , "cancel", "/assets/images/icons/super-mono/basic/red/button-cross2.png");
        
        this.addSeparator(new Dimension(50, 0));        
                
        this.addButton("Adicionar", "add"    , "/assets/images/icons/super-mono/basic/blue/button-add2.png")
            .addButton("Alterar"  , "edit"   , "/assets/images/icons/super-mono/basic/blue/document-edit2.png")
            .addButton("Excluir"  , "destroy", "/assets/images/icons/super-mono/basic/red/bin2.png");
    }

}
