package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class GenreTableModel extends AbstractTableModel {

    private final List<Genre> genres;
    private final String[] columns = new String[] { "Código", "Nome", "Situação" };
    
    private static final int ID = 0;
    private static final int NAME = 1;   
    private static final int STATUS = 2;       
    
    public GenreTableModel() {
        this.genres = new ArrayList<>();
    }

    public GenreTableModel(List<Genre> genders) {
        this.genres = new ArrayList<>(genders); 
    }    
    
    @Override
    public int getRowCount() {
        return genres.size();
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
        case NAME:
            return String.class;
        case STATUS:
            return String.class;
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }    
    
//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        return columnIndex == ACTIVE;
//    }    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Genre genre = genres.get(rowIndex);

        switch (columnIndex) {
        case ID:
            return genre.getId();
        case NAME:
            return genre.getName();
        case STATUS:
            return genre.getStatus();
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }    

//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        Genre gender = genres.get(rowIndex);
//
//        switch (columnIndex) {
//        case ID:
//            gender.setId((int) aValue);
//            break;
//        case NAME:
//            gender.setName((String) aValue);
//            break;
//        case ACTIVE:
//            gender.setActive((boolean) aValue);
//        default:
//            throw new IndexOutOfBoundsException("columnIndex out of bounds");
//        }
//
//        fireTableCellUpdated(rowIndex, columnIndex);
//    }    

    public Genre getGenre(int index) {
        return genres.get(index);
    }

    public void addGenre(Genre genre) {
        int index = genres.indexOf(genre);

        if (index == -1) {
            genres.add(genre);
            
            index = getRowCount();
            
            fireTableRowsInserted(index, index);
        } else {
            genres.set(index, genre);

            fireTableRowsUpdated(index, index);
        }        
    }

//    public void removeGenre(int index) {
//        genres.remove(index);
//
//        fireTableRowsDeleted(index, index);
//    }
    
    public void removeGenre(Genre genre) {
        int index = genres.indexOf(genre);

        if (index != -1) {
            genres.remove(index);

            fireTableRowsDeleted(index + 1, index + 1);            
        }
    }     

//    public void addListOfGenres(List<Genre> genres) {
//        int index = getRowCount();
//
//        genres.addAll(genres);
//
//        fireTableRowsInserted(index, index + genres.size());
//    }

//    public void clear() {
//        genres.clear();
//
//        fireTableDataChanged();
//    }    
    
}
