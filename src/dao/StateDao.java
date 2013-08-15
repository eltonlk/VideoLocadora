package dao;

import framework.dao.CreateDaoException;
import framework.dao.DaoHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.State;

public class StateDao {
    
    private DaoHelper daoHelper;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rset = null;    
    
    public StateDao() {
        daoHelper = new DaoHelper();
    }
    
    public State insert(State state) throws CreateDaoException {
        try {
            conn = daoHelper.getConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO states (name, country_id) VALUES ( ?, ? )", 
                    PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, state.getName());
            pstmt.setLong(1, state.getCountryId());            
            
            pstmt.executeUpdate();
            
            rset = pstmt.getGeneratedKeys();
            
            if (rset.next()) {
                state.setId(rset.getLong("id"));
            }
        } catch (Exception e) {
           throw new CreateDaoException("Não foi possivel realizar a tranzação.", e);
        } finally {
           daoHelper.releaseAll(conn, pstmt);
        }
        
        return state;
    }        
    
}
