package dao;

import framework.dao.CreateDaoException;
import framework.dao.DaoHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

public class UserDao {
    
    private DaoHelper daoHelper;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rset = null;
    
    public UserDao() {
        daoHelper = new DaoHelper();
    }
    
    public User insert(User user) throws CreateDaoException {
        try {
            conn = daoHelper.getConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO users (person_id, login, password, email) VALUES ( ?, ?, ?, ? )", 
                    PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setLong(1, user.getPerson_id());
            pstmt.setString(2, user.getLogin());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getEmail());

            pstmt.executeUpdate();
            
            rset = pstmt.getGeneratedKeys();
            
            if (rset.next()) {
                user.setId(rset.getLong("id"));
            }
        } catch (Exception e) {
           throw new CreateDaoException("Não foi possivel realizar a tranzação.", e);
        } finally {
           daoHelper.releaseAll(conn, pstmt);
        }
        
        return user;
    }
    
}
