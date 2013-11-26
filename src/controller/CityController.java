package controller;

import javax.swing.JDesktopPane;
import tableModel.CityTableModel;

public class CityController extends util.GenericController<model.City> {

    public CityController(JDesktopPane pane) {
        this.pane = pane;
        this.dao = new dao.CityDao();
        this.tableModel = new CityTableModel();
    }    
   
}
