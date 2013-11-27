package controller;

import javax.swing.JDesktopPane;
import tableModel.ActorTableModel;

public class ActorController extends util.GenericController<model.Actor> {

    public ActorController(JDesktopPane pane) {
        this.pane = pane;
        this.dao = new dao.ActorDao();
        this.tableModel = new ActorTableModel();
    }
    
    
    
}
