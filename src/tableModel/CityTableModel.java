package tableModel;

import model.City;

public class CityTableModel extends util.GenericTableModel<City> {

    public CityTableModel() {
        this.columns = new String[] { "Nome", "CEP", "Estado" };
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
        City city = rows.get(rowIndex);

        switch (columnIndex) {
        case 0: 
            return city.getName();
        case 1: 
            return city.getZip();            
        case 2:
            return city.getState().getName();
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