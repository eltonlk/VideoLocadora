package service;

import dao.PersonDao;
import java.util.List;
import model.Person;

public class PersonService {

    private PersonDao dao;
    
    public PersonService() {
        dao = new PersonDao();
    }
    
    public void save(Person person) {
        if (person.getId() == 0) {
            dao.insert(person);
        } else {
            dao.update(person);
        }        
    }
    
    public List<Person> getByKind(String kind) {
        return dao.getByKind(kind);
    }

    public void destroy(Person person) {
        dao.delete(person);
    }
    
}
