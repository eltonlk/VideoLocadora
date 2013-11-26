package tableModel;

import model.Media;

public class MediaTableModel extends util.GenericTableModel<Media> {

    public MediaTableModel() {
        this.columns = new String[] { "Código", "Tipo" };
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
        Media media = rows.get(rowIndex);

        switch (columnIndex) {
        case 0: 
            return media.getMediaId();
        case 1: 
            return media.getKind();
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