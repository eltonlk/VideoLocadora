package controller;

import dao.CountryDao;
import javax.swing.JDesktopPane;
import model.Country;
import view.countries.*;

public class CountryController extends util.GenericController<Country> {

    private CountryDao dao = new CountryDao();
    private CountriesInternalFrame listFrame;
    
    public CountryController(JDesktopPane pane) {
        this.pane = pane;
    }    

    @Override
    public void list() {
        CountriesInternalFrame frame = new CountriesInternalFrame(this);
        
        showFrame(frame);
    }
   
    public void save(Country country) {
        
        System.out.println(country.getName());
        
        dao.save(country);
    }
    
}
