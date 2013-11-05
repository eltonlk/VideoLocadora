package service;

import dao.PersonDao;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Person;

public class PersonService {

    private PersonDao dao;
    
    public PersonService() {
        dao = new PersonDao();
    }
    
    public boolean save(Person person) {
        if (person.isValid()) {
            if (person.getId() == 0) {
                dao.insert(person);
            } else {
                dao.update(person);
            }           
            return true;
        } else {
            return false;
        }
    }
    
    public List<Person> getByKind(String kind) {
        try {
            return dao.getByKind(kind);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersonService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PersonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void destroy(Person person) {
        dao.delete(person);
    }
    
}
