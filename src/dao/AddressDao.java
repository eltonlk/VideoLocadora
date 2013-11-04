package dao;

import framework.CreateDaoException;
import framework.DaoHelper;
import framework.DeleteDaoException;
import framework.UpdateDaoException;

import java.sql.SQLException;

import model.Address;

public class AddressDao {

    private DaoHelper daoHelper;
        
    public AddressDao() {
        daoHelper = new DaoHelper();
    }
    
    public void insert(Address address) throws CreateDaoException {
        try {
            String query = "INSERT INTO addresses (district_id, person_id, address, location) VALUES ( ?, ?, ?, ? )";           
           
            int id = daoHelper.executePreparedUpdateAndReturnGenerateKeys(
                query, 
                address.getDistrict().getId(), 
                address.getPersonId(),    
                address.getAddress(),
                address.getLocation());                    
            
            address.setId(id);            
        } catch (SQLException e) {
           daoHelper.rollbackTransaction();
            
           throw new CreateDaoException("Não foi possivel realizar a tranzação.", e);
        } 
    }    
    
    public void update(Address address) throws UpdateDaoException {
        try {
            String query = "UPDATE addresses SET district_id = ?, person_id = ?, address = ?, location = ? WHERE id = ?";  
            
            daoHelper.executePreparedUpdate(
                query, 
                address.getDistrict().getId(), 
                address.getPersonId(),    
                address.getAddress(),
                address.getLocation(),  
                address.getId());
        } catch (SQLException e) {
            daoHelper.rollbackTransaction();
        }
    }
    
    public void delete(Address address) throws DeleteDaoException {
        try {
            String query = "DELETE FROM addresses WHERE id = ?";  
            
            daoHelper.executePreparedUpdate(query, address.getId());
        } catch (SQLException e) {
            daoHelper.rollbackTransaction();
        }
    }    
    
}
