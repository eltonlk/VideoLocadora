package controller;

import javax.swing.JDesktopPane;
import view.cities.*;

public class CityController extends util.GenericController<model.City> {

    public CityController(JDesktopPane pane) {
        this.pane = pane;
    }    

    @Override
    public void list() {
        CitiesInternalFrame frame = new CitiesInternalFrame();
        
        showFrame(frame);
    }
   
}
