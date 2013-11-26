package util;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import view.main.ListPanel;

public abstract class GenericController<M> {
    
    protected GenericDao dao;
    protected GenericTableModel tableModel;
    protected JDesktopPane pane;

    public GenericController() {
    }
    
    public void list() {
        ListPanel panel = new ListPanel(this);
        
        addFrame(panel);
    }

    public void show() {
    }
    
    public void save(M actor) {
        dao.save(actor);
    }
    
    public void destroy(M actor) {
        dao.destroy(actor);
    }    

    protected void addFrame(JInternalFrame frame) {
        Dimension desktopSize = pane.getSize();

        Dimension frameSize = frame.getSize();

        frame.setLocation((desktopSize.width - frameSize.width)/2, (desktopSize.height- frameSize.height)/2);
        
        pane.add(frame);
        
        frame.setVisible(true);
    }    

    public void loadItemsToTable(JTable table) {
        tableModel.addItems(dao.list());

        table.setModel(tableModel);
    }
    
}
