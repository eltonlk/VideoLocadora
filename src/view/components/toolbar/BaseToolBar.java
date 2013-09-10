package view.components.toolbar;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public final class BaseToolBar extends JToolBar {
    
    private Map<String, JButton> buttons;
    private ActionListener listener;
    
    public BaseToolBar() {
        this.buttons = new HashMap<>();
        
        setMargin(new java.awt.Insets(100,500,0,10)); 
        
        setBackground(new java.awt.Color(245, 245, 245));
        
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(211, 211, 211)));
        
        this.setRollover(true);
    }
    
    public BaseToolBar(ActionListener listener) {
        this();
        
        this.listener = listener;
        
        loadDefaultButtons();
        
        disableButtonsToSave();
    }

    public void enableButtonsToSave() {
        enableOrDisableButtonsToSave(true);
    }
    
    public void disableButtonsToSave() {
        enableOrDisableButtonsToSave(false);
    }
    
    public Map<String, JButton> getButtons() {
        return buttons;
    }
    
    public BaseToolBar addButton(String text, String actionCommand, String iconPath) {
        JButton button = buildButton(text, actionCommand, iconPath);
        
        buttons.put(actionCommand, button);
        
        add(button);
        
        return this;
    }
    
    protected JButton buildButton(String text, String actionCommand, String iconPath) {
        JButton button = new JButton();

        button.setText(text);
        button.setMargin(new java.awt.Insets(4,4,4,4)); 
        button.setActionCommand(actionCommand);
        button.setIcon( new ImageIcon( getClass().getResource(iconPath) ) );
        button.setHorizontalTextPosition(SwingConstants.TRAILING);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.addActionListener(listener);
        
        return button;
    }
    
    protected void loadDefaultButtons() {
        this.addButton("Salvar"   , "save"  , "/assets/images/check_16.png")
            .addButton("Cancelar" , "cancel", "/assets/images/cancel_16.png");        
        
        this.add(new view.components.toolbar.Separator());
        
        this.addButton("Adicionar", "add"    , "/assets/images/plus_16.png")
            .addButton("Alterar"  , "edit"   , "/assets/images/edit_16.png")
            .addButton("Excluir"  , "destroy", "/assets/images/trash_16.png");
    }

    private void enableOrDisableButtonsToSave(boolean enabled) {
        buttons.get("add").setEnabled(!enabled);
        buttons.get("edit").setEnabled(!enabled);
        buttons.get("destroy").setEnabled(!enabled);
        buttons.get("save").setEnabled(enabled);
        buttons.get("cancel").setEnabled(enabled);
    }     
    
}
