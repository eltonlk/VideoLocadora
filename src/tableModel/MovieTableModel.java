package tableModel;

import model.Movie;

public class MovieTableModel extends util.GenericTableModel<Movie> {

    public MovieTableModel() {
        this.columns = new String[] { "Título" };
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
        Movie movie = rows.get(rowIndex);

        switch (columnIndex) {
        case 0: 
            return movie.getTitle();
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