package tableModel;

import dao.PersonDao;
import model.Person;

public class PersonTableModel extends util.GenericTableModel<Person> {

    private PersonDao dao = new PersonDao();
    private String kind;

    public PersonTableModel(String kind) {
        this.kind = kind;
        
        switch (kind) {
            case "supplier":
                this.columns = new String[] { "Razão Social", "Nome Fantasia", "CNPJ", "IE" };
                break;
            default:
                this.columns = new String[] { "Nome", "Apelido", "CPF", "RG" };
        }

        reload();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
        case 0:
            return String.class;
        case 1:
            return String.class;
        case 2:
            return String.class;
        case 3:
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
            return person.getLegalName();
        case 1:
            return person.getName();
        case 2:
            return person.getDocument1();
        case 3:
            return person.getDocument2();
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
    public final void reload() {
        addItems(dao.list(kind));
    }

}
