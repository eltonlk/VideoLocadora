package controller;

import dao.GenreDao;
import javax.swing.JDesktopPane;
import model.Genre;
import view.genres.*;

public class GenreController extends util.GenericController<Genre> {

    private GenresInternalFrame listFrame;

    public GenreController(JDesktopPane pane) {
        this.pane = pane;
        this.dao = new GenreDao();
    }

    @Override
    public void list() {
        this.listFrame = new GenresInternalFrame(this);

        showFrame(listFrame);
    }

}
