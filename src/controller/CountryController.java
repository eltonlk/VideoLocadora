package controller;

import dao.CountryDao;
import javax.swing.JDesktopPane;
import model.Country;
import tableModel.CountryTableModel;
import view.countries.*;

public class CountryController extends util.GenericController<Country> {

    private CountryDao dao = new CountryDao();
    private CountryTableModel tableModel;
    private CountriesInternalFrame listFrame;
    
    public CountryController(JDesktopPane pane) {
        this.pane = pane;
        this.tableModel = new CountryTableModel();
    }    

    @Override
    public void list() {
        CountriesInternalFrame frame = new CountriesInternalFrame(this);
        
        this.tableModel.addItems(dao.list());
        
        showFrame(frame);
    }
   
    public void save(Country country) {
        if (dao.save(country)) {
            this.tableModel.addItems(dao.list());
        } else {
            
        }
    }

    public CountryTableModel getTableModel() {
        return tableModel;
    }
    
}
