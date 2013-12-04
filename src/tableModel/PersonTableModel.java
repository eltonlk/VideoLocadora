package tableModel;

import dao.PersonDao;
import model.Person;

public class PersonTableModel extends util.GenericTableModel<Person> {

    private PersonDao dao = new PersonDao();

    public PersonTableModel() {
        this.columns = new String[] { "Nome" };

        reload();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
        case 0:
            return String.class;
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = rows.get(rowIndex);

        switch (columnIndex) {
        case 0:
            return person.getName();
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {};

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void reload() {
        addItems(dao.list());
    }

}
