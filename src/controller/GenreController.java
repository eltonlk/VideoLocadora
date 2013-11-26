package controller;

import javax.swing.JDesktopPane;
import tableModel.GenreTableModel;

public class GenreController extends util.GenericController<model.Genre> {

    public GenreController(JDesktopPane pane) {
        this.pane = pane;
        this.dao = new dao.GenreDao();
        this.tableModel = new GenreTableModel();
    }    
   
}
