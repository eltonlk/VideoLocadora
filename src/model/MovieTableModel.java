package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MovieTableModel extends AbstractTableModel {

    private final List<Movie> movies;
    private final String[] columns = new String[] { "Código", "Título", "Lançado em" };
    
    private static final int ID = 0;
    private static final int TITLE = 1;   
    private static final int RELEASE_AT = 2;   

    public MovieTableModel() {
        this.movies = new ArrayList<>();
    }
    
    public MovieTableModel(List<Movie> movies) {
        this.movies = new ArrayList<>(movies);
    }
    
    @Override
    public int getRowCount() {
        return movies.size();
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
        case TITLE:
            return String.class;
        case RELEASE_AT:
            return Date.class;            
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }     
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Movie movie = movies.get(rowIndex);

        switch (columnIndex) {
        case ID:
            return movie.getId();
        case TITLE:
            return movie.getTitle();
        case RELEASE_AT:
            return movie.getReleaseIn();
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }     

    public Movie getMovie(int index) {
        return movies.get(index);
    }

    public void addMovie(Movie movie) {
        int index = movies.indexOf(movie);

        if (index == -1) {
            movies.add(movie);
            
            index = getRowCount();
            
            fireTableRowsInserted(index, index);
        } else {
            movies.set(index, movie);

            fireTableRowsUpdated(index, index);
        }
    }    

    public void removeMovie(Movie movie) {
        int index = movies.indexOf(movie);

        if (index != -1) {
            movies.remove(index);

            fireTableRowsDeleted(index + 1, index + 1);            
        }
    }    
    
}
