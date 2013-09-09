package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class GenderTableModel extends AbstractTableModel {

    private List<Gender> genders;
    private String[] columns = new String[] { "ID", "Name", "Ativo" };
    
    private static final int ID = 0;
    private static final int NAME = 1;   
    private static final int ACTIVE = 2;       
    
    public GenderTableModel() {
        this.genders = new ArrayList<>();
    }

    public GenderTableModel(List<Gender> genders) {
        this.genders = new ArrayList<>(genders); 
    }    
    
    @Override
    public int getRowCount() {
        return genders.size();
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
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
        case ID:
            return int.class;
        case NAME:
            return String.class;
        case ACTIVE:
            return boolean.class;
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == ACTIVE;
    }    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Gender gender = genders.get(rowIndex);

        switch (columnIndex) {
        case ID:
            return gender.getId();
        case NAME:
            return gender.getName();
        case ACTIVE:
            return gender.isActive();
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }    

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Gender gender = genders.get(rowIndex);

        switch (columnIndex) {
        case ID:
            gender.setId((int) aValue);
            break;
        case NAME:
            gender.setName((String) aValue);
            break;
        case ACTIVE:
            gender.setActive((boolean) aValue);
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        fireTableCellUpdated(rowIndex, columnIndex);
    }    

    public Gender getGender(int index) {
        return genders.get(index);
    }

    public void addGender(Gender gender) {
        genders.add(gender);

        int lastIndex = getRowCount() - 1;

        fireTableRowsInserted(lastIndex, lastIndex);
    }

    public void removeGender(int index) {
        genders.remove(index);

        fireTableRowsDeleted(index, index);
    }

    public void addListOfGenders(List<Gender> genders) {
        int index = getRowCount();

        genders.addAll(genders);

        fireTableRowsInserted(index, index + genders.size());
    }

    public void clear() {
        genders.clear();

        fireTableDataChanged();
    }    
    
}
