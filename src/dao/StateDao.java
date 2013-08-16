package dao;

import framework.CreateDaoException;
import framework.DaoHelper;

import model.State;

public class StateDao {
    
    private DaoHelper daoHelper; 
    
    public StateDao() {
        daoHelper = new DaoHelper();
    }
    
    public void insert(State state) throws CreateDaoException {
        try {
            daoHelper.begingTransaction();
                        
            String query = "INSERT INTO states (name, country_id) VALUES ( ?, ? )";           
           
            int id = daoHelper.executePreparedUpdateAndReturnGenerateKeys(
                query, 
                state.getName(),
                state.getCountry().getId());                    
            
            state.setId(id);
            
            daoHelper.endTransaction();          
        } catch (Exception e) {
           daoHelper.rollbackTransaction();
            
           throw new CreateDaoException("Não foi possivel realizar a tranzação.", e);
        }        
    }        
    
}
