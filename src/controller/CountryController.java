package controller;

import javax.swing.JDesktopPane;
import view.countries.*;

public class CountryController extends util.GenericController<model.Country> {

    public CountryController(JDesktopPane pane) {
        this.pane = pane;
    }    

    @Override
    public void list() {
        CountriesInternalFrame frame = new CountriesInternalFrame();
        
        showFrame(frame);
    }
   
}
