package tableModel;

import dao.CountryDao;
import model.Country;

public class CountryTableModel extends util.GenericTableModel<Country> {

    private CountryDao dao = new CountryDao();
    
    public CountryTableModel() {
        this.columns = new String[] { "Nome", "Sigla", "Nacionalidade" };
        
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
        default:
            throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Country country = rows.get(rowIndex);

        switch (columnIndex) {
        case 0: 
            return country.getName();
        case 1: 
            return country.getAcronym();
        case 2: 
            return country.getNationality();            
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