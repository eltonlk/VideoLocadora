package dao;

import framework.CreateDaoException;
import framework.DaoHelper;
import java.io.IOException;
import java.sql.SQLException;

import model.City;

public class CityDao {
    
    private DaoHelper daoHelper;
    
    public CityDao() {
        daoHelper = new DaoHelper();
    }
    
    public void insert(City city) throws CreateDaoException {
        try {
            daoHelper.begingTransaction();
                        
            String query = "INSERT INTO cities (name, state_id) VALUES ( ?, ?, ? )";           
           
            int id = daoHelper.executePreparedUpdateAndReturnGenerateKeys(
                query, 
                city.getName(),
                city.getState().getId());                    
            
            city.setId(id);
            
            daoHelper.endTransaction();          
        } catch (SQLException | IOException e) {
           daoHelper.rollbackTransaction();
            
           throw new CreateDaoException("Não foi possivel realizar a tranzação.", e);
        }
    }    
    
}