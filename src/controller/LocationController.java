package controller;

import javax.swing.JDesktopPane;
import view.locations.*;

public class LocationController extends util.GenericController<model.Location> {

    public LocationController(JDesktopPane pane) {
        this.pane = pane;
    }    

    @Override
    public void list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void newLocation() {
        LocationInternalFrame frame = new LocationInternalFrame(this);

        showFrame(frame);
    }
   
}
