package tableModel;

import model.Genre;

public class GenreTableModel extends util.GenericTableModel<Genre> {

    public GenreTableModel() {
        this.columns = new String[] { "Nome" };
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
        Genre genre = rows.get(rowIndex);

        switch (columnIndex) {
        case 0: 
            return genre.getName();
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