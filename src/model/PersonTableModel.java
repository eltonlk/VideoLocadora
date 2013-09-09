package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PersonTableModel extends AbstractTableModel {

    private List<Person> people;
   
    private String[] columns = new String[] { "Id", "Legal Name", "Name", "Situação" };
    
    private static final int ID = 0;
    private static final int LEGALNAME = 1;   
    private static final int NAME = 2;     
    private static final int STATUS = 3;     

    public PersonTableModel() {
        this.people = new ArrayList<>();
    }
    
    public PersonTableModel(List<Person> people) {
        this.people = new ArrayList<>(people);
    }
    
    @Override
    public int getRowCount() {
        return people.size();
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
        case LEGALNAME:
            return String.class;
        case NAME:
            return String.class;
        case STATUS:
            return boolean.class;
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }     
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = people.get(rowIndex);

        switch (columnIndex) {
        case ID:
            return person.getId();
        case LEGALNAME:
            return person.getLegalName();
        case NAME:
            return person.getName();
        case STATUS:
            return person.getStatus();
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }     

    public Person getPerson(int index) {
        return people.get(index);
    }

    public void addPerson(Person person) {
        int index = people.indexOf(person);

        if (index == -1) {
            people.add(person);
            
            index = getRowCount();
            
            fireTableRowsInserted(index, index);
        } else {
            people.set(index, person);

            fireTableRowsUpdated(index, index);
        }
    }    

    public void removePerson(Person person) {
        int index = people.indexOf(person);

        if (index != -1) {
            people.remove(index);

            fireTableRowsDeleted(index + 1, index + 1);            
        }
    }    
    
}
