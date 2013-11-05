package dao;

import framework.CreateDaoException;
import framework.DaoHelper;
import framework.DeleteDaoException;
import framework.UpdateDaoException;

import java.sql.SQLException;

import model.PersonAddress;

public class PersonAddressDao {

    private final DaoHelper daoHelper;
        
    public PersonAddressDao() {
        daoHelper = new DaoHelper();
    }
    
    public void insert(PersonAddress address) throws CreateDaoException {
        try {
            String query = "INSERT INTO addresses (district, person_id, address) VALUES ( ?, ?, ? )";           
           
            int id = daoHelper.executePreparedUpdateAndReturnGenerateKeys(
                query, 
                address.getDistrict(), 
                address.getPerson(),    
                address.getAddress());                    
            
            address.setId(id);            
        } catch (SQLException e) {
           daoHelper.rollbackTransaction();
            
           throw new CreateDaoException("Não foi possivel realizar a tranzação.", e);
        } 
    }    
    
    public void update(PersonAddress address) throws UpdateDaoException {
        try {
            String query = "UPDATE addresses SET district = ?, person_id = ?, address = ? WHERE id = ?";  
            
            daoHelper.executePreparedUpdate(
                query, 
                address.getDistrict(), 
                address.getPerson(),    
                address.getAddress(),
                address.getId());
        } catch (SQLException e) {
            daoHelper.rollbackTransaction();
        }
    }
    
    public void delete(PersonAddress address) throws DeleteDaoException {
        try {
            String query = "DELETE FROM addresses WHERE id = ?";  
            
            daoHelper.executePreparedUpdate(query, address.getId());
        } catch (SQLException e) {
            daoHelper.rollbackTransaction();
        }
    }    
    
}
