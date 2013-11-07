package framework;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public abstract class BaseTableModel extends AbstractTableModel {

    protected String[][] columns;
    protected final List items;
    
    public BaseTableModel() {
        this.items = new ArrayList<>();
    }

    public BaseTableModel(List lines) {
        this.items = new ArrayList<>(lines); 
    }
    
    public void setColumns(String[][] columns) {
        this.columns = columns;
    }
    
    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
//    @Override
//    public String getColumnName(int columnIndex) {
//        return columns[columnIndex];
//    }
    
//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        switch (columnIndex) {
//        case ID:
//            return int.class;
//        case NAME:
//            return String.class;
//        case STATUS:
//            return String.class;
//        default:
//            throw new IndexOutOfBoundsException("columnIndex out of bounds");
//        }
//    }    

    public Object getItem(int index) {
        return items.get(index);
    }

    public void addItem(Object item) {
        int index = items.indexOf(item);

        if (index == -1) {
            items.add(item);
            
            index = getRowCount();
            
            fireTableRowsInserted(index, index);
        } else {
            items.set(index, item);

            fireTableRowsUpdated(index, index);
        }        
    }
    
    public void removeItem(Object item) {
        int index = items.indexOf(item);

        if (index != -1) {
            items.remove(index);

            fireTableRowsDeleted(index + 1, index + 1);            
        }
    }     
}