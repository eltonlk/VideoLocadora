package service;

import dao.GenreDao;
import java.util.List;
import model.Genre;

public class GenreService {
    
    private GenreDao dao;
    
    public GenreService() {
        dao = new GenreDao();
    }
    
    public boolean save(Genre genre) {
        if (genre.isValid()) {
            if (genre.getId() == 0) {
                dao.insert(genre);
            } else {
                dao.update(genre);
            }           
            return true;
        } else {
            return false;
        }
    }
    
    public List<Genre> getAll() {
        return dao.getAll();
    }

    public void destroy(Genre genre) {
        dao.delete(genre);
    }   
    
}
