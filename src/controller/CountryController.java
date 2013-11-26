package controller;

import javax.swing.JDesktopPane;
import tableModel.CountryTableModel;

public class CountryController extends util.GenericController<model.Country> {

    public CountryController(JDesktopPane pane) {
        this.pane = pane;
        this.dao = new dao.CountryDao();
        this.tableModel = new CountryTableModel();
    }    
   
}
