package dao;

import framework.CreateDaoException;
import framework.DaoHelper;

import model.District;

public class DistrictDao {
    
    private DaoHelper daoHelper;
    
    public DistrictDao() {
        daoHelper = new DaoHelper();
    }
    
    public void insert(District district) throws CreateDaoException {
        try {
            daoHelper.begingTransaction();
                        
            String query = "INSERT INTO districts (name, city_id) VALUES ( ?, ? )";           
           
            int id = daoHelper.executePreparedUpdateAndReturnGenerateKeys(
                query, 
                district.getName(),
                district.getCity().getId());                    
            
            district.setId(id);
            
            daoHelper.endTransaction();          
        } catch (Exception e) {
           daoHelper.rollbackTransaction();
            
           throw new CreateDaoException("Não foi possivel realizar a tranzação.", e);
        }
    }    
    
}
