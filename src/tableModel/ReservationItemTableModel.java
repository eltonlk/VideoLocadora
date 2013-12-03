package tableModel;

import model.ReservationItem;

public class ReservationItemTableModel extends util.GenericTableModel<ReservationItem> {

    public ReservationItemTableModel() {
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
        ReservationItem reservationItem = rows.get(rowIndex);

        switch (columnIndex) {
        case 0: 
            return reservationItem.getMedia().getMediaId();
        case 1: 
            return reservationItem.getMedia().getMovie().getTitle();
        case 2: 
            return reservationItem.getMedia().getKind();
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