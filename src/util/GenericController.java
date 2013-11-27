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
    protected M currentObject;
    
    public GenericController() {
    }
    
    public void list() {
        JInternalFrame list = new ListPanel(this);
        
        addFrame(list);
    }

    public void form() {
        
    }
    
    public void save(M object, JInternalFrame frame) {
        dao.save(object);
    }
    
    public void destroy(M object) {
        dao.destroy(object);
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

    public GenericTableModel getTableModel() {
        return tableModel;
    }
}
