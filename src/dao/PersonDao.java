package dao;

import framework.dao.CreateDaoException;
import framework.dao.DaoHelper;
import framework.dao.DeleteDaoException;
import framework.dao.UpdateDaoException;

import model.Person;
import model.Address;

public class PersonDao {
    
    private DaoHelper daoHelper;
    
    public PersonDao() {
        daoHelper = new DaoHelper();
    }
    
    public void insert(Person person) throws CreateDaoException {
        try {
            daoHelper.begingTransaction();
                        
            String query = "INSERT INTO people (name, legal_name, kind, document_1, document_2, email, phone, cel, status) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";           
           
            long id = daoHelper.executePreparedUpdateAndReturnGenerateKeys(
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
            
           throw new CreateDaoException("Não foi possivel realizar a tranzação.", e);
        }
    }
    
    public void insertAddress(Person person) {
        Address address = person.getAddress();
            
        new AddressDao().insert(address);
    }

    public void update(Person person) throws UpdateDaoException {
        try {
            daoHelper.begingTransaction();
                        
            String query = "UPDATE people SET name = ?, legal_name = ?, kind = ?, document_1 = ?, document_2 = ?, email = ?, phone = ?, cel = ?, status = ? WHERE id = ?";           
           
            daoHelper.executePreparedUpdate(
                query, 
                person.getName(), 
                person.getLegalName(),    
                person.getKind(),
                person.getDocument1(),
                person.getDocument2(),
                person.getEmail(),
                person.getPhone(),
                person.getCel(),
                person.getStatus(),
                person.getId());                    
            
            updateAddress(person);
            
            daoHelper.endTransaction();          
        } catch (Exception e) {
           daoHelper.rollbackTransaction();
            
           throw new UpdateDaoException("Não foi possivel realizar a tranzação.", e);
        }        
    }    
    
    public void updateAddress(Person person) {
        Address address = person.getAddress();
            
        new AddressDao().update(address);
    }    
    
    public void delete(Person person) throws DeleteDaoException {
        try {
            daoHelper.begingTransaction();
                        
            String query = "DELETE FROM people WHERE id = ?";           
           
            daoHelper.executePreparedUpdate(
                query, 
                person.getId());                    
            
            deleteAddress(person);
            
            daoHelper.endTransaction();          
        } catch (Exception e) {
           daoHelper.rollbackTransaction();
            
           throw new DeleteDaoException("Não foi possivel realizar a tranzação.", e);
        }        
    }    
    
    public void deleteAddress(Person person) {
        Address address = person.getAddress();
            
        new AddressDao().delete(address);
    }     
}
