package controller;

import javax.swing.JDesktopPane;
import view.genres.*;

public class GenreController extends util.GenericController<model.Genre> {

    public GenreController(JDesktopPane pane) {
        this.pane = pane;
    }    

    @Override
    public void list() {
        GenresInternalFrame frame = new GenresInternalFrame();
        
        showFrame(frame);
    }
   
}