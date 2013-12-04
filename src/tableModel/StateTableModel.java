package tableModel;

import dao.StateDao;
import model.State;

public class StateTableModel extends util.GenericTableModel<State> {

    private StateDao dao = new StateDao();

    public StateTableModel() {
        this.columns = new String[] { "Nome", "País" };

        reload();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
        case 0:
            return String.class;
        case 1:
            return String.class;
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        State state = rows.get(rowIndex);

        switch (columnIndex) {
        case 0:
            return state.getName();
        case 1:
            if (state.getCountry() == null) return null;

            return state.getCountry().getName();
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
