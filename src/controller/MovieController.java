package controller;

import dao.MovieDao;
import javax.swing.JDesktopPane;
import model.Movie;
import view.movies.*;

public class MovieController extends util.GenericController<Movie> {

    private MoviesInternalFrame listFrame;

    public MovieController(JDesktopPane pane) {
        this.pane = pane;
        this.dao = new MovieDao();
    }

    @Override
    public void list() {
        this.listFrame = new MoviesInternalFrame(this);

        showFrame(listFrame);
    }

}
