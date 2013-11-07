package service;

import dao.MovieDao;
import java.util.List;
import model.Movie;

public class MovieService {

    private final MovieDao dao;
    
    public MovieService() {
        dao = new MovieDao();
    }
    
    public boolean save(Movie movie) {
        if (movie.isValid()) {
            if (movie.getId() == 0) {
                dao.insert(movie);
            } else {
                dao.update(movie);
            }           
            return true;
        } else {
            return false;
        }
    }
    
    public List<Movie> getAll() {
        return dao.getAll();
    }

    public void destroy(Movie movie) {
        dao.delete(movie);
    }
    
}
