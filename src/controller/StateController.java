package controller;

import javax.swing.JDesktopPane;
import tableModel.StateTableModel;

public class StateController  extends util.GenericController<model.State> {

    public StateController(JDesktopPane pane) {
        this.pane = pane;
        this.dao = new dao.StateDao();
        this.tableModel = new StateTableModel();
    }    
   
}
