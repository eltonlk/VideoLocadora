package controller;

import dao.MovieDao;
import model.Movie;

public class MovieController {

    private static final MovieDao dao = new MovieDao();
    
    public static void list() {
    }

    public static void add() {
    }

    public static void edit() {
    }

    public static void create(Movie movie) {
        dao.save(movie);
    }

    public static void update(Movie movie) {
        dao.save(movie);
    }

    public static void destroy(Movie movie) {
        dao.destroy(movie);
    }

}
