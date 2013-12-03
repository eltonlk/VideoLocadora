package util;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GenericTableActionListener implements ListSelectionListener {

    private final JTable table;
    
    public GenericTableActionListener(JTable table) {
        this.table = table;
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
