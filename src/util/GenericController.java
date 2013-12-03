package util;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public abstract class GenericController<M> {
    
    protected JDesktopPane pane;
    protected GenericDao dao;
    
    public GenericController() {
    }
    
    public abstract void list();

    public boolean save(GenericModel object) {
        if (object.isValid()) {
            return dao.save(object);
        } else {
            return false;
        }
    }
    
    public boolean destroy(M object) {
        return dao.destroy(object);
    }
    
    protected void showFrame(JInternalFrame frame) {
        Dimension desktopSize = pane.getSize();

        Dimension frameSize = frame.getSize();

        frame.setLocation((desktopSize.width - frameSize.width)/2, (desktopSize.height- frameSize.height)/4);
        
        pane.add(frame);
        
        frame.setVisible(true);
    }    
    
}
