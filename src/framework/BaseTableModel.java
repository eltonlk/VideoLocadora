package framework;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public abstract class BaseTableModel extends AbstractTableModel {

    protected String[] columns;
    protected final List items;
    
    public BaseTableModel() {
        this.items = new ArrayList<>();
    }

    public BaseTableModel(List lines) {
        this.items = new ArrayList<>(lines); 
    }
    
    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }
    
    @Override
    public abstract Object getValueAt(int rowIndex, int columnIndex);
    
    @Override
    public abstract Class<?> getColumnClass(int columnIndex);
    
    public List getItems() {
        return items;
    }
    
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
    
    public void addListOfItems(List items) {
        int index = getRowCount();

        this.items.addAll(items);

        fireTableDataChanged();
    }    
    
    public void clear() {
        this.items.clear();

        fireTableDataChanged();
    }
}