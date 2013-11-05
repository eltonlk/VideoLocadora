package dao;

import framework.CreateDaoException;
import framework.DaoHelper;
import java.io.IOException;
import java.sql.SQLException;

import model.State;

public class StateDao {
    
    private final DaoHelper daoHelper; 
    
    public StateDao() {
        daoHelper = new DaoHelper();
    }
    
    public void insert(State state) throws CreateDaoException {
        try {
            daoHelper.begingTransaction();
                        
            String query = "INSERT INTO states (name, country) VALUES ( ?, ? )";           
           
            int id = daoHelper.executePreparedUpdateAndReturnGenerateKeys(
                query, 
                state.getName(),
                state.getCountry());                    
            
            state.setId(id);
            
            daoHelper.endTransaction();          
        } catch (IOException | SQLException e) {
           daoHelper.rollbackTransaction();
            
           throw new CreateDaoException("Não foi possivel realizar a tranzação.", e);
        }        
    }        
    
}
