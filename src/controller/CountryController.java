package controller;

import dao.CountryDao;
import javax.swing.JDesktopPane;
import model.Country;
import view.countries.*;

public class CountryController extends util.GenericController<Country> {

    private CountriesInternalFrame listFrame;
    
    public CountryController(JDesktopPane pane) {
        this.pane = pane;
        this.dao = new CountryDao();
    }    

    @Override
    public void list() {
        this.listFrame = new CountriesInternalFrame(this);
        
        showFrame(listFrame);
    }
    
}
