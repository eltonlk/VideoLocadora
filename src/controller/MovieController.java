package controller;

import javax.swing.JDesktopPane;
import tableModel.MovieTableModel;

public class MovieController extends util.GenericController<model.Movie> {

    public MovieController(JDesktopPane pane) {
        this.pane = pane;
        this.dao = new dao.MovieDao();
        this.tableModel = new MovieTableModel();
    }    
   
}
