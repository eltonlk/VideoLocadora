package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MediaTableModel extends AbstractTableModel {

    private final List<Media> medias;
    private final String[] columns = new String[] { "Código", "Título" };
    
    private static final int ID = 0;
    private static final int TITLE = 1;   

    public MediaTableModel() {
        this.medias = new ArrayList<>();
    }
    
    public MediaTableModel(List<Media> medias) {
        this.medias = new ArrayList<>(medias);
    }
    
    @Override
    public int getRowCount() {
        return this.medias.size();
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.columns[columnIndex];
    }    
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
        case ID:
            return int.class;
        case TITLE:
            return String.class;
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }     
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Media media = this.medias.get(rowIndex);

        switch (columnIndex) {
        case ID:
            return media.getId();
        case TITLE:
            return media.getKind();
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }     

    public List getItems() {
        return this.medias;
    }
    
    public Media getMedia(int index) {
        return this.medias.get(index);
    }

    public void addMedia(Media media) {
        int index = this.medias.indexOf(media);

        if (index == -1) {
            this.medias.add(media);
            
            index = getRowCount();
            
            fireTableRowsInserted(index, index);
        } else {
            this.medias.set(index, media);

            fireTableRowsUpdated(index, index);
        }
    }    

    public void removeMedia(Media media) {
        int index = this.medias.indexOf(media);

        if (index != -1) {
            this.medias.remove(index);

            fireTableRowsDeleted(index + 1, index + 1);            
        }
    }    
    
    public void addListOfMedias(List<Media> medias) {
        int index = getRowCount();

        this.medias.addAll(medias);

        fireTableDataChanged();
    }    
    
    public void clear() {
        this.medias.clear();

        fireTableDataChanged();
    }     
    
}
