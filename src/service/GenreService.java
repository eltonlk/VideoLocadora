package service;

import dao.GenreDao;
import java.util.List;
import model.Genre;

public class GenreService {
    
    private GenreDao dao;
    
    public GenreService() {
        dao = new GenreDao();
    }
    
    public void save(Genre genre) {
        if (genre.getId() == 0) {
            dao.insert(genre);
        } else {
            dao.update(genre);
        }        
    }
    
    public List<Genre> getAll() {
        return dao.getAll();
    }

    public void destroy(Genre genre) {
        dao.delete(genre);
    }   
    
}
