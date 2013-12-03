package tableModel;

import model.LocationItem;

public class LocationItemTableModel extends util.GenericTableModel<LocationItem> {

    public LocationItemTableModel() {
        this.columns = new String[] { "Código", "Filme", "Tipo" };
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
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LocationItem locationItem = rows.get(rowIndex);

        switch (columnIndex) {
        case 0: 
            return locationItem.getMedia().getMediaId();
        case 1: 
            return locationItem.getMedia().getMovie().getTitle();
        case 2: 
            return locationItem.getMedia().getKind();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}