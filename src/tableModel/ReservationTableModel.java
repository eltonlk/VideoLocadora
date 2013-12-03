package tableModel;

import model.Reservation;

public class ReservationTableModel extends util.GenericTableModel<Reservation> {

    public ReservationTableModel() {
        this.columns = new String[] { "Código", "Cliente" };
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
        Reservation reservation = rows.get(rowIndex);

        switch (columnIndex) {
        case 0: 
            return reservation.getReservationId();
        case 1: 
            return reservation.getPerson().getName();
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