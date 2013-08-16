package dao;

import framework.CreateDaoException;
import framework.DaoHelper;

import model.Country;

public class CountryDao {
    
    private DaoHelper daoHelper;
    
    public CountryDao() {
        daoHelper = new DaoHelper();
    }
    
    public void insert(Country country) throws CreateDaoException {
        try {
            daoHelper.begingTransaction();
                        
            String query = "INSERT INTO countries (name) VALUES ( ? )";           
           
            int id = daoHelper.executePreparedUpdateAndReturnGenerateKeys(
                query, 
                country.getName());                    
            
            country.setId(id);
            
            daoHelper.endTransaction();          
        } catch (Exception e) {
           daoHelper.rollbackTransaction();
            
           throw new CreateDaoException("Não foi possivel realizar a tranzação.", e);
        }
    }    
    
}
