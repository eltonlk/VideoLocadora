package framework.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoHelper {

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/video_locadora", "root", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        return conn;
    }

    public void release(Connection conn) {
        if (conn == null) return;
        
        try {
            conn.close();
        } catch (SQLException e) { 
        }        
    }        
    
    public void release(Statement stmt) {
        if (stmt == null) return;
        
        try {
            stmt.close();
        } catch (SQLException e) { 
        }        
    }
   
    public void release(ResultSet rs) {
        if (rs == null) return;
        
        try {
            rs.close();
        } catch (SQLException e) { 
        }        
    }    
    
    public void releaseAll(Connection conn, Statement stmt) {
        release(stmt);   
        release(conn);
    }
    
    public void releaseAll(Connection conn, Statement stmt, ResultSet rs) {
        release(rs);
        releaseAll(conn, stmt);
    }    
    
}
