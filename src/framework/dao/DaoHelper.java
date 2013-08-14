package framework.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoHelper {

    private static final ThreadLocal<Connection> context = new ThreadLocal<Connection>();
    
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
    
    public void begingTransaction() throws SQLException {
        Connection conn = getConnection();
        conn.setAutoCommit(false);
        context.set(conn);
    }
    
    public void endTransaction() throws SQLException {
        commit( getConnectionFromContext() );
        releaseTransaction();
    }
    
    public void releaseTransaction() throws SQLException {
        Connection conn = getConnectionFromContext();
        release(conn);
        context.remove();
    }
    
    public void commit(Connection conn) throws SQLException {
        conn.commit();
    }
    
    public Connection getConnectionFromContext() throws SQLException {
        Connection conn = context.get();
        
        if ( conn == null ) {
            throw new SQLException("Transação invalida.");
        } else if (conn.isClosed()) {
            throw new SQLException("Transação invalida. Conexção está fechada.");
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
