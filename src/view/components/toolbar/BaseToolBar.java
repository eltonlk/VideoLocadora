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
        
        this.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }
    
    public BaseToolBar(ActionListener listener) {
        this();
        
        this.listener = listener;
        
        loadDefaultButtons();
    }

    public Map<String, JButton> getButtons() {
        return buttons;
    }
    
    public BaseToolBar addButton(String text, String iconPath) {
        JButton button = buildButton(text, iconPath);
        
        buttons.put(text.toLowerCase(), button);
        
        add(button);
        
        return this;
    }
    
    protected JButton buildButton(String text, String iconPath) {
        JButton button = new JButton();

        button.setText(text);
        button.setIcon( new ImageIcon( getClass().getResource(iconPath) ) );
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.addActionListener(listener);
        
        return button;
    }
    
    protected void loadDefaultButtons() {
//        this.addButton("Adicionar", "/assets/images/icons/16x16/add.png")
//            .addButton("Alterar"  , "/assets/images/icons/16x16/pen.png")
//            .addButton("Excluir"  , "/assets/images/icons/16x16/delete.png")
//            .addButton("Salvar"   , "/assets/images/icons/16x16/add.png")
//            .addButton("Cancelar" , "/assets/images/icons/16x16/nope.png"); // remove
////        
//        this.addButton("Adicionar", "/assets/images/icons/super-mono/sticker/icons/button-add.png")
//            .addButton("Alterar"  , "/assets/images/icons/super-mono/sticker/icons/pencil.png")
//            .addButton("Excluir"  , "/assets/images/icons/super-mono/sticker/icons/bin.png")
//            .addButton("Salvar"   , "/assets/images/icons/super-mono/sticker/icons/button-check.png")
//            .addButton("Cancelar" , "/assets/images/icons/super-mono/sticker/icons/button-cross.png");
//        
        this.addButton("Adicionar", "/assets/images/icons/super-mono/basic/blue/button-add2.png")
            .addButton("Alterar"  , "/assets/images/icons/super-mono/basic/blue/document-edit2.png")
            .addButton("Excluir"  , "/assets/images/icons/super-mono/basic/red/bin2.png")
            .addButton("Salvar"   , "/assets/images/icons/super-mono/basic/green/button-check2.png")
            .addButton("Cancelar" , "/assets/images/icons/super-mono/basic/red/button-cross2.png");
    }

}
