package util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public abstract class GenericTableModel<T> extends AbstractTableModel {

    protected List<T> rows;
    protected String[] columns;
    
    public GenericTableModel() {
	this.rows = new ArrayList<>(0);
        this.columns = new String[] {};
    }

    public GenericTableModel(List<T> rows) {
	this.rows = new ArrayList<>(rows);
    }
    
    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    };

    @Override
    public abstract Class<?> getColumnClass(int columnIndex);
    
    @Override
    public abstract Object getValueAt(int rowIndex, int columnIndex);
    
    @Override
    public abstract void setValueAt(Object aValue, int rowIndex, int columnIndex);

    @Override
    public abstract boolean isCellEditable(int rowIndex, int columnIndex);
    
    public abstract void reload();
    
    public T getItem(int index) {
        return rows.get(index);
    }

    public void addItem(T object) {
        this.rows.add(object);

        int lastIndex = getRowCount() - 1;

        fireTableRowsInserted(lastIndex, lastIndex);
    }

    public void removeItem(int index) {  	
        this.rows.remove(index);

        fireTableRowsDeleted(index, index);
    }

    public void addItems(List<T> items) {
        clear();
        
        int old_index = getRowCount();

        this.rows.addAll(items);

        fireTableRowsInserted(old_index, getRowCount() - 1);
    }
    
    public List<T> getItems() {
        return rows;
    }

    public void clear() {
        this.rows.clear();

        fireTableDataChanged();
    }

    public boolean isEmpty() {
        return rows.isEmpty();
    }
   
}
