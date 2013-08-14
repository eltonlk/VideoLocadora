package dao;

import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {
    
    public User insert(User user) {
        System.out.println("Tentando conectar ao DB");
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/video_locadora", "root", "");
        
            ps = con.prepareStatement("INSERT INTO users (person_id, login, password, email) VALUES (?, ?, ?, ?)");
            ps.setLong(1, user.getPerson_id());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            user.setId(rs.getLong(1));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return user;
    }
    
}
