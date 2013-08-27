package view.person;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Person;

public class PersonTableModel extends AbstractTableModel {

    private List<Person> people;
    private List<String> columns;

    public PersonTableModel(List<Person> people) {
        this.people = people;
        this.columns = Arrays.asList( "Id", "Nome", "Tipo", "Situação" );
    }

    @Override
    public String getColumnName(int column) {
        return columns.get(column);
    }
    
    @Override
    public int getRowCount() {
        return people.size();
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = people.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return person.getId();
            case 1: return person.getName();
            case 2: return person.getKind();
            case 3: return person.getStatus();
        }        
        
        return null;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
    
}
