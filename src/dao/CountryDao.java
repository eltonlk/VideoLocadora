package dao;

import framework.dao.CreateDaoException;
import framework.dao.DaoHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Country;

public class CountryDao {
    
    private DaoHelper daoHelper;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rset = null;    
    
    public CountryDao() {
        daoHelper = new DaoHelper();
    }
    
    public Country insert(Country country) throws CreateDaoException {
        try {
            conn = daoHelper.getConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO countries (name) VALUES ( ? )", 
                    PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, country.getName());
            
            pstmt.executeUpdate();
            
            rset = pstmt.getGeneratedKeys();
            
            if (rset.next()) {
                country.setId(rset.getLong("id"));
            }
        } catch (Exception e) {
           throw new CreateDaoException("Não foi possivel realizar a tranzação.", e);
        } finally {
           daoHelper.releaseAll(conn, pstmt);
        }
        
        return country;
    }    
    
}
