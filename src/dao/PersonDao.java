package dao;

import framework.dao.DaoException;
import framework.dao.DaoHelper;

import model.Person;
import model.Address;

public class PersonDao {
    
    private DaoHelper daoHelper;
    
    public PersonDao() {
        daoHelper = new DaoHelper();
    }
    
    public Person insert(Person person) throws DaoException {
        try {
            daoHelper.begingTransaction();
                        
            String query = "INSERT INTO people (name, legal_name, kind, document_1, document_2, email, phone, cel, status) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";           
           
            long id = daoHelper.executePreparedUpdateAndReturnGenerateKeys(
                daoHelper.getConnectionFromContext(), 
                query, 
                person.getName(), 
                person.getLegalName(),    
                person.getKind(),
                person.getDocument1(),
                person.getDocument2(),
                person.getEmail(),
                person.getPhone(),
                person.getCel(),
                person.getStatus());                    
            
            person.setId(id);
            
            insertAddress(person);
            
            daoHelper.endTransaction();          
        } catch (Exception e) {
           daoHelper.rollbackTransaction();
            
           throw new DaoException("Não foi possivel realizar a tranzação.", e);
        }
        
        return person;
    }
    
    public void insertAddress(Person person) {
        Address address = person.getAddress();
            
        person.setAddress( new AddressDao().insert(address) );
    }
    
}
