package tableModel;

import dao.MovieDao;
import java.util.Date;
import model.Movie;

public class MovieTableModel extends util.GenericTableModel<Movie> {

    private MovieDao dao = new MovieDao();

    public MovieTableModel() {
        this.columns = new String[] { "Título", "Tipo", "Genero", "Data de Lançamento" };

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
            return Date.class;
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
        case 1:
            return movie.getKind();
        case 2:
            if (movie.getGenre() == null) return null;

            return movie.getGenre().getName();
        case 3:
            return movie.getReleasedIn();
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
        addItems(dao.list());
    }

}