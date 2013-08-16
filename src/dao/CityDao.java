package dao;

import framework.CreateDaoException;
import framework.DaoHelper;

import model.City;

public class CityDao {
    
    private DaoHelper daoHelper;
    
    public CityDao() {
        daoHelper = new DaoHelper();
    }
    
    public void insert(City city) throws CreateDaoException {
        try {
            daoHelper.begingTransaction();
                        
            String query = "INSERT INTO cities (name, zip, state_id) VALUES ( ?, ?, ? )";           
           
            int id = daoHelper.executePreparedUpdateAndReturnGenerateKeys(
                query, 
                city.getName(),
                city.getZip(),
                city.getState().getId());                    
            
            city.setId(id);
            
            daoHelper.endTransaction();          
        } catch (Exception e) {
           daoHelper.rollbackTransaction();
            
           throw new CreateDaoException("Não foi possivel realizar a tranzação.", e);
        }
    }    
    
}