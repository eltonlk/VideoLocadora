package service;

import dao.GenreDao;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            return dao.getAll();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenreService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GenreService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void destroy(Genre genre) {
        dao.delete(genre);
    }   
    
}
