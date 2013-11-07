package dao;

import framework.CreateDaoException;
import framework.DaoHelper;
import framework.DeleteDaoException;
import framework.QueryMapping;
import framework.UpdateDaoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Person;
import model.PersonAddress;

public class PersonDao {
    
    private final DaoHelper daoHelper;
    
    public PersonDao() {
        daoHelper = new DaoHelper();
    }
    
    public void insert(Person person) throws CreateDaoException {
        try {
            daoHelper.begingTransaction();
                        
            String query = "INSERT INTO people (name, legal_name, kind, document_1, document_2, email, phone, cel, status) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";           
           
            int id = daoHelper.executePreparedUpdateAndReturnGenerateKeys(
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
        } catch (SQLException | IOException e) {
           daoHelper.rollbackTransaction();
            
           throw new CreateDaoException("Não foi possivel realizar a tranzação.", e);
        }
    }
    
    public void insertAddress(Person person) {
        PersonAddress address = person.getAddress();
            
        if ( address != null ) {   
            new PersonAddressDao().insert(address);
        }
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
        } catch (SQLException | IOException e) {
           daoHelper.rollbackTransaction();
            
           throw new UpdateDaoException("Não foi possivel realizar a tranzação.", e);
        }        
    }    
    
    public void updateAddress(Person person) {
        PersonAddress address = person.getAddress();
        
        if ( address != null ) {   
            new PersonAddressDao().update(address);
        }
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
        } catch (SQLException | IOException e) {
           daoHelper.rollbackTransaction();
            
           throw new DeleteDaoException("Não foi possivel realizar a tranzação.", e);
        }        
    }    
    
    public void deleteAddress(Person person) {
        PersonAddress address = person.getAddress();
        
        if ( address != null ) {   
            new PersonAddressDao().delete(address);
        }
    }   

    public Person getById(int id) {
        final Person person = new Person();
        String query = "SELECT * FROM people WHERE id = ?";
        
        try {
            daoHelper.executePreparedQuery(query,
                new QueryMapping<Person>() {
                    @Override
                    public void mapping(ResultSet rset) throws SQLException {
                        if (rset.next()) {
                            person.setId( rset.getInt("id") );
                            person.setName( rset.getString("name") );
                            person.setLegalName( rset.getString("legal_name") );
                            person.setKind( rset.getString("kind") );
                            person.setDocument1( rset.getString("document_1") );
                            person.setDocument2( rset.getString("document_2") );
                            person.setEmail( rset.getString("email") );
                            person.setPhone( rset.getString("phone") );
                            person.setCel( rset.getString("cel") );
                            person.setStatus( rset.getString("status") );                                
                        }
                    }
                },
                id);
        } catch (SQLException | IOException ex) { }
        
        return person; 
    }       
    
    
    public List<Person> getByKind(String kind) throws FileNotFoundException, IOException {
        final List<Person> people = new ArrayList<>();

        try {
            String query = "SELECT * FROM people WHERE kind = ?"; 
           
            daoHelper.executePreparedQuery(query, 
                    new QueryMapping<Person>() {
                        @Override
                        public void mapping(ResultSet rset) throws SQLException {
                            while (rset.next()) {
                                
                                Person person = new Person();
                                person.setId( rset.getInt("id") );
                                person.setName( rset.getString("name") );
                                person.setLegalName( rset.getString("legal_name") );
                                person.setKind( rset.getString("kind") );
                                person.setDocument1( rset.getString("document_1") );
                                person.setDocument2( rset.getString("document_2") );
                                person.setEmail( rset.getString("email") );
                                person.setPhone( rset.getString("phone") );
                                person.setCel( rset.getString("cel") );
                                person.setStatus( rset.getString("status") );

                                people.add(person);
                            }
                        }
                    },
                    kind);
        } catch (SQLException e) { }
        
        return people; 
    }
}
