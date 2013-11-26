package tableModel;

import model.State;

public class StateTableModel extends util.GenericTableModel<State> {

    public StateTableModel() {
        this.columns = new String[] { "Nome", "País" };
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
    
}