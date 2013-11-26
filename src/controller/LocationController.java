package controller;

import javax.swing.JDesktopPane;
import tableModel.LocationTableModel;

public class LocationController extends util.GenericController<model.Location> {

    public LocationController(JDesktopPane pane) {
        this.pane = pane;
        this.dao = new dao.LocationDao();
        this.tableModel = new LocationTableModel();
    }    
   
}
