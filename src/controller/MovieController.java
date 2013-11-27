package controller;

import javax.swing.JDesktopPane;
import view.movies.*;

public class MovieController extends util.GenericController<model.Movie> {

    public MovieController(JDesktopPane pane) {
        this.pane = pane;
    }    

    @Override
    public void list() {
        MoviesInternalFrame frame = new MoviesInternalFrame();
        
        showFrame(frame);
    }
   
}
