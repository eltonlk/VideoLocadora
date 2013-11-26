package controller;

import javax.swing.JDesktopPane;
import tableModel.PersonTableModel;

public class PersonController extends util.GenericController<model.Person> {

    public PersonController(JDesktopPane pane) {
        this.pane = pane;
        this.dao = new dao.PersonDao();
        this.tableModel = new PersonTableModel();
    }    
   
}
