package util;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public abstract class GenericController<M> {
    
    protected JDesktopPane pane;
    
    public GenericController() {
    }
    
    public abstract void list();

    protected void showFrame(JInternalFrame frame) {
        Dimension desktopSize = pane.getSize();

        Dimension frameSize = frame.getSize();

        frame.setLocation((desktopSize.width - frameSize.width)/2, (desktopSize.height- frameSize.height)/4);
        
        pane.add(frame);
        
        frame.setVisible(true);
    }    

}
