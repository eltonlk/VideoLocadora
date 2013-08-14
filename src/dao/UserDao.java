package dao;

import framework.dao.DaoException;
import framework.dao.DaoHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.User;

public class UserDao {
    
    private DaoHelper daoHelper;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    
    public UserDao() {
        daoHelper = new DaoHelper();
    }
    
    public User insert(User user) throws DaoException {
        try {
            conn = daoHelper.getConnection();
            
            pstmt = conn.prepareStatement("INSERT INTO users (person_id, login, password, email) VALUES ( ?, ?, ?, ? )");

            pstmt.setLong(1, user.getPerson_id());
            pstmt.setString(2, user.getLogin());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getEmail());

            pstmt.executeUpdate();
            
//            TODO: Setar o id do novo usuario na instancia de user.
//            user.setId(1);
        } catch (Exception e) {
           throw new DaoException("Não foi possivel realizar a tranzação.", e);
        } finally {
           daoHelper.releaseAll(conn, pstmt);
        }
        
        return user;
    }
    
}
